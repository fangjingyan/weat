package com.example.olivia.weat;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectRestaurantFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private Map<String, Integer> buttonflag = new HashMap<String, Integer>(){{
        put("Chinese", 0);
        put("Korean", 0);
        put("Japanese", 0);
        put("Western", 0);
        put("Fastfood", 0);
        put("Others", 0);

    }};

    private List<Integer> buttons = new ArrayList<Integer>(){{
        add(R.id.Chinese); add(R.id.Korean); add(R.id.Japanese);
        add(R.id.Western); add(R.id.Fastfood); add(R.id.Others);
        add(R.id.D1); add(R.id.D2); add(R.id.D3);
        add(R.id.S1); add(R.id.S2); add(R.id.S3);
    }};
    private List<Integer> categorybuttons = new ArrayList<Integer>(){{
        add(R.id.Chinese); add(R.id.Korean); add(R.id.Japanese);
    }};
    private List<Integer> pricebuttons = new ArrayList<Integer>(){{
        add(R.id.D1); add(R.id.D2); add(R.id.D3);
    }};
    private List<Integer> ratingbuttons = new ArrayList<Integer>(){{
        add(R.id.S1); add(R.id.S2); add(R.id.S3);
    }};


    private String categoryMessage = "";
    private String priceMessage = "";
    private String ratingMessage = "";


    public SelectRestaurantFragment() {
        // Required empty public constructor
    }


    public static SelectRestaurantFragment newInstance(String param1, String param2) {
        SelectRestaurantFragment fragment = new SelectRestaurantFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_restaurant, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        for(int id : buttons)
            setButtonFunction(id);

        //set submit function
        Button submit = getActivity().findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction(Uri.parse(categoryMessage + priceMessage + ratingMessage));

            }
        });
    }

    public void setButtonFunction(int buttonID){
        Button eachButton = getActivity().findViewById(buttonID);
        eachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(categorybuttons.contains(v.getId())) {
                    getcategory(v);
                }
                else if (pricebuttons.contains(v.getId())){
                    getprice(v);
                }
                else if (ratingbuttons.contains(v.getId())){
                    getrating(v);
                }

            }
        });
    }

    public void getcategory(View view){
        String resname = getResources().getResourceEntryName(view.getId());
        Log.d("resname", resname);
        if(buttonflag.get(resname) == 0){
            buttonflag.put(resname, 1);
            categoryMessage = categoryMessage + resname;
        }
        else{
            buttonflag.put(resname, 0);
            categoryMessage = categoryMessage.replace(resname, "");
        }
    }

    public void getprice(View view){
        String resname = getResources().getResourceEntryName(view.getId());
        priceMessage = resname.replace("D", "price:");
    }


    public void getrating(View view){
        String resname = getResources().getResourceEntryName(view.getId());
        priceMessage = resname.replace("S", "rating:");
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}



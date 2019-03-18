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
public class SelectIngredientFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private SelectIngredientFragment.OnFragmentInteractionListener1 mListener;

    private Map<String, Integer> mealbuttonflag = new HashMap<String, Integer>(){{
        put("Pork", 0);
        put("Beef", 0);
        put("Fish", 0);
        put("Mutton", 0);
        put("Chicken", 0);
        put("Egg", 0);
    }};

    private Map<String, Integer> vegetablebuttonflag = new HashMap<String, Integer>(){{
        put("Potato", 0);
        put("Tomato", 0);
        put("Cabbage", 0);
        put("Onion", 0);
        put("Spinach", 0);
        put("Green_pepper", 0);
        put("Corn", 0);
        put("Broccoli", 0);
        put("Dou_fu", 0);
    }};

    private List<Integer> buttons = new ArrayList<Integer>(){{
        add(R.id.Pork); add(R.id.Beef); add(R.id.Fish);
        add(R.id.Mutton); add(R.id.Chicken); add(R.id.Egg);
        add(R.id.Potato); add(R.id.Tomato); add(R.id.Cabbage);
        add(R.id.Onion); add(R.id.Spinach); add(R.id.Green_pepper);
        add(R.id.Corn); add(R.id.Broccoli); add(R.id.Dou_fu);
    }};

    private List<Integer> mealbuttons = new ArrayList<Integer>(){{
        add(R.id.Pork); add(R.id.Beef); add(R.id.Fish);
        add(R.id.Mutton); add(R.id.Chicken); add(R.id.Egg);
    }};

    private List<Integer> vegetablebuttons = new ArrayList<Integer>(){{
        add(R.id.Potato); add(R.id.Tomato); add(R.id.Cabbage);
        add(R.id.Onion); add(R.id.Spinach); add(R.id.Green_pepper);
        add(R.id.Corn); add(R.id.Broccoli); add(R.id.Dou_fu);
    }};

    private String mealMessage = "";
    private String vegetableMessage = "";

    public SelectIngredientFragment() {
        // Required empty public constructor
    }

    public static SelectIngredientFragment newInstance(String param1, String param2) {
        SelectIngredientFragment fragment = new SelectIngredientFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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
        return inflater.inflate(R.layout.fragment_select_ingredient, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        for(int id : buttons)
            setButtonFunction(id);

        //set submit function
        Button submit = getActivity().findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction1(Uri.parse(mealMessage + vegetableMessage));
            }
        });
    }

    public void setButtonFunction(int buttonID){
        Button eachButton = getActivity().findViewById(buttonID);
        eachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mealbuttons.contains(v.getId())) {
                    getmeal(v);
                }
                else if (vegetablebuttons.contains(v.getId())){
                    getvegetable(v);
                }
            }
        });
    }

    public void getmeal(View view){
        String resname = getResources().getResourceEntryName(view.getId());
        Log.d("resname", resname);
        if(mealbuttonflag.get(resname) == 0){
            mealbuttonflag.put(resname, 1);
            mealMessage = mealMessage +  "," +resname;
        }
        else{
            mealbuttonflag.put(resname, 0);
            mealMessage = mealMessage.replace(resname, "");
        }
    }

    public void getvegetable(View view){
        String resname = getResources().getResourceEntryName(view.getId());
        Log.d("resname", resname);
        if(vegetablebuttonflag.get(resname) == 0){
            vegetablebuttonflag.put(resname, 1);
            vegetableMessage = vegetableMessage + "," +resname;
        }
        else{
            vegetablebuttonflag.put(resname, 0);
            vegetableMessage = vegetableMessage.replace(resname, "");
        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction1(uri);
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
            mListener = (OnFragmentInteractionListener1) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface OnFragmentInteractionListener1 {
        // TODO: Update argument type and name
        void onFragmentInteraction1(Uri uri);}

}

package com.example.olivia.weat;


<<<<<<< HEAD
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
=======
import android.content.Intent;
>>>>>>> 2019.3.16 3:49PM prototype of third page
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlogFragment extends Fragment {

    LinearLayout ll;
<<<<<<< HEAD
    LinearLayout ll2;
    FloatingActionButton write;
    ListView mealsRecord;
    private OnFragmentInteractionListener mListener;
=======
    FloatingActionButton write;
    ListView mealsRecord;
>>>>>>> 2019.3.16 3:49PM prototype of third page


    public BlogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blog, container, false);
        ll = view.findViewById(R.id.linearLayout);
<<<<<<< HEAD
        ll2 = view.findViewById(R.id.linearLayout2);
=======
>>>>>>> 2019.3.16 3:49PM prototype of third page
        write = view.findViewById(R.id.Write);
        mealsRecord = view.findViewById(R.id.Meals);
        setUser();
        write.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent recordIntent = new Intent(getActivity(), RecordActivity.class);
                getActivity().startActivityForResult(recordIntent, 2);
            }
        });
        setMeals();
        return view;
<<<<<<< HEAD
    }

    public void setUser(){
        if(User.getUsername()==null){
            Button login = new Button(getContext());
            login.setText("Login");
            ll.addView(login);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    getActivity().startActivityForResult(intent, 1);
                }
            });
        }
        else{
            TextView user = new TextView(getContext());
            user.setText(User.getUsername());
            ll.addView(user);
            Button logout = new Button((getContext()));
            logout.setText("Logout");
            ll2.addView(logout);
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //transaction
                    mListener.onFragmentInteraction2();
                }
            });
        }
    }

    public void setMeals(){
        Map<String, String> meals = User.getMeals();
        ArrayList<String> records = new ArrayList<>();
        for(Map.Entry<String, String> entry : meals.entrySet()){
            String time = entry.getKey();
            String content = entry.getValue();
            records.add(time+"\n"+content);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, records);
        mealsRecord.setAdapter(adapter);
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
            mListener = (BlogFragment.OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction2();
    }



=======
    }

    public void setUser(){
        if(User.getUsername()==null){
            Button login = new Button(getContext());
            login.setText("Login");
            ll.addView(login);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    getActivity().startActivityForResult(intent, 1);
                }
            });
        }
        else{
            TextView user = new TextView(getContext());
            user.setText(User.getUsername());
            ll.addView(user);
        }
    }

    public void setMeals(){
        Map<String, String> meals = User.getMeals();
        ArrayList<String> records = new ArrayList<>();
        for(Map.Entry<String, String> entry : meals.entrySet()){
            String time = entry.getKey();
            String content = entry.getValue();
            records.add(time+content);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, records);
        mealsRecord.setAdapter(adapter);
    }
>>>>>>> 2019.3.16 3:49PM prototype of third page
}

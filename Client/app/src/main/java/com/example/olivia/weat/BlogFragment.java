package com.example.olivia.weat;


import android.content.Intent;
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
    FloatingActionButton write;
    ListView mealsRecord;


    public BlogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blog, container, false);
        ll = view.findViewById(R.id.linearLayout);
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
}

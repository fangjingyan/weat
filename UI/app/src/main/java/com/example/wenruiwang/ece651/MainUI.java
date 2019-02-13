package com.example.wenruiwang.ece651;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainUI extends AppCompatActivity {
    private String categoryMessage = "";
    private String priceMessage = "";
    private String ratingMessage = "";
    private String timeMessage = "";
    private String hourMessage = "";
    private String minuteMessage = "";
    private String apMessage = "";

    private Map<String, Integer> buttonflag = new HashMap<String, Integer>(){{
        put("Chinese", 0);
        put("Korean", 0);
        put("Japanese", 0);
        put("Fastfood", 0);
        put("Western", 0);
        put("Others", 0);
    }};

    private Spinner hour;
    private Spinner minute;
    private Spinner ap;

    private static Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ui);

        hour = findViewById(R.id.hour);
        minute = findViewById(R.id.minute);
        ap = findViewById(R.id.ap);
        hour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
                String[] hourAll = getResources().getStringArray(R.array.hour);
                hourMessage = hourAll[pos];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });
        minute.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
                String[] MinuteAll = getResources().getStringArray(R.array.minute);
                minuteMessage = MinuteAll[pos];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });
        ap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
                String[] apAll = getResources().getStringArray(R.array.ap);
                apMessage = apAll[pos];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });
    }

    public void sendChooseInfo(View view){
        timeMessage = hourMessage + minuteMessage + apMessage;
        new Thread(new SendChooseInfo()).start();
    }

    public class SendChooseInfo implements Runnable{
        @Override
        public void run(){
            List<String> allInfo = new ArrayList<String>();
            allInfo.add("category="+categoryMessage);
            allInfo.add("price="+priceMessage);
            allInfo.add("rating="+ratingMessage);
            allInfo.add("time="+timeMessage);
            String res = WebService.executeHttpGet(allInfo);
            //more operation required on processing return message
            //if true
            handler.post(new Runnable(){
                @Override
                public void run(){
                    Intent intent = new Intent(MainUI.this, TurnTable.class);
//                    add restaurant into it;
                    startActivity(intent);
                }
            });
        }
    }

    public void getcategory(View view){
        String resname = getResources().getResourceEntryName(view.getId());
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
        priceMessage = resname.replace("D", "");
    }
    public void getrating(View view){
        String resname = getResources().getResourceEntryName(view.getId());
        priceMessage = resname.replace("S", "");
    }
}

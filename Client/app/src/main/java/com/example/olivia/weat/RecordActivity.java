package com.example.olivia.weat;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class RecordActivity extends AppCompatActivity {

    private Button ok;
<<<<<<< HEAD
    private EditText date;
    private EditText day;
    private EditText sort;
=======
    private EditText time;
>>>>>>> 2019.3.16 3:49PM prototype of third page
    private EditText content;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ok = findViewById(R.id.OK);
<<<<<<< HEAD
        date = findViewById(R.id.date);
        day = findViewById(R.id.day);
        sort = findViewById(R.id.sort);
=======
        time = findViewById(R.id.time);
>>>>>>> 2019.3.16 3:49PM prototype of third page
        content = findViewById(R.id.content);
        ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new Thread(new RecordRunnable()).start();
            }
        });
    }

    public class RecordRunnable implements Runnable{
        @Override
<<<<<<< HEAD
        public void run() {
            Log.e("message", "into RecordRunnable");
            String timeString = null;
            String dateString = date.getText().toString();
            String dayString = day.getText().toString();
            String sortString = sort.getText().toString();
            String contentString = content.getText().toString();
            timeString = dateString + " " + dayString + " " +sortString;
            User.addMeal(timeString, contentString);
            if (User.getUsername() != null) {
                Map<String, String> record = new HashMap<>();
                record.put("Uid", User.getUserID());
                record.put("Date", dateString);
                record.put("Day", dayString);
                record.put("Meal", sortString);
                record.put("Content", contentString);
                Log.e("timeString", timeString);
                Log.e("contentString", contentString);
                final boolean success = WebService.executeHTTPGetAddRecord(record);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (success) {
                            Intent intent = new Intent();
                            setResult(RESULT_OK, intent);
                            finish();
                        } else
                            Toast.makeText(getBaseContext(), "unsuccessfully add record to account", Toast.LENGTH_LONG).show();
                    }
                });
            }
            else {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                            Intent intent = new Intent();
                            setResult(RESULT_OK, intent);
                            finish();
                    }
                });
            }

        }
    }

=======
        public void run(){
            Log.e("message", "into RecordRunnable");
            String timeString = time.getText().toString();
            String contentString = content.getText().toString();
            User.addMeal(timeString, contentString);
            if(User.getUsername() == null)
                return;
            Map<String, String> record = new HashMap<>();
            record.put(timeString, contentString);
            Log.e("timeString", timeString);
            Log.e("contentString", contentString);
            final boolean success = WebService.executeHTTPGetAddRecord(record);
            handler.post(new Runnable(){
                @Override
                public void run(){
                    if(success){
                        Intent intent = new Intent();
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                    else
                        Toast.makeText(getBaseContext(), "unsuccessfully add record to account", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
>>>>>>> 2019.3.16 3:49PM prototype of third page
}

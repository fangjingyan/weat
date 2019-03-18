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
    private EditText time;
    private EditText content;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        ok = findViewById(R.id.OK);
        time = findViewById(R.id.time);
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
}

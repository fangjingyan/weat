package com.example.wenruiwang.ece651;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    private String usernameMessage, passwordMessage;
    private String info = null;
    private static Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void sendLogin(View view){
        Log.d("Start", "now");
        EditText usernameText = findViewById(R.id.username);
        EditText passwordText = findViewById(R.id.password);

        usernameMessage = usernameText.getText().toString();
        passwordMessage = passwordText.getText().toString();

        Intent intent = new Intent(Login.this, MainUI.class);
        startActivity(intent);

//        new Thread(new LoginThread()).start();
    }

    public class LoginThread implements Runnable{
        @Override
        public void run(){
            Log.d(usernameMessage, passwordMessage);
            info = WebService.executeHttpGet(new ArrayList<String>(){{
                add("username=" + usernameMessage);
                add("password=" + passwordMessage);
            }});
            if( info != null)
                Log.d("return", info);
            else
                Log.d("return", "null");
            if( info != null && info.equals("1")) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Login.this, MainUI.class);
                        intent.putExtra("username", usernameMessage);
                        intent.putExtra("password", passwordMessage);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}

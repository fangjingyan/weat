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

public class LoginActivity extends AppCompatActivity {

    private Button login;
    private Button register;
    private EditText email;
    private EditText password;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                beginLogin();
            }
        });
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                beginRegister();
            }
        });
    }

    public void beginLogin(){
        new Thread(new LoginRunnable()).start();
    }

    public class LoginRunnable implements Runnable{
        @Override
        public void run(){
            email = findViewById(R.id.email);
            password = findViewById(R.id.password);
            String em = email.getText().toString();
            String pass = password.getText().toString();

            Map<String, String> loginInfo = new HashMap<>();
            loginInfo.put("Email", em);
            loginInfo.put("Password", pass);
            final boolean success = WebService.executeHTTPGetLogin(loginInfo);
            Log.e("User username", User.getUsername());
            handler.post(new Runnable(){
               @Override
               public void run(){
                   if(success) {
                       Intent intent = new Intent();
                       setResult(RESULT_OK, intent);
                       finish();
                   }
                   else{
                       Toast.makeText(getBaseContext(), "wrong username or password", Toast.LENGTH_LONG).show();
                   }
               }
            });
        }
    }

    public void beginRegister(){
        Intent intentRegister = new Intent(LoginActivity.this, RegisterActivity.class);
        intentRegister.putExtra("Register", "TRUE");
        startActivityForResult(intentRegister, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch(requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    Toast.makeText(this, "successfully register", Toast.LENGTH_LONG).show();
                }
                break;
            default:
        }
    }
}

package com.example.olivia.weat;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import static java.security.AccessController.getContext;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
<<<<<<< HEAD
    private EditText confirmpassword;
    private EditText email;
=======
>>>>>>> 2019.3.16 3:49PM prototype of third page
    private Button register;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
                sendRegister();
           }
        });
    }

    public void sendRegister(){
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
<<<<<<< HEAD
        confirmpassword = findViewById(R.id.confirmpassword);
        email = findViewById(R.id.email);

        String pw = password.getText().toString();
        String confirmpw = confirmpassword.getText().toString();
        if (pw.equals(confirmpw))
        {
            new Thread(new RegisterRunnable()).start();
        }
        else
        {
            Toast.makeText(this,"Enter the right password",Toast.LENGTH_LONG).show();
        }
=======

        new Thread(new RegisterRunnable()).start();
>>>>>>> 2019.3.16 3:49PM prototype of third page
    }

    public class RegisterRunnable implements Runnable{
        @Override
        public void run(){
<<<<<<< HEAD
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String em = email.getText().toString();
            Map<String, String> newUser = new HashMap<>();
            newUser.put("Username", user);
            newUser.put("Password", pass);
            newUser.put("Email", em);
=======
            String user = username.toString();
            String pass = password.toString();
            Map<String, String> newUser = new HashMap<>();
            newUser.put(user, pass);
>>>>>>> 2019.3.16 3:49PM prototype of third page
            final boolean success = WebService.executeHTTPGetRegister(newUser);
            handler.post(new Runnable(){
                @Override
                public void run(){
                    if(success){
                        Intent intent = new Intent();
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                    else{
                        Toast.makeText(getBaseContext(), "unsuccessfully register", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}

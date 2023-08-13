package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText user=findViewById(R.id.username);
        EditText pass=findViewById(R.id.password);
        ProgressBar pg=findViewById(R.id.prog);
        MaterialButton login=findViewById(R.id.btnlogin);
        TextView sign=findViewById(R.id.ott);


        String username=getIntent().getStringExtra("username");
        String password=getIntent().getStringExtra("password");

        
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = user.getText().toString().trim();
                final String password = pass.getText().toString().trim();
                if (TextUtils.isEmpty(username)) {
                    user.setError("Enter Username");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    pass.setError("Enter Password");
                    return;
                }
                if (password.length() < 6) {
                    pass.setError("Password Must be Greater than 6 characters");
                    return;
                }
                if (user.getText().toString().equals("Admin") && pass.getText().toString().equals("Password")) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                    }, 3500);
                    pg.setVisibility(View.VISIBLE);
                    pg.setProgress(100);
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Signup.class));
            }
        });

    }
}

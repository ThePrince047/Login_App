package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EditText nm=findViewById(R.id.name);
        EditText mail=findViewById(R.id.email);
        EditText setp=findViewById(R.id.setpass);
        EditText conp=findViewById(R.id.conpass);
        TextView log=findViewById(R.id.loginbut);
        Button btn=findViewById(R.id.signupbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name=nm.getText().toString().trim();
                final String email=mail.getText().toString().trim();
                final String setpass=setp.getText().toString().trim();
                final String conpass=conp.getText().toString().trim();
                if(TextUtils.isEmpty(name)){
                    nm.setError("Enter Name");
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    mail.setError("Enter Email");
                    return;
                }
                if(TextUtils.isEmpty(setpass)){
                    setp.setError("Set Password");
                    return;
                }
                if(TextUtils.isEmpty(conpass)){
                    conp.setError("Confirm Password");
                    return;
                }
                if((setp.getText().toString()).equals(conp.getText().toString())) {
                    startActivity(new Intent(Signup.this, Login.class));
                    Toast.makeText(Signup.this, "User Created", Toast.LENGTH_SHORT).show();
                }else{
                    conp.setError("Password Doesn't Match");
                    return;
                }
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup.this,Login.class));
            }
        });
    }
}
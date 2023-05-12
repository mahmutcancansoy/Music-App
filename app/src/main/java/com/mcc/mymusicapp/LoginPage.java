package com.mcc.mymusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    Button lgn_btn;
    EditText txtEmail,txtPassword;
    String email = "deneme@gmail.com";
    String password = "deneme123.456";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        login();

        lgn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();

            }
        });
        txtEmail=(EditText)findViewById(R.id.emailTextArea);
        txtPassword=(EditText)findViewById(R.id.passwordTextArea);
    }
    public void login()
    {
        lgn_btn=findViewById(R.id.login_btn);
    }
    public void loginUser()
    {
        String enteredEmail= txtEmail.getText().toString();
        String enteredPassword = txtPassword.getText().toString();

        if (enteredEmail.equals(email) && enteredPassword.equals(password)) {
            Toast.makeText(LoginPage.this, "Email and password are correct. Button activated.", Toast.LENGTH_SHORT).show();
            Intent loginPage= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(loginPage);
        } else {
            Toast.makeText(LoginPage.this, "Email or password is incorrect. Button deactivated.", Toast.LENGTH_SHORT).show();
            // Button deactivation code goes here
        }

    }
}
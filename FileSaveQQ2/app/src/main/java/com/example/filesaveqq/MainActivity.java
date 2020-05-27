package com.example.filesaveqq;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText emailEt, passwordEt;
    private Button loginBtn;
    private String email, password,userEmail,userPassword;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

        getSharedPrefValue();

        setEditTextValue();

        onClick();

    }

    private void setEditTextValue() {
        if (userEmail!=null){
            emailEt.setText(userEmail);
        }
        if (userPassword!=null){
            passwordEt.setText(userPassword);
        }
    }

    private void getSharedPrefValue() {
        userEmail = sharedPreferences.getString("userEmail", null);
        userPassword = sharedPreferences.getString("userPassword", null);


    }

    private void onClick() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailEt.getText().toString();
                password = passwordEt.getText().toString();

                if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Your Email", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Your Password", Toast.LENGTH_SHORT).show();
                } else {
                    saveUserInfo();
                }
            }
        });
    }

    @SuppressLint("CommitPrefEdits")
    private void saveUserInfo() {
        sharedPreferences.edit().putString("userEmail", email).apply();
        sharedPreferences.edit().putString("userPassword", password).apply();

        String userEmail = sharedPreferences.getString("userEmail", null);
        String userPassword = sharedPreferences.getString("userPassword", null);

        Toast.makeText(this, "login successful", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, HomeActivity.class));
        finish();

        Log.d("loginInfo", "email:  " + userEmail +
                "      " + "password: " + userPassword);


    }

    private void initialization() {
        emailEt = findViewById(R.id.emailEtId);
        passwordEt = findViewById(R.id.passwordEtId);
        loginBtn = findViewById(R.id.loginBtnId);
        sharedPreferences = getSharedPreferences("loginInfo", MODE_PRIVATE);
    }
}

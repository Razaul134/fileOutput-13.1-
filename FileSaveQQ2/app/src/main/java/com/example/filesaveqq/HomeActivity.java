package com.example.filesaveqq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initialization();

        onClick();
    }

    private void onClick() {
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeUserInfo();
            }
        });
    }

    private void removeUserInfo() {
        SharedPreferences sharedPreferences =getSharedPreferences("loginInfo",MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void initialization() {
        logoutBtn =findViewById(R.id.logoutBtnId);
    }
}

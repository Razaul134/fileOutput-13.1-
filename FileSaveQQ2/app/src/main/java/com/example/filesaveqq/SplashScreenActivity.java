package com.example.filesaveqq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {
    private String userEmail;
    private SharedPreferences sharedPreferences;
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        initialization();

        getSharedPrefValue();

        splashTimeOut();

    }

    private void splashTimeOut() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                checkUserLoggedIn();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    private void initialization() {
        sharedPreferences = getSharedPreferences("loginInfo", MODE_PRIVATE);
    }

    private void getSharedPrefValue() {
        userEmail = sharedPreferences.getString("userEmail", null);
    }

    private void checkUserLoggedIn() {
        if (userEmail != null) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
            finish();
        }
    }
}

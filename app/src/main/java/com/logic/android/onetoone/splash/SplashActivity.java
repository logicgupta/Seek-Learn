package com.logic.android.onetoone.splash;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.logic.android.onetoone.basic_video_chat.dashboard.DashBoardActivity;
import com.logic.android.onetoone.basic_video_chat.onboard.OnBoardActivity;
import com.logic.android.onetoone.basicvideochat.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_video);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (FirebaseAuth.getInstance().getCurrentUser()!=null){
                    startActivity(new Intent(SplashActivity.this, DashBoardActivity.class));
                }
                else{

                    startActivity(new Intent(SplashActivity.this, OnBoardActivity.class));
                    finish();
                }
            }
        },3000);
    }
}

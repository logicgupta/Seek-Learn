package com.logic.android.onetoone.basic_video_chat.onboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;
import com.logic.android.onetoone.basic_video_chat.login.LoginActivity;
import com.logic.android.onetoone.basicvideochat.R;

import java.util.ArrayList;
import java.util.List;

public class OnBoardActivity extends AhoyOnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("Learn AnyTime", "Learning not to anytime and place", R.drawable.ic_onboard1);
        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("Connect With Anyone", "Qualified connect with anyone around the globe",R.drawable.ic_onboard3);
        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard("Minimal Cost", "We deliver beautiful minimal cost", R.drawable.ic_onboard2);

        ahoyOnboarderCard1
                .setIconLayoutParams(700,800,
                        30,10,10,0);

        ahoyOnboarderCard2
                .setIconLayoutParams(700,800,
                        30,10,10,0);
        ahoyOnboarderCard3
                .setIconLayoutParams(700,800,
                        30,10,10,0);

       ahoyOnboarderCard1.setBackgroundColor(R.color.white);
      ahoyOnboarderCard2.setBackgroundColor(R.color.white);
     ahoyOnboarderCard3.setBackgroundColor(R.color.white);

        List<AhoyOnboarderCard> pages = new ArrayList<>();

        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);


        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.text);
            page.setDescriptionColor(R.color.text);
        }
        setColorBackground(R.color.white);
        setFinishButtonTitle("Let's Start");


        showNavigationControls(true);
        //setGradientBackground();
      //  setImageBackground(R.drawable.download);

       // Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        //setFont(face);

      //  setInactiveIndicatorColor(R.color.grey_600);
        setActiveIndicatorColor(R.color.text);

        setOnboardPages(pages);
        setColorBackground(R.color.white);

    }

    @Override
    public void onFinishButtonPressed() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}



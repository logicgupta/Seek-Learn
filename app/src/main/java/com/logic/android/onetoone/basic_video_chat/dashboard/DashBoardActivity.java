package com.logic.android.onetoone.basic_video_chat.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatConfig;
import com.google.android.material.navigation.NavigationView;
import com.logic.android.onetoone.basic_video_chat.MainActivity;
import com.logic.android.onetoone.basicvideochat.R;

public class DashBoardActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    ImageView imageView;
    DrawerLayout drawer;
    private NavigationView navigationView;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_video);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //   getSupportActionBar().setHomeButtonEnabled(true);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        navigationView.setNavigationItemSelectedListener(this);


        navHeader = navigationView.getHeaderView(0);
        txtName = navHeader.findViewById(R.id.name);
        txtWebsite =  navHeader.findViewById(R.id.website);
        imgNavHeaderBg =  navHeader.findViewById(R.id.img_header_bg);
        imgProfile =  navHeader.findViewById(R.id.img_profile);



        imageView=findViewById(R.id.image1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DashBoardActivity.this, MainActivity.class));

            }
        });

        setToolbarTitle();
        setupFreshDesk();
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle("Seek & Learn");
    }




    void setupFreshDesk() {
        String appId = "09ff078d-de4a-4f8d-a102-872fa4368866";
        String appKey = "1c35d1a0-04aa-4fdf-b2ea-3d7b63ab776f";
        FreshchatConfig freshchatConfig = new FreshchatConfig(appId, appKey);
        freshchatConfig.setCameraCaptureEnabled(true)
                .setGallerySelectionEnabled(true);
//        Freshchat.setImageLoader(com.freshchat.consumer.sdk.j.af.aw(getApplicationContext()));

        Freshchat.getInstance(getApplicationContext()).init(freshchatConfig);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }
        super.onBackPressed();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            //Replacing the main content with ContentFragment Which is our Inbox View;
            case R.id.nav_home:
                break;
            case R.id.nav_profile:
                break;
            case R.id.nav_chat:
                Freshchat.showConversations(getApplicationContext());
                break;
            case R.id.nav_notifications:
                break;

            case R.id.nav_about_us:
                // launch new intent instead of loading fragment

                drawer.closeDrawers();
                return true;
            case R.id.nav_privacy_policy:
                // launch new intent instead of loading fragment

                drawer.closeDrawers();
                return true;
            default:
        }

        //Checking if the item is in checked state or not, if not make it in checked state
        if (menuItem.isChecked()) {
            menuItem.setChecked(false);
        } else {
            menuItem.setChecked(true);
        }
        menuItem.setChecked(true);


        return true;
    }

}

package com.example.a786788z.pocketleague;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.Serializable;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by A786788Z on 4/7/2018.
 */

//https://stackoverflow.com/questions/12131025/android-preventing-webview-reload-on-rotate

public class StatsScreenActivity extends AppCompatActivity {

    private Intent intent;
    private BottomNavigationView navigationView;
    private WebView webView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(0, 0);
        setContentView(R.layout.stats_screen);


        //Set navigation item to be selected corresponding to current activity
        navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        //Create a new web view and load URL
        webView = (WebView) findViewById(R.id.statsWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://rocketleaguestats.com/profile");

        //Listen for bottom scroll bar bottom clicks
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        intent = new Intent(StatsScreenActivity.this, HomeScreenActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        StatsScreenActivity.this.startActivity(intent);
                        break;
                    case R.id.action_replays:
                        //Start New Activity Here
                        intent = new Intent(StatsScreenActivity.this, ReplaysScreenActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        StatsScreenActivity.this.startActivity(intent);
                        break;
                    case R.id.action_tutorials:
                        //Start New Activity Here
                        intent = new Intent(StatsScreenActivity.this, TutorialsScreenActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        StatsScreenActivity.this.startActivity(intent);
                        break;
                    case R.id.action_stats:
                        //Do nothing here, we are already in replay activity
                        break;
                }
                return true;
            }
        });
    }
    @Override
    public void onResume()
    {
        super.onResume();

        //Because we are resuming activity to save state of web view, reset the selected item
        //of task bar and override the transition provided by a single instance activity
        navigationView.setSelectedItemId(R.id.action_stats);
        overridePendingTransition(0, 0);

    }

    //Listen for back button pressed
    @Override
    public void onBackPressed()
    {
        if (webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            //We want to keep the user using the bottom navigation
            //to access different activities, so here we do nothing.
        }
    }
}
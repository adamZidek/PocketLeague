package com.example.a786788z.pocketleague;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

/**
 * Created by A786788Z on 4/7/2018.
 */

public class HomeScreenActivity extends AppCompatActivity {

    private Intent intent;
    private BottomNavigationView navigationView;

    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        //Set navigation item to be selected corresponding to current activity
        navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.action_home);


        //Listen for bottom scroll bar bottom clicks
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        //Do nothing, we are already in this activity
                        break;
                    case R.id.action_replays:
                        //Start New Activity Here
                        intent = new Intent(HomeScreenActivity.this, ReplaysScreenActivity.class);
                        HomeScreenActivity.this.startActivity(intent);
                        break;
                    case R.id.action_tutorials:
                        //Start New Activity Here
                        intent = new Intent(HomeScreenActivity.this, TutorialsScreenActivity.class);
                        HomeScreenActivity.this.startActivity(intent);
                        break;
                    case R.id.action_stats:
                        //Start New Activity Here
                        intent = new Intent(HomeScreenActivity.this, StatsScreenActivity.class);
                        HomeScreenActivity.this.startActivity(intent);
                        break;
                }
                return true;
            }
        });
        WebView webView;
        webView = (WebView) findViewById(R.id.newsWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.rocketleague.com/news/");


    }
}

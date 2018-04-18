package com.example.a786788z.pocketleague;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;

/**
 * Created by A786788Z on 4/7/2018.
 */

public class HomeScreenActivity extends AppCompatActivity {

    private Intent intent;
    private BottomNavigationView navigationView;
    private WebView webView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(0, 0);

        setContentView(R.layout.home_screen);

        //Set navigation item to be selected corresponding to current activity
        navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.action_home);

        //Create a new web view and load URL
        webView = (WebView) findViewById(R.id.newsWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.rocketleague.com/news/");

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
                }
                return true;
            }
        });

    }
    @Override
    public void onResume(){
        super.onResume();

        //Because we are resuming activity to save state of web view, reset the selected item
        //of task bar and override the transition provided by a single instance activity
        navigationView.setSelectedItemId(R.id.action_home);
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

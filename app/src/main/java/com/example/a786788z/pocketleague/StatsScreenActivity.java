package com.example.a786788z.pocketleague;

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
import android.widget.Toast;

import java.io.Serializable;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by A786788Z on 4/7/2018.
 */

public class StatsScreenActivity extends AppCompatActivity {


    private Intent intent;
    private BottomNavigationView navigationView;
    private int myView;

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        myView = R.layout.stats_screen;
        setContentView(myView);
        WebView webView;
        webView = (WebView) findViewById(R.id.newsWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        if(savedInstanceState != null)
        {
            myView = savedInstanceState.getInt("ourView");
        }
        else
        {
            webView.loadUrl("https://rocketleaguestats.com/profile");
        }



        //Set navigation item to be selected corresponding to current activity
        navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.action_stats);

        //Listen for bottom scroll bar bottom clicks
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        intent = new Intent(StatsScreenActivity.this, HomeScreenActivity.class);
                        StatsScreenActivity.this.startActivity(intent);
                        break;
                    case R.id.action_replays:
                        //Start New Activity Here
                        intent = new Intent(StatsScreenActivity.this, ReplaysScreenActivity.class);
                        StatsScreenActivity.this.startActivity(intent);
                        break;
                    case R.id.action_tutorials:
                        //Start New Activity Here
                        intent = new Intent(StatsScreenActivity.this, TutorialsScreenActivity.class);
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
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putInt("ourView", myView);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        myView = savedInstanceState.getInt("ourView");

    }


}

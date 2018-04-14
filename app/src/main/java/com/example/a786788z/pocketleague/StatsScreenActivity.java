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
    private int myView;
    private Bundle webView_bundle;
    private WebView webView;

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(getBaseContext(), "OnCreate", Toast.LENGTH_LONG).show();
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);


        if(savedInstanceState != null)
        {
            webView.restoreState(savedInstanceState);
        }
        else
        {
            myView = R.layout.stats_screen;
            setContentView(myView);
            webView = findViewById(R.id.newsWebView);
            webView.setWebViewClient(new WebViewClient());
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
    /*
    protected void onResume()
    {
        Toast.makeText(getBaseContext(), "OnResume", Toast.LENGTH_LONG).show();

        if (webView_bundle != null) {
            webView.restoreState(webView_bundle);
        }

        super.onResume();
    }

    protected void onPause()
    {
        super.onPause();
        Toast.makeText(getBaseContext(), "OnPause", Toast.LENGTH_LONG).show();
        webView_bundle = new Bundle();
        webView.saveState(webView_bundle);
    }
 */
    @SuppressLint("MissingSuperCall")
    protected void onSaveInstanceState(Bundle outState) {
        Toast.makeText(getBaseContext(), "OnSAVE", Toast.LENGTH_LONG).show();
        webView.saveState(outState);
    }
    
}

package com.example.a786788z.pocketleague;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

/**
 * Created by A786788Z on 4/7/2018.
 */

public class TutorialsScreenActivity extends AppCompatActivity {


    private Intent intent;
    private BottomNavigationView navigationView;

    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorials_screen);

        //Set navigation item to be selected corresponding to current activity
        navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.action_tutorials);

        //Listen for bottom scroll bar bottom clicks
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        intent = new Intent(TutorialsScreenActivity.this, HomeScreenActivity.class);
                        TutorialsScreenActivity.this.startActivity(intent);
                        break;
                    case R.id.action_replays:
                        //Start New Activity Here
                        intent = new Intent(TutorialsScreenActivity.this, ReplaysScreenActivity.class);
                        TutorialsScreenActivity.this.startActivity(intent);
                        break;
                    case R.id.action_tutorials:
                        //Do nothing here, we are already in replay activity
                        break;
                    case R.id.action_stats:
                        //Start New Activity Here
                        intent = new Intent(TutorialsScreenActivity.this, StatsScreenActivity.class);
                        TutorialsScreenActivity.this.startActivity(intent);
                        break;
                }
                return true;
            }
        });

        //Create a new Web View object to display tutorial(Youtube)
        final FrameLayout customViewContainer = findViewById(R.id.frame);
        final WebView webView = (WebView) findViewById(R.id.youtubeView);;

        webView.setWebChromeClient(new WebChromeClient()
        {
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                super.onShowCustomView(view,callback);
                webView.setVisibility(View.GONE);
                customViewContainer.setVisibility(View.VISIBLE);
                customViewContainer.addView(view);
            }
            public void onHideCustomView () {
                super.onHideCustomView();
                webView.setVisibility(View.VISIBLE);
                customViewContainer.setVisibility(View.GONE);
            }

        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.youtube.com/results?search_query=rocket+league+tutorials");
    }
}

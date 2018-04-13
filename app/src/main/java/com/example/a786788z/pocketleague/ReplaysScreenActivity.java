package com.example.a786788z.pocketleague;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by A786788Z on 4/7/2018.
 */

public class ReplaysScreenActivity extends AppCompatActivity {


    private Intent intent;
    private BottomNavigationView navigationView;

    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.replays_screen);

        //Set navigation item to be selected corresponding to current activity
        navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView.setSelectedItemId(R.id.action_replays);

        //Listen for bottom scroll bar bottom clicks
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        intent = new Intent(ReplaysScreenActivity.this, HomeScreenActivity.class);
                        ReplaysScreenActivity.this.startActivity(intent);
                        break;
                    case R.id.action_replays:
                        //Do nothing here, we are already in replay activity
                        break;
                    case R.id.action_tutorials:
                        //Start New Activity Here
                        intent = new Intent(ReplaysScreenActivity.this, TutorialsScreenActivity.class);
                        ReplaysScreenActivity.this.startActivity(intent);
                        break;
                    case R.id.action_stats:
                        //Start New Activity Here
                        intent = new Intent(ReplaysScreenActivity.this, StatsScreenActivity.class);
                        ReplaysScreenActivity.this.startActivity(intent);
                        break;
                }
                return true;
            }
        });
    }




}
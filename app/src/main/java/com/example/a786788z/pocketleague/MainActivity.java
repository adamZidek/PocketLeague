package com.example.a786788z.pocketleague;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Default the users view to home screen
        intent = new Intent(MainActivity.this, HomeScreenActivity.class);
        overridePendingTransition(0, 0);
        MainActivity.this.startActivity(intent);

    }
}

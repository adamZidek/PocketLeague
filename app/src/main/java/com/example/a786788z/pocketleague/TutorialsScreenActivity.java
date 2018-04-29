package com.example.a786788z.pocketleague;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by A786788Z on 4/7/2018.
 */

public class TutorialsScreenActivity extends AppCompatActivity implements View.OnClickListener {


    private Intent intent;
    private BottomNavigationView navigationView;
    final String key = "AIzaSyBjwn4AzHy9G6ZkSUMGtuFT35dflYXV6R4";


    Map<String, Integer> mapIndex;
    ListView tutorialList;

    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials);

        //make string array for ListView
        String[] tutorials = getResources().getStringArray(R.array.sections);
        Arrays.asList(tutorials);

        tutorialList = (ListView) findViewById(R.id.list_tutorials);
        tutorialList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tutorials));


        getIndexList(tutorials);
        displayIndex();

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

        tutorialList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id)
            {
                //Object o = tutorialList.getItemAtPosition(pos);
                intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                TutorialsScreenActivity.this.startActivityForResult(intent, 1);
            }


        });
    }

    /*AdapterView.OnItemClickListener itemClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            //intent = new Intent(this, )
        }
    };*/

    private void getIndexList(String[] tutorials) {
        mapIndex = new LinkedHashMap<String, Integer>();
        for (int i=0; i< tutorials.length; i++) {
            String tutorial = tutorials[i];
            String index = tutorial.substring(0,1);

            if (mapIndex.get(index) == null) {
                mapIndex.put(index, i);
            }
        }
    }

    private void displayIndex() {
        LinearLayout indexLayout = (LinearLayout) findViewById(R.id.side_index);

        TextView textView;
        List<String> indexList = new ArrayList<String>(mapIndex.keySet());
        for (String index: indexList) {
            textView = (TextView) getLayoutInflater().inflate(R.layout.side_index_item, null);
            textView.setText(index);
            textView.setOnClickListener(this);
            indexLayout.addView(textView);
        }
    }


    public void onClick (View view) {
        TextView selectedIndex = (TextView) view;
        tutorialList.setSelection(mapIndex.get(selectedIndex.getText()));


    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
        return true;
    }*/

    //Listen for back button pressed
    @Override
    public void onBackPressed()
    {

    }
}

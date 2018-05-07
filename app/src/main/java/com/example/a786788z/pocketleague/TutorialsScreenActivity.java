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
        //navigationView.setSelectedItemId(R.id.action_tutorials);

        //Listen for bottom scroll bar bottom clicks
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        intent = new Intent(TutorialsScreenActivity.this, HomeScreenActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        TutorialsScreenActivity.this.startActivity(intent);
                        break;
                    case R.id.action_replays:
                        //Start New Activity Here
                        intent = new Intent(TutorialsScreenActivity.this, ReplaysScreenActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        TutorialsScreenActivity.this.startActivity(intent);
                        break;
                    case R.id.action_tutorials:
                        //Do nothing here, we are already in replay activity
                        break;
                    case R.id.action_stats:
                        //Start New Activity Here
                        intent = new Intent(TutorialsScreenActivity.this, StatsScreenActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        TutorialsScreenActivity.this.startActivity(intent);
                        break;
                }
                return true;
            }
        });

        //Handle opening youtube activity with correct video when an object is pressed
        tutorialList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id)
            {

                int arrayValue = pos;       //Array value is the position of the item in list, so its sequential.

                if(pos == 0)
                {   //Aerials
                    intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                    Bundle b = new Bundle();
                    b.putString("link", "a5sQjUITf-8");    //First string is the key, second is the actual value(youtube link(just part after equals sign)
                    intent.putExtras(b);
                    TutorialsScreenActivity.this.startActivityForResult(intent, 1);
                }
                else if(pos == 1)
                {   //Air Dribbling
                    intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                    Bundle b = new Bundle();
                    b.putString("link", "Jqfpe-AotSI&t");    //First string is the key, second is the actual value(youtube link(just part after equals sign)
                    intent.putExtras(b);
                    TutorialsScreenActivity.this.startActivityForResult(intent, 1);
                }
                else if(pos == 2)
                {
                    //Boost Management
                    intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                    Bundle b = new Bundle();
                    b.putString("link", "Jqfpe-AotSI&t");    //First string is the key, second is the actual value(youtube link(just part after equals sign)
                    intent.putExtras(b);
                    TutorialsScreenActivity.this.startActivityForResult(intent, 1);
                }
                else if(pos == 3)
                {   //Car stats
                    intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                    Bundle b = new Bundle();
                    b.putString("link", "i90pnvp6Zkc");    //First string is the key, second is the actual value(youtube link(just part after equals sign)
                    intent.putExtras(b);
                    TutorialsScreenActivity.this.startActivityForResult(intent, 1);
                }
                else if(pos == 4)
                {   //Challenging
                    intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                    Bundle b = new Bundle();
                    b.putString("link", "9erKMUdZlzM");    //First string is the key, second is the actual value(youtube link(just part after equals sign)
                    intent.putExtras(b);
                    TutorialsScreenActivity.this.startActivityForResult(intent, 1);
                }
                else if(pos == 5)
                {   //Defense
                    intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                    Bundle b = new Bundle();
                    b.putString("link", "LFq1nZa9IDs&");    //First string is the key, second is the actual value(youtube link(just part after equals sign)
                    intent.putExtras(b);
                    TutorialsScreenActivity.this.startActivityForResult(intent, 1);
                }
                else if(pos == 6)
                {   //Dribbling
                    intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                    Bundle b = new Bundle();
                    b.putString("link", "eBmgRPOmh98");    //First string is the key, second is the actual value(youtube link(just part after equals sign)
                    intent.putExtras(b);
                    TutorialsScreenActivity.this.startActivityForResult(intent, 1);
                }
                else if(pos == 7)
                { //Flicking
                    intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                    Bundle b = new Bundle();
                    b.putString("link", "djql1j_zBFQ&");    //First string is the key, second is the actual value(youtube link(just part after equals sign)
                    intent.putExtras(b);
                    TutorialsScreenActivity.this.startActivityForResult(intent, 1);
                }
                else if(pos == 8)
                {   //Goaltending
                    intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                    Bundle b = new Bundle();
                    b.putString("link", "Omk31pxWP-");    //First string is the key, second is the actual value(youtube link(just part after equals sign)
                    intent.putExtras(b);
                    TutorialsScreenActivity.this.startActivityForResult(intent, 1);
                }
                else if(pos == 9)
                {   //Half-flipping
                    intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                    Bundle b = new Bundle();
                    b.putString("link", "V_4ajUfCVq4");    //First string is the key, second is the actual value(youtube link(just part after equals sign)
                    intent.putExtras(b);
                    TutorialsScreenActivity.this.startActivityForResult(intent, 1);
                }
                else if(pos == 10)
                {   //Kickoffs
                    intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                    Bundle b = new Bundle();
                    b.putString("link", "Qcz6BuutlAk");    //First string is the key, second is the actual value(youtube link(just part after equals sign)
                    intent.putExtras(b);
                    TutorialsScreenActivity.this.startActivityForResult(intent, 1);
                }
                else if(pos == 11)
                {   //Rotation
                    intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                    Bundle b = new Bundle();
                    b.putString("link", "mqhkSKjKR38&");    //First string is the key, second is the actual value(youtube link(just part after equals sign)
                    intent.putExtras(b);
                    TutorialsScreenActivity.this.startActivityForResult(intent, 1);
                }
                else if(pos == 12)
                {   //Striking
                    intent = new Intent(TutorialsScreenActivity.this, YoutubeVidActivity.class);
                    Bundle b = new Bundle();
                    b.putString("link", "fA0ivgr69Xg&");    //First string is the key, second is the actual value(youtube link(just part after equals sign)
                    intent.putExtras(b);
                    TutorialsScreenActivity.this.startActivityForResult(intent, 1);
                }


            }


        });
    }

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

    @Override
    public void onResume()
    {
        super.onResume();

        //Because we are resuming activity to save state of web view, reset the selected item
        //of task bar and override the transition provided by a single instance activity
        navigationView.setSelectedItemId(R.id.action_tutorials);
        overridePendingTransition(0, 0);

    }

    //Listen for back button pressed
    @Override
    public void onBackPressed()
    {
        //We dont want to do anything here
    }
}

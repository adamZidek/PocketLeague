package com.example.a786788z.pocketleague;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by A786788Z on 4/29/2018.
 */

public class YoutubeVidActivity extends YouTubeBaseActivity
{
    private Intent intent;
    private BottomNavigationView navigationView;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    final String key = "AIzaSyBjwn4AzHy9G6ZkSUMGtuFT35dflYXV6R4";

    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    overridePendingTransition(0, 0);
    setContentView(R.layout.youtube_view);

    //Set navigation item to be selected corresponding to current activity
    navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        //Listen for bottom scroll bar bottom clicks
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        intent = new Intent(YoutubeVidActivity.this, HomeScreenActivity.class);
                        YoutubeVidActivity.this.startActivity(intent);
                        break;
                    case R.id.action_replays:
                        intent = new Intent(YoutubeVidActivity.this, ReplaysScreenActivity.class);
                        YoutubeVidActivity.this.startActivity(intent);
                        break;
                    case R.id.action_tutorials:
                        //Technically already in tutorials so do nothing
                        break;
                    case R.id.action_stats:
                        //Start New Activity Here
                        intent = new Intent(YoutubeVidActivity.this, StatsScreenActivity.class);
                        YoutubeVidActivity.this.startActivity(intent);
                        break;
                }
                return true;
            }
        });

        YouTubePlayerView vid = (YouTubePlayerView) findViewById(R.id.player);
        vid.initialize(key,
                new YouTubePlayer.OnInitializedListener(){
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b){
                        //youTubePlayer.setFullscreen(true);
                        youTubePlayer.loadVideo("7rGKXner5Ig", 0);
                        youTubePlayer.pause();
                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult){};
                });
}
    //Listen for back button pressed
    @Override
    public void onBackPressed()
    {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
    }



}

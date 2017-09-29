package com.codejocks.absolutedarhk;

import android.app.ActionBar;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.codejocks.absolutedarhk.fragments.FeedsFragment;
import com.codejocks.absolutedarhk.fragments.HomeActivity;
import com.codejocks.absolutedarhk.fragments.ShareFragment;
//import com.codejocks.absolutedarhk.fragments.ShareFragment;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    boolean prepared = false;
    boolean started = false;
    String stream = "http://stream.radioreklama.bg:80/radio1rock128";
    FloatingActionButton radio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        new PlayerTask().execute(stream);

        radio = (FloatingActionButton) findViewById(R.id.radio);
        radio.setEnabled(false);
        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(started){
                    started = false;
                    mediaPlayer.pause();
                }else{
                    started = true;
                    mediaPlayer.start();
                }
            }
        });

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.content, new HomeActivity());
        ft.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        FragmentManager f = getSupportFragmentManager();
                        FragmentTransaction transaction = f.beginTransaction();
                        switch (item.getItemId()) {
                            case R.id.action_item_home:
                                selectedFragment = HomeActivity.newInstance();
                                break;
                            case R.id.action_item_feeds:
                                selectedFragment = FeedsFragment.newInstance();
                                break;
                            case R.id.action_item_share:
                                selectedFragment = ShareFragment.newInstance();
                                break;
                        }
                               transaction.replace(R.id.content, selectedFragment);
                               transaction.addToBackStack("frag0");
                               transaction.commit();

                        return true;
                    }



                });
    }


    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }




    private class PlayerTask extends AsyncTask<String , Void, Boolean>{
        @Override
        protected Boolean doInBackground(String... params) {
            try {
                mediaPlayer.setDataSource(params[0]);
                mediaPlayer.prepare();
                prepared= true;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return prepared;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            radio.setEnabled(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(started){
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(started){
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(prepared){
            mediaPlayer.release();
        }
    }

    @Override
    public void onBackPressed(){
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
    }
    }
}

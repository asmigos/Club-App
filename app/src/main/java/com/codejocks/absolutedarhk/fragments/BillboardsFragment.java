package com.codejocks.absolutedarhk.fragments;


import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codejocks.absolutedarhk.MainActivity;
import com.codejocks.absolutedarhk.R;
import com.codejocks.absolutedarhk.adapter.BillboardAdapter;
import com.codejocks.absolutedarhk.helper.SongsManager;
import com.codejocks.absolutedarhk.model.Music;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillboardsFragment extends Fragment {
    private List<Music> musicList = new ArrayList<>();
//    private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    RecyclerView recyclerView;
    BillboardAdapter mAdapter;
    public Button btnPlay;
    private TextView songTitleLabel;
    private TextView songTotalDurationLabel, music_Description;
    // Media Player
    private  MediaPlayer mp;
    ArrayList<Music> songsListData;
   


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        View view = inflater.inflate(R.layout.activity_billboards_fragment, container, false);


        ((MainActivity) getActivity())
                .setActionBarTitle("Billboards");
        mAdapter = new BillboardAdapter(musicList);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        music_Description=(TextView)view.findViewById(R.id.music_description);
        songTitleLabel = (TextView) view.findViewById(R.id.music_name);
        songTotalDurationLabel = (TextView) view.findViewById(R.id.music_timer);
        btnPlay = (Button) view.findViewById(R.id.playPauseButton);
        songsListData = new ArrayList<>();




        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mp = new MediaPlayer();





    SongsManager plm = new SongsManager();
    // get all songs from sdcard
        this.musicList = plm.getPlayList();

    // looping through playlist
        for (int i = 0; i < musicList.size(); i++) {
        // creating new HashMap
        Music song = musicList.get(i);

        // adding HashList to ArrayList
        songsListData.add(song);
    }



    // Listeners
//        songProgressBar.setOnSeekBarChangeListener(this); // Important
//        mp.setOnCompletionListener(this); // Important

    // Getting all songs list
        SongsManager songManager = new SongsManager();
        musicList = songManager.getPlayList();

    // By default play first song
        playSong(0);

    /**
     * Play button click event
     * plays a song and changes button to pause image
     * pauses a song and changes button to play image
     * */
       btnPlay.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            // check for already playing
            if(mp.isPlaying()){
                if(mp!=null){
                    mp.pause();
                    // Changing button image to play button
                    btnPlay.setBackgroundResource(R.drawable.ic_play_arrow_black_24dp);
                }
            }else{
                // Resume song
                if(mp!=null){
                    mp.start();
                    // Changing button image to pause button
                    btnPlay.setBackgroundResource(R.drawable.ic_pause_black_24dp);
                }
            }

        }
    });


        return view;
    }


    public void  playSong(int songIndex){
        // Play song
        try {
            mp.reset();
            mp.setDataSource(musicList.get(songIndex).get("songPath"));
            mp.prepare();
            mp.start();
            // Displaying Song title
            String songTitle = musicList.get(songIndex).getName();
            songTitleLabel.setText(songTitle);

            // Changing Button Image to pause image
            btnPlay.setBackgroundResource(R.drawable.ic_pause_black_24dp);

            // set Progress bar values
//            songProgressBar.setProgress(0);
//            songProgressBar.setMax(100);

            // Updating progress bar
//            updateProgressBar();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
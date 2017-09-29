package com.codejocks.absolutedarhk.adapter;

/**
 * Created by hp on 01-08-2017.
 */

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codejocks.absolutedarhk.R;
import com.codejocks.absolutedarhk.fragments.BillboardsFragment;
import com.codejocks.absolutedarhk.helper.SongsManager;
import com.codejocks.absolutedarhk.helper.Utilities;
import com.codejocks.absolutedarhk.model.Music;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BillboardAdapter extends RecyclerView.Adapter<BillboardAdapter.MyViewHolder> {


    private Context mContext;
    private List<Music> musicList;

    private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
//    private ArrayList<HashMap<String, String>> musicList;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        public Button btnPlay;
        private TextView songTitleLabel;
        private TextView musicDescription;
        private TextView songTotalDurationLabel;
        // Media Player
        private  MediaPlayer mp;
        // Handler to update UI timer, progress bar etc,.
        private Handler mHandler = new Handler();
        private SongsManager songManager;
        private Utilities utils;
        private ImageView thumbnail;

        ArrayList<HashMap<String, String>> songsListData;

        public MyViewHolder(View view) {
            super(view);
            songTitleLabel = (TextView) view.findViewById(R.id.music_name);
            musicDescription=(TextView)view.findViewById(R.id.music_description);
            songTotalDurationLabel = (TextView) view.findViewById(R.id.music_timer);
            thumbnail=(ImageView) view.findViewById(R.id.thumbnail);
            btnPlay = (Button) view.findViewById(R.id.playPauseButton);
            songsListData = new ArrayList<HashMap<String, String>>();

            //MediaPlayer
            mp = new MediaPlayer();
            songManager = new SongsManager();
            utils = new Utilities();
        }
    }


//    public BillboardAdapter(Context mContext, ArrayList<HashMap<String, String>> songsList) {
//        this.mContext = mContext;
//        this.songsList = songsList;
//    }

    public BillboardAdapter(List<Music> musicList) {
        this.musicList = musicList;
        this.mContext = mContext;
    }


    @Override
    public BillboardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.billboard_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
//        HashMap<String, String> music = musicList.get(position);
//        holder.music_name.setText(music.getName());
//        holder.music_description.setText(music.getMusic_description());
//
//
//        // loading album cover using Glide library
//        Glide.with(mContext).load(music.getThumbnail()).into(holder.thumbnail);

        Music music = musicList.get(position);
        holder.songTitleLabel.setText(music.getName());
        holder.musicDescription.setText(music.getMusic_description());
        holder.songTotalDurationLabel.setText(music.getMusic_timer());




    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }


}

package com.codejocks.absolutedarhk.model;

import android.os.Environment;

import java.io.FileDescriptor;

/**
 * Created by hp on 01-08-2017.
 */

public class Music {

    private String name;
    private String music_description;
    private int thumbnail;
    private String image_url;
    private int music_timer;
    private String song_path;


    public Music() {
    }

    public Music(String name, String image_url,int thumbnail ,String music_description , int music_timer, String song_path) {
        this.name = name;
        this.image_url = image_url;
        this.thumbnail = thumbnail;
        this.music_description = music_description;
        this.music_timer = music_timer;
        this.song_path = song_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public  String getImage_url(){
        return image_url;
    }

    public void setImage_url(){
        this.image_url = image_url;
    }

    public String getMusic_description() {
        return music_description;
    }

    public void setMusic_description(int thumbnail) {
        this.music_description = music_description;
    }

    public int getMusic_timer() {
        return music_timer;
    }

    public void setMusic_timer(int music_timer) {
        this.music_timer = music_timer;
    }

    public String put(String songTitle, String substring) {
        return name;
    }

    public String get(String songPath) {
        return songPath;
    }
}

package com.codejocks.absolutedarhk.helper;

import android.os.Environment;

import com.codejocks.absolutedarhk.model.Music;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SongsManager {
	// SDCard Path
	final String MEDIA_PATH = Environment.getExternalStorageDirectory()
			.getPath() + "/";
	private List<Music> songsList = new ArrayList<>();
	private String mp3Pattern = ".mp3";
	
	// Constructor
	public SongsManager(){
		
	}

	/**
	 * Function to read all mp3 files from sdcard
	 * and store the details in ArrayList
	 * */
	public List<Music> getPlayList(){

		System.out.println(MEDIA_PATH);
		if (MEDIA_PATH != null) {
			File home = new File(MEDIA_PATH);
			File[] listFiles = home.listFiles();
			if (listFiles != null && listFiles.length > 0) {
				for (File file : listFiles) {
					System.out.println(file.getAbsolutePath());
					if (file.isDirectory()) {
						scanDirectory(file);
					} else {
						addSongToList(file);
					}
				}
			}
		}


		// return songs list array
		return songsList;
	}

	private void scanDirectory(File directory) {
		if (directory != null) {
			File[] listFiles = directory.listFiles();
			if (listFiles != null && listFiles.length > 0) {
				for (File file : listFiles) {
					if (file.isDirectory()) {
						scanDirectory(file);
					} else {
						addSongToList(file);
					}

				}
			}
		}
	}

	private void addSongToList(File song) {
		if (song.getName().endsWith(mp3Pattern)) {
			Music songMap = new Music();
			songMap.put("songTitle", song.getName().substring(0, (song.getName().length() - 4)));
			songMap.put("songPath", song.getPath());

			// Adding each song to SongList
			songsList.add(songMap);
		}
	}
	
	/**
	 * Class to filter files which are having .mp3 extension
	 * */
	class FileExtensionFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return (name.endsWith(".mp3") || name.endsWith(".MP3"));
		}
	}
}

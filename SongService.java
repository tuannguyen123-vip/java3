package com.example.java03_NAT.service;

import com.example.java03_NAT.entity.Song;
import com.example.java03_NAT.repository.SongDao;

import java.util.ArrayList;

public class SongService {
    private SongDao songDao = new SongDao();

    public ArrayList<Song> getSongs(){
        return songDao.getSongs();
    }

    public void deleteSong(String ten_bai_hat){
        songDao.deleteSong(ten_bai_hat);
    }

    public void addSong(Song song){
        songDao.addSong(song);
    }

    public Song getSongById(String ten_bai_hat){
      return songDao.getSongById(ten_bai_hat);
    }

    public void updateSong(Song song){
        songDao.updateSong(song);
    }
}

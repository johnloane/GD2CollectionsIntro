package com.dkit.gd2.johnloane;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album
{
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist)
    {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, Duration duration)
    {
        if(findSong(title) == null)
        {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title)
    {
        for(Song checkedSong: this.songs)
        {
            if(checkedSong.getTitle().equals(title))
            {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList)
    {
        int index = trackNumber - 1;
        if((index >= 0) && (index < this.songs.size()))
        {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track: " + trackNumber);
        return false;
    }

    //Allow adding to the playlist with a song title
}

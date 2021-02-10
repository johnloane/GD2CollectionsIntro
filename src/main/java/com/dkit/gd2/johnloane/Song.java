package com.dkit.gd2.johnloane;

public class Song
{
    private String title;
    private Duration duration;

    public Song(String title, Duration duration)
    {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle()
    {
        return title;
    }

    public Duration getDuration()
    {
        return duration;
    }

    @Override
    public String toString()
    {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}

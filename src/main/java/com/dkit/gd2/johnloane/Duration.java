package com.dkit.gd2.johnloane;

public class Duration
{
    private int minutes;
    private int seconds;

    public Duration(int minutes, int seconds)
    {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public int getSeconds()
    {
        return seconds;
    }

    @Override
    public String toString()
    {
        return "Duration{" +
                "minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}

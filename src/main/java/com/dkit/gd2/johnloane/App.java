package com.dkit.gd2.johnloane;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Collections
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List playerIDS = new ArrayList<>(1000000);

        populateANDTimePlayerIDS(playerIDS);
        timeNonEndInsertionIntoList(playerIDS);
    }

    private static void timeNonEndInsertionIntoList(List playerIDS)
    {
        final long startTime = System.nanoTime();
        for(int i =0; i < 100; i++)
        {
            playerIDS.add(1, 77);
        }
        final long endTime = System.nanoTime();
        System.out.println("Total execution time for insertion at start: " + (endTime - startTime));
    }

    private static void populateANDTimePlayerIDS(List playerIDS)
    {
        final long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++)
        {
            playerIDS.add(i);
        }
        final long endTime = System.nanoTime();
        System.out.println(playerIDS.size());
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}

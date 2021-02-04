package com.dkit.gd2.johnloane;

import java.util.ArrayList;
import java.util.List;

/**
 * Collections
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List playerIDS = new ArrayList<>(20);

        populateANDTimePlayerIDS(playerIDS);
        timeNonEndInsertionIntoArrayList(playerIDS);
    }

    private static void timeNonEndInsertionIntoArrayList(List playerIDS)
    {
        final long startTime = System.nanoTime();
        playerIDS.add(5, 77);
        final long endTime = System.nanoTime();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

    private static void populateANDTimePlayerIDS(List playerIDS)
    {
        for(int i = 0; i < 10; i++)
        {
            final long startTime = System.nanoTime();
            playerIDS.add(i);
            final long endTime = System.nanoTime();
            System.out.println(playerIDS.size());
            System.out.println("Total execution time: " + (endTime - startTime));
        }
    }
}

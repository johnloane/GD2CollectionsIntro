package com.dkit.gd2.johnloane;

import java.util.*;

public class HolidayAdventure
{
    public static void main(String[] args)
    {
        List<String> placesToVisit = new LinkedList<>();
        insertAndTimeAtPosition(placesToVisit,0, "Letterkenny");
        insertAndTimeAtPosition(placesToVisit, 1,"Leitrim");
        insertAndTime(placesToVisit, "Vegas");
        insertAndTime(placesToVisit, "Limerick");
        insertAndTime(placesToVisit, "Paris");
        insertAndTime(placesToVisit, "Laois");
        insertAndTime(placesToVisit, "Louth");
        //insertAndTime(placesToVisit, "Galway");
        insertAndTimeAtPosition(placesToVisit, 0, "Galway");
        printList(placesToVisit);
        visit(placesToVisit);


        
        //printList(placesToVisit);
    }

    private static void insertAndTimeAtPosition(List<String> placesToVisit, int position, String newPlace)
    {
        final long startTime = System.nanoTime();
        placesToVisit.add(position, newPlace);
        final long endTime = System.nanoTime();
        System.out.println("Total execution time for adding: " + newPlace + " " + (endTime - startTime));
    }

    private static void insertAndTime(List<String> placesToVisit, String newPlace)
    {
        final long startTime = System.nanoTime();
        placesToVisit.add(newPlace);
        final long endTime = System.nanoTime();
        System.out.println("Total execution time for adding: " + newPlace + " " + (endTime - startTime));
    }

    private static void printList(List<String> placesToVisit)
    {//I am typing now I am typing something else
        Iterator<String> i = placesToVisit.iterator();
        while(i.hasNext())
        {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++");
    }

    private static boolean addInOrder(List<String> placesToVisit, String newPlace)
    {
        ListIterator<String> stringListIterator = placesToVisit.listIterator();

        //Plan
        //If the destination already exists -> do nothing don't add
        //Iterate the list and look for an element which is greater than what
        //I am trying to insert. Insert before that element
        //If we don't find anything greater insert at end
        while(stringListIterator.hasNext())
        {
            int comparison = stringListIterator.next().compareTo(newPlace);
            if(comparison == 0)
            {
                System.out.println(newPlace + " is already in the list");
                return false;
            }
            else if(comparison > 0)
            {
                //newPlace should appear before current destination
                stringListIterator.previous();
                stringListIterator.add(newPlace);
                return true;
            }
            else if(comparison < 0)
            {
                //move on
            }

        }
        stringListIterator.add(newPlace);
        return true;

    }

    //Visit method - should allow you to visit cities
    //takes in the LinkedList of placeToVisit
    //quit
    //go to the next city
    //go to the previous city
    //print the options

    private static void visit(List placesToVisit)
    {
        Scanner keyboard = new Scanner(System.in);
        final int QUIT = 0;
        final int FORWARD = 1;
        final int BACKWARDS = 2;
        final int PRINTMENU = 3;
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<String> listIterator = placesToVisit.listIterator();

        if(placesToVisit.isEmpty())
        {
            System.out.println("Nowhere to go");
            return;
        }
        else
        {
            //Essential to call listIterator.next() to link iterator to the list
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while(!quit)
        {
            int action = keyboard.nextInt();
            keyboard.nextLine();

            switch(action)
            {
                case QUIT:
                    System.out.println("Holiday is over");
                    quit = true;
                    break;
                case FORWARD:
                    if(!goingForward)
                    {
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext())
                    {
                        System.out.println("Now visiting " + listIterator.next());
                    }
                    else
                    {
                        System.out.println("Reached the end of the list");
                    }
                    break;
                case BACKWARDS:
                    if(goingForward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now visiting " + listIterator.previous());
                    }
                    else
                    {
                        System.out.println("Reached the start of the list");
                    }
                    break;
                case PRINTMENU:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu()
    {
        System.out.println("Available actions: \n press ");
        System.out.println("0 - to quit\n" + "1 - to go to the next destination\n" + "2 - to go to the previous destination\n" + "3 to print the menu");
    }
}

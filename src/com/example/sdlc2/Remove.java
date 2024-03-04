package com.example.sdlc2;


import java.util.ArrayList;
import java.util.Scanner;

public class Remove extends SDLC2 {
    /*
  Christina Rivera
  CEN 3024C
  1/30/2024
  Remove
  This class functions as the remove entry portion of the application
  */
    public static int now;
    public static int now1;
    public static int TB;

    public static String title;
    public static void choice() {
        /*
        choice
        This method takes user input for their choice of ID or book title
        void
        */

            System.out.println("Please enter the books ID to remove it");
            Scanner choice = new Scanner(System.in);
            Remove.now = choice.nextInt();
            if (now < 1) System.out.println("This is not a valid ID");


        /*
        System.out.println("Please enter the books ID to remove it");
        Scanner choice = new Scanner(System.in);
        Remove.now = choice.nextInt();
        if (now < 1) System.out.println("This is not a valid ID");
        */

    }

    public static void confirmChoice() {
        /*
        confirmChoice
        This method confirms the input with the user by having them insert 1 or 2
         */
            System.out.println("You have inserted: " + now + " Is this correct?");
            System.out.println("1 = Confirm   2 = Cancel");

            Scanner choice1 = new Scanner(System.in);
            Remove.now1 = choice1.nextInt();

    }

    public static void deleteChoice(ArrayList<Checkable> booksany) {
        /*
        deleteChoice
        This method removes the entry from the array list based on the input from the previous methods,
        and prints out a success and the new list after completion.
        ArrayList
        */
            if (now1 != 2) {
                booksany.remove(now);
            } else {
                System.out.println(now + "Will not be removed from the collection");
            }
            System.out.println("Success");
            System.out.println(booksany);



    }

}

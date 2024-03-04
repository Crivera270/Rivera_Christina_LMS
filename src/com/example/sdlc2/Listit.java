package com.example.sdlc2;

import java.util.ArrayList;

public class Listit extends SDLC2 {
    /*
  Christina Rivera
  CEN 3024C
  1/30/2024
  Listit
  This class functions as the list option in the menu.
  */
    public static ArrayList<Checkable> readItem(ArrayList<Checkable> booktest) {
        /*readItem
        This method simply prints out the content of the array list when called.
        ArrayList
        String*/
        System.out.println("Printing taking place....");
        System.out.println(booktest);

        return booktest;
    }
}

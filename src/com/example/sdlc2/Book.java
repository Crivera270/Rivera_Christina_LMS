package com.example.sdlc2;

import java.util.ArrayList;
import java.util.Scanner;

interface Checkable {
    boolean isCheckedIn();
    void setCheckedIn(boolean checkedIn);
}

public class Book extends SDLC2 implements Checkable{
    /*
  Christina Rivera CEN 3024C 1/30/2024
  Book class
  This class creates book objects and formats the arraylist
  This class also functions as the check-out check-in portion of code
  */

        private String BookID;
        private String Title;
        private String Author;
        private boolean checkedIn;

        public Book(String bookID, String title, String author) {
            this.BookID = bookID;
            this.Title = title;
            this.Author = author;
            //this.checkedIn = checkedIn;
            this.checkedIn = true;
        }
    @Override
    public String toString() {
        return
                '{'+"BookID='" + BookID + "\n" +
                ", Title='" + Title + "\n" +
                ", Author='" + Author + "\n" +
                ", checkedIn = " + checkedIn +
                '}' + "\n"
                +"";
    }

        @Override
        public boolean isCheckedIn() {
            return checkedIn;
        }

        @Override
        public void setCheckedIn(boolean checkedIn) {
            this.checkedIn = checkedIn;
        }


   public static void pick(ArrayList<Checkable> books1) {

            /*
            pick
            This method uses user input to check in and check out books from
            the collection
            ArrayList<Checkable> books1
            void
             */
       System.out.print("Would you like to  1: Check in   or   2: Check out ");
       Scanner scan = new Scanner(System.in);
       int pick = scan.nextInt();

       if(pick == 1){
           System.out.print("Please enter the ID of the book you wish to check in");
           int checkin = scan.nextInt();
           if (checkin >= 1 && checkin < books1.size()) {
               books1.get(checkin).setCheckedIn(true);
               System.out.println("Item checked in.");
           } else {
               System.out.println("Invalid ID.");
               System.out.println(books1);
           }

       }
       else{
           System.out.print("Please enter the ID of the book you wish to check out");
           System.out.println(books1);
           Scanner scan1 = new Scanner(System.in);
           Integer choices = scan1.nextInt();
           if (choices >= 1 && choices < books1.size()) {
               books1.get(choices).setCheckedIn(false);
               System.out.println("Item checked out.");
           } else {
               System.out.println("Invalid ID.");
               System.out.println(books1);
           }

       }
    }




}


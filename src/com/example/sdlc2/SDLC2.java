package com.example.sdlc2;

import java.util.ArrayList;
import java.util.Scanner;

public class SDLC2 implements Checkable{

    /*
    Christina Rivera
    CEN 3024C
    1/30/2024
    SDLC2
    This class functions as the 'run' class and has the menu and menu options for the console, along with the array list that holds the collection

    This programs objective is to create a straightforward portal for library employees to add book entries
    into a collection. Not only can they add but remove and list entries
    */



    public static void main(String[] args) {
        //C:\Users\chris\OneDrive\Documents\Custom Office Templates\Collection.txt
        /*main
        This method serves as the menu of the application, taking inputs and calling the correct class to complete the operation
        String array
        void*/




        final ArrayList<Checkable> books1 = new ArrayList<>();

       books1.add(new Book("0","This is the start of the collection",""));
        //books1.add(0,title,);
        //menu start
        System.out.println("Welcome to the new Library Management System");
        System.out.println("Here are the menu choices:");
        System.out.println("1. ADD entry");
        System.out.println("2. REMOVE entry");
        System.out.println("3. LIST all entries");
        System.out.println("4. Check out/Check in");
        System.out.println("5. EXIT");
        System.out.println(" ");
        //menu end



        Scanner choice = new Scanner(System.in);
        int now = choice.nextInt();

        while (now != 5) {
            switch (now) {
                case 1 ->
                    //add
                        Add.addElement(books1);
                case 2 -> {
                    //remove
                    Remove.choice();
                    Remove.confirmChoice();
                    Remove.deleteChoice(books1);
                }

                case 3 ->
                    //List all entries
                        Listit.readItem(books1);

                case 4 -> {

                    Book.pick(books1);
                    System.out.println("You have checked the book out");

                }


                default -> {
                    System.out.println("That is not a valid choice");
                }
            }

            //menu start
            System.out.println(" ");
            System.out.println("Please enter another command");
            System.out.println("1. ADD entry");
            System.out.println("2. REMOVE entry");
            System.out.println("3. LIST all entries");
            System.out.println("4. Check out/Check in");
            System.out.println("5. EXIT");
            System.out.println(" ");
            //menu end


            now = choice.nextInt();
        }
        choice.close();


    }


    @Override
    public boolean isCheckedIn() {
        return false;
    }

    @Override
    public void setCheckedIn(boolean checkedIn) {

    }
}

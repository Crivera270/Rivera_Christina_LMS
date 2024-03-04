package com.example.sdlc2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Add extends SDLC2 {
  /*
    Christina Rivera
    CEN 3024C
    1/30/2024
    Add class
    This class allows for the adding of values to the array list in the SDLC2 class
    */

    public static void addElement(ArrayList<Checkable> books1) {
        /*addElement
        This method is one of the menu options in the main method,
        It continues the dialog and includes functions for the code to take in user input and
        add it to the array list.
        ArrayList
        void*/
            System.out.println("Please enter your file name as a path");
            System.out.println("(Right click file, click copy as path, paste below)");


            Scanner choice = new Scanner(System.in);
            String now3 = choice.nextLine();

            File file = new File(now3);

            Scanner scan;
            try {
                scan = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            while (scan.hasNext()) {
                String line = scan.nextLine();
                Scanner scanner = new Scanner(line);
                scanner.useDelimiter(",");

                while (scanner.hasNext()) {
                    String bookID = scanner.next();
                    String title = scanner.next();
                    String author = scanner.next();
                    Book books = new Book(bookID,title,author);
                    books1.add(books);

                }

            }
            scan.close();

        }
    }

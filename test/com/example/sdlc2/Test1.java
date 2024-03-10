package com.example.sdlc2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class Test1 {
    //books can be added to the database
    //a book can be removed from the database by barcode or title
    //a book can be checked out.  If so, the due date is no longer "null".
    //a book can be checked in. If so, the due date is "null".
    ArrayList<Checkable> booktest = new ArrayList<>();
    //Test class
    //Listit.readItem
    //Remove.RemoveElement
    //Add.addElement
    //SDLC2.main
    @org.junit.jupiter.api.Test
    @DisplayName("Testing if books can be added to the database")
    public void testADDItem(){
        booktest.add(new Book("1","test","test"));
        Listit.readItem(booktest);

        Assertions.assertFalse(Listit.readItem(booktest).isEmpty());
        Assertions.assertEquals(1, Listit.readItem(booktest).size());

    }


    @Test
    @DisplayName("Testing if removeEasy method in Remove class removes")
    public void testremoveElement(){
        booktest.add(new Book("1","test","test"));
        booktest.add(new Book("1","test","test"));
        booktest.add(new Book("1","test","test"));
        booktest.add(new Book("1","test","test"));
        booktest.add(new Book("1","test","test"));

        Assertions.assertEquals(5, Listit.readItem(booktest).size());

        Remove.now = 1;
        Remove.now1 = 1;

        Remove.deleteChoice(booktest);
        Assertions.assertEquals(4, Listit.readItem(booktest).size());

    }


    @Test
    @DisplayName("Testing if a book is able to get checked in")
    public void testCheckin(){
        booktest.add(new Book("1","test","test"));
        booktest.add(new Book("1","test","test"));
        booktest.get(1).setCheckedIn(false);
        Listit.readItem(booktest);


        Book.pick1=1;
        Book.checkin = 1;

        Book.fortest(booktest);

        Listit.readItem(booktest);

    }
    @Test
    @DisplayName("Testing if a book is able to get checked out")
    public void testCheckout(){
        booktest.add(new Book("1","test","test"));
        booktest.add(new Book("1","test","test"));
        Listit.readItem(booktest);



        Book.pick1=2;
        Book.choices = 1;

        Book.fortest(booktest);

        Listit.readItem(booktest);
    }

}

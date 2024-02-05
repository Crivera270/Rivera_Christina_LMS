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
    ArrayList<String> booktest = new ArrayList<>();
    //Test class
    //Listit.readItem
    //Remove.RemoveElement
    //Add.addElement
    //SDLC2.main
    @org.junit.jupiter.api.Test
    @DisplayName("Testing if readItem method in Listit class outputs anything")
    public void testReadItem(){
        //ArrayList<String> booktest = new ArrayList<>();
        booktest.add("Hello, Goodbye, Good morning");
        Listit.readItem(booktest);

        Assertions.assertFalse(Listit.readItem(booktest).isEmpty());
        Assertions.assertEquals(1, Listit.readItem(booktest).size());

    }


    @Test
    @DisplayName("Testing if removeEasy method in Remove class removes")
    public void testremoveElement(){
        booktest.add("This is the start of the collection");
        booktest.add("Hello, Goodbye, Good morning");
        booktest.add("Apple, Banana, Orange");
        booktest.add("Mylo, Christina, Rafael");
        booktest.add("A,B,C");
        Assertions.assertEquals(5, Listit.readItem(booktest).size());

        Remove.now = 1;
        Remove.now1 = 1;

        Remove.deleteChoice(booktest);
        Assertions.assertEquals(4, Listit.readItem(booktest).size());

    }

    @Test
    @DisplayName("Testing")
    public void testaddElement(){



        Add.addElement(booktest);

    }
    @Test
    @DisplayName("Testing")
    public void testMain(){


    }
}

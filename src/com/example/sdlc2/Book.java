package com.example.sdlc2;

public class Book extends SDLC2{
    /*
  Christina Rivera CEN 3024C 1/30/2024
  Book class
  This class creates book objects and formats the arraylist
  */
    private String BookID;
    private String Title;
    private String Author;

    @Override
    public String toString() {

        return
                "{ BookID='" + BookID + '\'' +
                ", Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }

    public Book(String bookID, String title, String author) {

        BookID = bookID;
        Title = title;
        Author = author;

    }
}

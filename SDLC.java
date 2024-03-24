import com.example.sdlc2.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class SDLC extends JFrame implements Checkable {
    /* Christina Rivera CEN 3024C 03/24/2024
    SDLC
    This class creates the GUI that the user will interact with
     */
    private JPanel mainPanel;
    private JButton addButton;
    private JButton checkOutButton;
    private JButton checkInButton;
    private JButton removeButton;
    private JButton listCollectionButton;
    private JTextField TF1;
    private JButton Remove2;
    private JTextField TF3;
    private JButton enterButton1;
    private JLabel o1;
    private JLabel o2;
    private JTextField TF2;
    private JButton Add2;
    private JTextField TF4;
    private JButton enterButton2;
    private JTextArea textArea1;
    private JButton exit;
    private JLabel check1;

    private JLabel check2;

    final ArrayList<Checkable> books1 = new ArrayList<>();



    public SDLC(){
       /* SDLC
        This method holds all of the functional code that the
        main method then creates an instance of it
        */

        books1.add(new Book("0","This is the start of the collection",""));
        setContentPane(mainPanel);
    setTitle("Library Management");
    setSize(1000,800);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);

        listCollectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {

                textArea1.setText("Printing..." + Listit.readItem(books1));
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                o1.setText("Please enter the books ID to remove it");
            }
        });

        Remove2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a)  {
                //removes an entry using user input
                try {
                    Remove.now1 = 1;
                    Remove.now = Integer.parseInt(TF1.getText());
                    Remove.deleteChoice(books1);
                    o1.setText("Complete");
                } catch(IndexOutOfBoundsException e){
                    o1.setText("ERROR: Id not found");


                }

            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                o2.setText("Please enter your file name as path");
            }
        });
        Add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                //takes user input and adds data from a txt file
                //C:\Users\chris\OneDrive\Documents\Custom Office Templates\Collection.txt

                String now3 = TF2.getText();

                File file = new File(now3);

                Scanner scan = null;
                try {
                    scan = new Scanner(file);
                } catch (FileNotFoundException e) {
                    //throw new RuntimeException(e);
                    o2.setText("File not found");
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

        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                System.exit(0);
            }
        });
        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                check1.setText("Please enter the ID of the book you wish to check in ");

            }
        });
        enterButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                //takes user input and checks in the book, changing due date to null

                try {
                    Book.checkin = Integer.parseInt(TF3.getText());
                    books1.get(Book.checkin).setCheckedIn(true);
                    books1.get(Book.checkin).setDate(null);
                    check1.setText("Success");
                } catch(IndexOutOfBoundsException e){
                    check1.setText("ERROR: Id not found");


                }
            }
        });

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                check2.setText("Please enter the ID of the book you wish to check out ");
            }
        });

        enterButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                //takes user input and checks out book, setting a due date
                try {
                    Book.choices = Integer.parseInt(TF4.getText());
                    books1.get(Book.choices).setCheckedIn(false);

                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.DATE, 28);

                    books1.get(Book.choices).setDate(String.valueOf(cal.getTime()));
                    check2.setText("Success, Due date is:  " +String.valueOf(cal.getTime()));
                } catch(IndexOutOfBoundsException e){
                    check2.setText("ERROR: Id not found");


                }

              

            }
        });
    }

    public static void main(String[] args) {
        SDLC test = new SDLC();
    }

    @Override
    public boolean isCheckedIn() {
        return false;
    }

    @Override
    public void setCheckedIn(boolean checkedIn) {

    }

    @Override
    public void setDate(String Due) {

    }

    @Override
    public String date() {
        return null;
    }
}

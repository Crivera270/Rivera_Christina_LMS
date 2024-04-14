
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SDLC extends JFrame {
    /**
     * Christina Rivera CEN 3024C 03/24/2024
     * SDLC
     * This class contains the methods to add functionality to the
     * SDLC form.
     * This includes the instantiation of a new collection object
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

    public static void main(String[] args) {
        /**
         * main
         * This is the main method
         * Its function is to instantiate a new SDLC object
         * void
         */
        SDLC test = new SDLC();
    }

    ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
    collection db2 = new collection();

    public SDLC() {
        /**
         * SDLC
         * This method holds most of the functional code that the main method then creates an instance of
         * Including the actionListeners for the SDLC form
         * No arguments
         * No return value
         */
        setContentPane(mainPanel);
        setTitle("Library Management");
        setSize(1000, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        listCollectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                /**
                 * listCollectionButton (action listener)
                 * This method performs a query to select all the information
                 * from the collection database
                 * It then appends each record to the main output area: textArea1
                 */

                data = db2.getExecuteResult("select * from collection");
                textArea1.setText("");

                for (List<Object> record1 : data) {
                    System.out.println(record1.toString());

                    textArea1.append(record1.toString() + "\n");
                }

            }

        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * removeButton
                 * Displays text
                 */

                o1.setText("Please enter the books ID to remove it");
            }
        });

        Remove2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                /**
                 * Remove2 Button
                 * Takes user input and uses it to perform a query that removes
                 * the selected record from the database, then prints the database
                 */
                //removes an entry using user input
                try {
                    int choice = Integer.parseInt((TF1.getText()));
                    db2.delete("collection.BookID", String.valueOf(choice));
                    o1.setText("Deleted");
                    data = db2.getExecuteResult("select * from collection");

                    textArea1.setText("");

                    for (List<Object> record1 : data) {
                        System.out.println(record1.toString());
                        // Append each record to the text area
                        textArea1.append(record1.toString() + "\n");
                    }

                } catch (Exception e) {

                    throw new RuntimeException(e);
                }

            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                /**
                 * addButton
                 * Displays text
                 */
                o2.setText("Please enter your file name as path");
            }
        });
        Add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                //takes user input and adds data from a txt file
                //C:\Users\chris\OneDrive\Documents\Custom Office Templates\Collection.txt

            }

        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                /**
                 * exit Button
                 * Exits the program
                 */
                System.exit(0);
            }
        });
        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                /**
                 * checkInButton
                 * Displays text
                 */
                check1.setText("Please enter the ID of the book you wish to check in ");

            }
        });
        enterButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                /**
                 * enterButton1
                 * Takes in user input and uses it to run a query and check out a book
                 * This changes the Due date to null and Checked in status to 'Y'
                 */
                //takes user input and checks in the book, changing due date to null
                int choice = Integer.parseInt((TF3.getText()));
                db2.update(db2.checkedIn, "Y", db2.BookID, String.valueOf(choice));
                data = db2.getExecuteResult("UPDATE collection SET DUE = 'NULL' WHERE BookId = " + choice + ";");
                data = db2.getExecuteResult("select * from collection");
                textArea1.setText("");
                for (List<Object> record : data) {
                    System.out.println(record.toString());
                    // Append each record to the text area
                    textArea1.append(record.toString() + "\n");

                    textArea1.setText("");
                    check1.setText("Checked IN");
                    data = db2.getExecuteResult("select * from collection");

                    for (List<Object> record1 : data) {
                        System.out.println(record1.toString());
                        // Append each record to the text area
                        textArea1.append(record1.toString() + "\n");
                    }

                }
            }
        });


        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                /**
                 * checkOutButton
                 * Displays text
                 */
                check2.setText("Please enter the ID of the book you wish to check out ");
            }
        });

        enterButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                /**
                 * enterButton2
                 * Takes user input to run a query that updates the collection
                 * Sets checked in status to 'N' and Due to 2 weeks from today
                 */
                //takes user input and checks out book, setting a due date
                int choice1 = Integer.parseInt((TF4.getText()));
                db2.update(db2.checkedIn, "N", db2.BookID, String.valueOf(choice1));
                data = db2.getExecuteResult("UPDATE collection SET DUE = current_date WHERE BookId = " + choice1 + ";");
                data = db2.getExecuteResult("UPDATE collection SET DUE = date ('now','+14 days') WHERE BookId = " + choice1 + ";");

                data = db2.getExecuteResult("select * from collection");
                textArea1.setText("");

                for (List<Object> record1 : data) {
                    System.out.println(record1.toString());
                    // Append each record to the text area
                    textArea1.append(record1.toString() + "\n");
                }


            }
        });


    }
}

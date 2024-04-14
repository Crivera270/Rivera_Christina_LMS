
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
public class LibraryDB {

    public static void main (String [] args){
        //create an instance of our database class, collection
    collection db1 = new collection();

    //Create a 2D arraylist to hold the result of a query
        ArrayList<ArrayList<Object>> data = new ArrayList <ArrayList<Object>>();

        //perform a query to get all contents of the database
        data = db1.getExecuteResult("select * from collection");

        //print the result of the query, by printing what is stored in array list data
        for (List<Object> record: data){
            System.out.println(record.toString());
        }

        //delete a row of data from the database, based on ID
        //does not do anything right now ****
        db1.delete ("collection.BookID", "100");

        System.out.println("Deleted");

        //print out

        data = db1.getExecuteResult("select * from collection");
        System.out.println("\n Here are the contents of the database");
        printDatabase(data);

        //add a new entry to the database
        db1.insert(1001,"Music","Christina R",true,"04-25-2023");

        data = db1.getExecuteResult("select * from collection");
        System.out.println("\n Here are the contents of the database");
        printDatabase(data);

        //You can run any query with
        //data= db1.getExecuteResult("");

        //update a row of data from the database
        db1.update(db1.Author, "Hello", String.valueOf(db1.BookID),"111");
        System.out.println("Updated");

        //pull all records from the database and print
        data= db1.getExecuteResult("Select * from collection");
        System.out.println("\n Here are the contents of the database: \n");
        printDatabase(data);

    }

public static void printDatabase(ArrayList<ArrayList<Object>> data){
    for (List<Object> record: data){
        System.out.println(record.toString());
    }
}


}

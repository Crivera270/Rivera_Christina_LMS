import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//aka JDBC
public class Librarysys {

public static void main(String[] args) throws SQLException{
    String url="jdbc:sqlite:C:/Users/chris/OneDrive/Documents/SQL/library.db";
String uname = "crivera";
String password = "password";
String query = "select * from collection";

try {
    //magic
    Connection con = DriverManager.getConnection(url,uname,password);
    Statement statement = con.createStatement();
    ResultSet result = statement.executeQuery(query);

    while(result.next()){ //each row of data until no next
        String libraryData = "";
        for (int i = 1; i <= 5; i++){
            libraryData += result.getString(i)+",";
        }
        System.out.println(libraryData);

    }
}
catch (SQLException e){
    e.printStackTrace();

}

}



}


//aka engineering students
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;

public class collection extends DBHelper {
	private final String TABLE_NAME = "collection";
	public static final String BookID = ("BookID");
	public static final String Title = "Title";
	public static final String Author = "Author";
	public static final String checkedIn = "checkedIn";
	public static final Date Due = new Date();

	//first method
	//prepares the text of a SQL "select command
	//
	private String prepareSQL(String fields, String whatField, String whatValue, String sortField, String sort) {
		String query = "SELECT ";
		query += fields == null ? " * FROM " + TABLE_NAME : fields + " FROM " + TABLE_NAME;
		query += whatField != null && whatValue != null ? " WHERE " + whatField + " = \"" + whatValue + "\"" : "";
		query += sort != null && sortField != null ? " order by " + sortField + " " + sort : "";
		return query;
	}

	//Allows us to insert new row into database
	public void insert(Integer BookID, String Title, String Author, Boolean checkedIn, String Due) {
		Title = Title != null ? "\"" + Title + "\"" : null;
		Author = Author != null ? "\"" + Author + "\"" : null;
		Due = Due != null ? "\"" + Due + "\"" : null;
		
		Object[] values_ar = {BookID, Title, Author, checkedIn, Due};
		String[] fields_ar = {String.valueOf(collection.BookID), collection.Title, collection.Author, String.valueOf(collection.checkedIn), String.valueOf(collection.Due)};
		String values = "", fields = "";
		for (int i = 0; i < values_ar.length; i++) {
			if (values_ar[i] != null) {
				values += values_ar[i] + ", ";
				fields += fields_ar[i] + ", ";
			}
		}
		if (!values.isEmpty()) {
			values = values.substring(0, values.length() - 2);
			fields = fields.substring(0, fields.length() - 2);
			super.execute("INSERT INTO " + TABLE_NAME + "(" + fields + ") values(" + values + ");");
		}
	}
//removes record from database
	public void delete(String whatField, String whatValue) {
		super.execute("DELETE from " + TABLE_NAME + " where " + whatField + " = " + whatValue + ";");
	}

	//updates
	public void update(String whatField, String whatValue, String whereField, String whereValue) {
		super.execute("UPDATE " + TABLE_NAME + " set " + whatField + " = \"" + whatValue + "\" where " + whereField + " = \"" + whereValue + "\";");
	}
	public void updatedate(String whatField, Date whatValue, String whereField, String whereValue) {
		super.execute("UPDATE " + TABLE_NAME + " set " + whatField + " = \"" + whatValue + "\" where " + whereField + " = \"" + whereValue + "\";");
	}

	public ArrayList<ArrayList<Object>> select(String fields, String whatField, String whatValue, String sortField, String sort) {
		return super.executeQuery(prepareSQL(fields, whatField, whatValue, sortField, sort));
	}

	public ArrayList<ArrayList<Object>> getExecuteResult(String query) {
		return super.executeQuery(query);
	}

	public void execute(String query) {
		super.execute(query);
	}

	public DefaultTableModel selectToTable(String fields, String whatField, String whatValue, String sortField, String sort) {
		return super.executeQueryToTable(prepareSQL(fields, whatField, whatValue, sortField, sort));
	}

}
package grandinConstruction;
import java.sql.*;
import java.util.LinkedList;

import javax.sql.DataSource;


public class MainDbUtil {
	private DataSource dataSource;
	private LinkedList<String> tables = new LinkedList<String>();
	
	public MainDbUtil(DataSource dataSource) throws Exception {
		this.dataSource = dataSource;
		getTables(tables);
	}
	
	public LinkedList<String> getTables() {
		return tables;
	}

	public int getNumTables() {
		return tables.size();
	}
	
	private void close(Connection connection, 
						Statement statement,
						ResultSet result) {
		/* Closes connections to the database. */
		try {
			if (connection != null)
				connection.close();
			if (statement != null)
				statement.close();
			if (result != null)
				result.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getTables(LinkedList<String> tables) throws Exception {
		/* Gets a list of database tables. */
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement("show tables");
			result = statement.executeQuery();
			
			while (result.next()) {
				tables.add(result.getString(1));
			}
		} finally {
			close(connection, statement, result);
		}
	}
	
//	private String createSearchQuery(String table, String name) throws Exception {
//		return String.format("SELECT * FROM %s WHERE name = %s", table, name);
//	}
	
	public Item searchByName(String table, String name) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement("show tables");
			result = statement.executeQuery();
			
			return new Item(result.getInt("id"), result.getString("name"), result.getDouble("dollars"), result.getString("supplier"));
		} finally {
			close(connection, statement, result);
		}
	}
}

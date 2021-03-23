package JDBC_Queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Insert {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement=null;
		ResultSet resultSet =null;
		String url = "jdbc:mysql://localhost:3306/ebookshop";
		String username="root";
		String password="root";
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();

			//String sqlQuery = "insert into books values(6, 'Gone Fishing', 'Jack jones', 24.99, 50);";
			String sqlQuery = "insert into books values(7, 'Anna Karanina', 'Leo Tolstoy', 34.99, 20);";
			
			System.out.println("The SQL Query is " + sqlQuery);

			int countInserted = statement.executeUpdate(sqlQuery);
			System.out.println("Number of rows inserted " + countInserted);

			resultSet = statement.executeQuery("select * from books;");

			while (resultSet.next()) {
				System.out.println(resultSet.getString("title") + " - " + resultSet.getString("author") + " "
						+ resultSet.getDouble("price"));
			}
System.out.println();
			resultSet = statement.executeQuery("select author from books;");

			while (resultSet.next()) {
				System.out.println(resultSet.getString("author"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}

	


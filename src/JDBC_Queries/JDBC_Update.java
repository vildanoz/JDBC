package JDBC_Queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Update {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement=null;
		ResultSet resultSet =null;
		String url = "jdbc:mysql://localhost:3306/ebookshop";
		String username="root";
		String password="root";
		
		try {
			connection=DriverManager.getConnection(url, username, password);
			statement=connection.createStatement();
			String update="update books set price=(price*0.9),qty=qty+5 where id =1;";
			System.out.println("The SQL Query is "+update);
			
			//insert, update delete are use executeQuery
			statement.executeUpdate(update);
			
			String select="select * from books";
			System.out.println("The SQL Query is "+select);
			resultSet=statement.executeQuery(select);
			while(resultSet.next()) {
				System.out.println(resultSet.getString("title")+" - "+resultSet.getString("author")+" - "+
			resultSet.getDouble("price")+" - "+resultSet.getInt("qty"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		

	}

}

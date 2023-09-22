package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconn {
	
	public Connection connection(){
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tests", "root", "");
						
		} catch (ClassNotFoundException e) {
			System.out.println("Database connection failed!");
		} catch (SQLException e) {
			System.out.println("Database access failed!");	
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void queryClients() throws SQLException {
		
		Connection conn = null;
		
		try {
			
			conn = connection();
			
			ResultSet rsClient = conn.createStatement().executeQuery("SELECT * FROM CLIENTS");
			
			while(rsClient.next()) {
				System.out.println("Name: " + rsClient.getString("clientName"));
			}
			
		} catch (SQLException e) {
			System.out.println("Error on query!");
		}
		
		if(conn != null) {
			conn.close();
		}
	}
	
	public void insertClient(String name) throws SQLException {
		
		Connection conn = null;		
		PreparedStatement pstm = null;
		String insert = "INSERT INTO clients(clientName) VALUES (?)";
		
		try {
			
			conn = connection();
			
			pstm = conn.prepareStatement(insert);
			pstm.setString(1, name);
			
			pstm.execute();
			
		} catch (SQLException e) {
			System.out.println("Error on insert!");
			
		} finally {
			
			if(pstm != null) pstm.close();
			if(conn != null) conn.close();
			
		}
		
	}
	
	public void deleteClient(int id) throws SQLException {
		
		Connection conn = null;		
		PreparedStatement pstm = null;
		String delete = "DELETE FROM clients WHERE ID = ?";
		
		try {
			
			conn = connection();
			pstm = conn.prepareStatement(delete);
			pstm.setInt(1, id);
			
			pstm.execute();
			
		} catch (SQLException e) {
			System.out.println("Error on delete!");
			
		} finally {
			
			if(pstm != null) pstm.close();
			if(conn != null) conn.close();
			
		}
		
	}
	
}

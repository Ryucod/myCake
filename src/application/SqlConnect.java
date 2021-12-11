package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SqlConnect {
	private Connection conn;
	
	public static Connection getConnection() {		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//create connection
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest", "mytest");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}

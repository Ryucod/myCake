package common;

import java.sql.*;
public class ConnUtil {
	Connection conn = null;
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1",
		                         "mytest", "mytest");
		    return con;
		    } catch (Exception e) {
		    	System.err.println("ConnUtil: " + e.getMessage());
		    	return null;
		    }
		   
		}
		public static void close(PreparedStatement pstmt, Connection conn) {
		    if (pstmt != null) {
		       try {
		    	   if (!pstmt.isClosed())   pstmt.close();
		       } catch (Exception e) {
		    	   e.printStackTrace();
		       } finally {
		           pstmt = null;
		       }
		    }
		    if (conn != null) {
		       try {
		           if (!conn.isClosed())   conn.close();
		       } catch (Exception e) {
		           e.printStackTrace();
		       } finally {
		           conn = null;
		       }
		    }
		 }
		 public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		    if (rs != null) {
		    	try {
		           if (!rs.isClosed())   rs.close();
		        } catch (Exception e) {
		           e.printStackTrace();
		        } finally {
		           rs = null;
		        }
		    }
		    if (pstmt != null) {
		        try {
		           if (!pstmt.isClosed())   pstmt.close();
		        } catch (Exception e) {
		           e.printStackTrace();
		        } finally {
		           pstmt = null;
		        }
		    }
		    if (conn != null) {
		        try {
		           if (!conn.isClosed())   conn.close();
		        } catch (Exception e) {
		           e.printStackTrace();
		        } finally {
		           conn = null;
		        }
		    }
		 }
}

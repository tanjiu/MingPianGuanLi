package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
	private static String url="jdbc:mysql://localhost:3306/mingpian?&useSSL=false";
	private static String userName="root";    
	private static String passWord="1234";
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,userName,passWord);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeAll(ResultSet rs,PreparedStatement pst) {
		try {
			if(rs!=null)
				rs.close(); 
			if(pst!=null)
				pst.close();		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void closeConn(Connection  conn) {
		try {
			if(conn!=null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


package dao.proxy;

import java.sql.Connection;

import dao.AdminLoginDAO;
import dao.impl.AdminLoginImpl;

public class AdminLoginDAOProxy implements AdminLoginDAO {

	private Connection conn=null;
	private AdminLoginDAO dao=null;

	public AdminLoginDAOProxy() {
		// TODO Auto-generated constructor stub
		try {
			this.conn=DBConnection.DBUtil.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.dao=new AdminLoginImpl(conn);
	}

	@Override
	public boolean Exists(String User,String Pwd) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			flag=this.dao.Exists(User,Pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return flag;
	}
	
}

package dao.proxy;

import java.sql.Connection;

import dao.YongHuLoginDAO;
import dao.impl.LoginImpl;


public class LoginDAOProxy implements YongHuLoginDAO {
	private Connection conn=null;
	private YongHuLoginDAO dao=null;

	public LoginDAOProxy() {
		// TODO Auto-generated constructor stub
		try {
			this.conn=DBConnection.DBUtil.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.dao=new LoginImpl(conn);
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
	
	public boolean AddZhangHao(String User,String Pwd) {
		boolean flag=false;
		try {
			flag=this.dao.AddZhangHao(User, Pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return flag;
	}
	
	
	public int getBianHao(String ZhangHao) {
		int bh=-1;
		try {
			bh=this.dao.getBianHao(ZhangHao);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return bh;
	}
	public boolean ExistsZH(String ZhangHao) {
		boolean flag=false;
		try{
			flag=this.dao.ExistsZH(ZhangHao);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return flag;
	}
	public boolean updateMiMa(String User,String Pwd) {
		boolean flag=false;
		try{
			flag=this.dao.updateMiMa(User, Pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return flag;		
	}
}

package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginImpl implements dao.AdminLoginDAO {
	private Connection conn=null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	
	public AdminLoginImpl(Connection conn) {
		this.conn=conn;
	}
	
	@Override
	public boolean Exists(String User,String Pwd) {
		// TODO Auto-generated method stub
		StringBuilder strSql=new StringBuilder();
		int count=0;
		strSql.append("select count(*) from adminlogin where zhanghao='"+User+"' and mima='"+Pwd+"' ");
		try {
			pst=conn.prepareStatement(strSql.toString());
			rs=pst.executeQuery();
			if(rs.next())
				count=rs.getInt(1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		if(count>0)
			return true;
		return false;
	}
}

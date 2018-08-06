package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginImpl implements dao.YongHuLoginDAO {
	private Connection conn=null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	
	public LoginImpl(Connection conn) {
		this.conn=conn;
	}
	
	@Override
	public boolean Exists(String User,String Pwd) {
		// TODO Auto-generated method stub
		StringBuilder strSql=new StringBuilder();
		int count=0;
		strSql.append("select count(*) from login where zhanghao='"+User+"' and mima='"+Pwd+"' ");
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

	public boolean AddZhangHao(String User,String Pwd) {
		StringBuilder strSql=new StringBuilder();
		int line=0;
		strSql.append("insert into login(zhanghao,mima) values(?,?)");
		try {
			pst=conn.prepareStatement(strSql.toString());
			pst.setString(1,User);
			pst.setString(2, Pwd);
			line=pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		if(line>0)
			return true;
		return false;
	}
	
	
	
	public int getBianHao(String ZhangHao) {
		StringBuilder strSql=new StringBuilder();		
		int bh=-1;//ÓÃÓÚ±£´æÕËºÅ
		strSql.append("select * from login where zhanghao=?");
		try {
			pst=conn.prepareStatement(strSql.toString());
			pst.setString(1, ZhangHao);
			rs=pst.executeQuery();				
			if(rs.next()) {
				bh=rs.getInt("ZHBianHao");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		return bh;
	}
	
	public boolean ExistsZH(String ZhangHao) {
		StringBuilder strSql=new StringBuilder();
		int line=0;
		strSql.append("select count(*) from login where zhanghao=?");
		try {
			pst=conn.prepareStatement(strSql.toString());
			pst.setString(1,ZhangHao);
			rs=pst.executeQuery();
			if(rs.next())
				line=rs.getInt(1);			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		if(line>0)
			return true;
		return false;		
	}
	
	public boolean updateMiMa(String User,String Pwd) {
		StringBuilder strSql=new StringBuilder();
		int line=0;
		strSql.append("update login set mima=? where zhanghao=?");
		try {
			pst=conn.prepareStatement(strSql.toString());
			pst.setString(1, Pwd);
			pst.setString(2, User);
			line=pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		if(line>0)
			return true;
		return false;		
	}
}

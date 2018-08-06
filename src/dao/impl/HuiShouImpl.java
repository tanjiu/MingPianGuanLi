package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.MingPianDAO;
import vo.MingPianModel;

public class HuiShouImpl implements MingPianDAO {
	private Connection conn=null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	public HuiShouImpl(Connection conn) {
		this.conn=conn;
	}
	
	/**
	 * ���һ����¼
	 */
	@Override
	public boolean addMingPian(MingPianModel mp) {
		// TODO Auto-generated method stub
		int line=0;
		StringBuilder strSql = new StringBuilder();
		strSql.append("insert into huishouzhan values (null,?,?,?,?,?)");
		try {			
			pst = conn.prepareStatement(strSql.toString());
			pst.setString(1, mp.getXingMing());
			pst.setString(2, mp.getZhiWu());
			pst.setString(3, mp.getLianXiFangShi());
			pst.setString(4, mp.getYouXiang());
			pst.setString(5, mp.getGongZuoDanWei());
			line = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.DBUtil.closeAll(rs, pst);
			//�쳣�ڷ������׳�
		}
		if (line > 0)
			return true;		
		return false;
	}

	
	
	/**
	 * ���һ����¼�����������Ϣ
	 */
	public boolean addMingPianAll(MingPianModel mp) {
		int line = 0;
		StringBuilder strSql = new StringBuilder();
		strSql.append("insert into huishouzhan values (null,?,?,?,?,?,?)");
		try {
			pst = conn.prepareStatement(strSql.toString());
			pst.setString(1, mp.getXingMing());
			pst.setString(2, mp.getZhiWu());
			pst.setString(3, mp.getLianXiFangShi());
			pst.setString(4, mp.getYouXiang());
			pst.setString(5, mp.getGongZuoDanWei());
			pst.setInt(6, mp.getZHBianHao());
			line = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.DBUtil.closeAll(rs, pst);
			// �쳣�ڷ������׳�
		}
		if (line > 0)
			return true;
		return false;
	}
	/**
	 * ɾ��һ����¼
	 */
	@Override
	public boolean deleteMingPian(int BianHao) {
		// TODO Auto-generated method stub
		int line = 0;
		StringBuilder strSql = new StringBuilder();
		strSql.append("delete from huishouzhan where BianHao=?");
		try {			
			pst = conn.prepareStatement(strSql.toString());
			pst.setInt(1, BianHao);
			line = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		if (line > 0)
			return true;	
		return false;		
	}

	/**
	 * ����һ����¼
	 */
	@Override
	public boolean updateMingPian(MingPianModel mp) {
		// TODO Auto-generated method stub
		int line = 0;
		StringBuilder strSql = new StringBuilder();
		strSql.append("update huishouzhan set XingMing=?,ZhiWu=?,LianXiFangShi=?,YouXiang=?,GongZuoDanWei=? ");
		strSql.append(" where BianHao=? ");
		try {			
			pst = conn.prepareStatement(strSql.toString());
			pst.setString(1, mp.getXingMing());
			pst.setString(2, mp.getZhiWu());
			pst.setString(3, mp.getLianXiFangShi());
			pst.setString(4, mp.getYouXiang());
			pst.setString(5, mp.getGongZuoDanWei());
			pst.setInt(6, mp.getBianHao());
			line = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		if (line > 0)
			return true;
		return false;
	}

	/**
	 * ��ȡ���м�¼
	 */
	@Override
	public List<MingPianModel> getAllMingPian() {
		// TODO Auto-generated method stub
		StringBuilder strSql=new StringBuilder();
		List<MingPianModel> list=new ArrayList<MingPianModel>();
		strSql.append("select * from huishouzhan ");
		//��̬��������
		try {			
			pst=conn.prepareStatement(strSql.toString());
			rs=pst.executeQuery();
			while(rs.next()) {
				MingPianModel mp=new MingPianModel(rs.getInt("BianHao"),rs.getString("XingMing"),rs.getString("ZhiWu"),rs.getString("LianXiFangShi"),rs.getString("YouXiang"),rs.getString("GongZuoDanWei"));
				list.add(mp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		return list;
	}

	/**
	 * ͨ��������ȡһ����¼
	 */
	@Override
	public MingPianModel getMingPianById(int BianHao) {
		// TODO Auto-generated method stub
		MingPianModel mpModel = null;
		StringBuilder strSql = new StringBuilder();
		strSql.append("select * from huishouzhan where BianHao=?");
		try {			
			pst = conn.prepareStatement(strSql.toString());
			pst.setInt(1, BianHao);
			rs = pst.executeQuery();
			if (rs.next()) {
				mpModel = new MingPianModel(rs.getInt("BianHao"), rs.getString("XingMing"), rs.getString("ZhiWu"),
						rs.getString("LianXiFangShi"), rs.getString("YouXiang"), rs.getString("GongZuoDanWei"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		return mpModel;
	}

	/**
	 * �жϼ�¼�Ƿ����
	 */
	@Override
	public boolean Exists(int BianHao) {
		// TODO Auto-generated method stub
		int flag = 0;
		StringBuilder strSql = new StringBuilder();
		strSql.append("select count(1) from huishouzhan ");
		strSql.append(" where BianHao=?");
		try {			
			pst = conn.prepareStatement(strSql.toString());
			pst.setInt(1, BianHao);
			rs = pst.executeQuery();
			while (rs.next()) {
				int n = rs.getInt(1);
				if (n > 0)
					flag = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		if (flag == 1)
			return true;
		return false;
	}

	/**
	 * ģ����ѯ
	 */
	@Override
	public List<MingPianModel> getMingPianByMoHu(String name) {
		// TODO Auto-generated method stub
		StringBuilder strSql=new StringBuilder();
		List<MingPianModel> list=new ArrayList<MingPianModel>();
		strSql.append("select * from huishouzhan where XingMing like ?");
		try {			
			pst=conn.prepareStatement(strSql.toString());
			pst.setString(1, "%"+name+"%");
			rs=pst.executeQuery();
			while(rs.next()) {
				MingPianModel mp=new MingPianModel(rs.getInt("BianHao"),rs.getString("XingMing"),rs.getString("ZhiWu"),rs.getString("LianXiFangShi"),rs.getString("YouXiang"),rs.getString("GongZuoDanWei"));
				list.add(mp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		return list;
	}

	/**
	 * ��ҳ��ȡ����
	 */	
	public List<MingPianModel> getMingPianByPage(int index,int pageSize){
		StringBuilder strSql=new StringBuilder();
		List<MingPianModel> list=new ArrayList<MingPianModel>();
		strSql.append("select * from huishouzhan limit ?,?");
		try {
			pst=conn.prepareStatement(strSql.toString());
			pst.setInt(1, index);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			while(rs.next()) {
				MingPianModel mp=new MingPianModel(rs.getInt("BianHao"),rs.getString("XingMing"),rs.getString("ZhiWu"),rs.getString("LianXiFangShi"),rs.getString("YouXiang"),rs.getString("GongZuoDanWei"));
					list.add(mp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		return list;
	}
	
	/**
	 * ����ɾ��
	 */
	public boolean deleteMingPianList(String idList) {
		int line=0;
		StringBuilder strSql=new StringBuilder();
		strSql.append("delete from huishouzhan where BianHao in (" +idList+")");
		try {
			pst=conn.prepareStatement(strSql.toString());
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
	
	/**
	 * ��ü�¼����
	 */
	public int getRecord() {
		int count=0;
		StringBuilder strSql=new StringBuilder();
		strSql.append("select count(*) from huishouzhan");
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
		return count;
	}
	
	
	/**
	 * ������ȡ����
	 */
	public List<MingPianModel> getMingPianPiLiang(String idList) {
		StringBuilder strSql = new StringBuilder();
		List<MingPianModel> list = new ArrayList<MingPianModel>();
		strSql.append("select * from huishouzhan where BianHao in (" + idList + ")");
		try {
			pst = conn.prepareStatement(strSql.toString());
			rs = pst.executeQuery();
			while (rs.next()) {
				MingPianModel mp = new MingPianModel(rs.getInt("BianHao"), rs.getString("XingMing"),
						rs.getString("ZhiWu"), rs.getString("LianXiFangShi"), rs.getString("YouXiang"),
						rs.getString("GongZuoDanWei"));
				list.add(mp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		return list;
	}
	/**
	 * ���������Ż�ȡ��Ƭ��Ϣ
	 */
	public MingPianModel getMingPianByWJ(int ZHBianHao) {
		return new MingPianModel();
	}
}

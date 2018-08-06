package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.MingPianDAO;
import vo.MingPianModel;

public class MingPianImpl implements MingPianDAO {
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	public MingPianImpl(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 添加一条记录
	 */
	@Override
	public boolean addMingPian(MingPianModel mp) {
		// TODO Auto-generated method stub
		int line = 0;
		StringBuilder strSql = new StringBuilder();
		strSql.append("insert into mingpianbiao(XingMing,ZhiWu,LianXiFangShi,YouXiang,GongZuoDanWei)  values(?,?,?,?,?)");
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
			// 异常在方法中抛出
		}
		if (line > 0)
			return true;
		return false;
	}
	
	
	/**
	 * 添加一条记录，包含外键信息
	 */
	public boolean addMingPianAll(MingPianModel mp) {
		int line = 0;
		StringBuilder strSql = new StringBuilder();
		strSql.append("insert into mingpianbiao values (null,?,?,?,?,?,?)");
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
			// 异常在方法中抛出
		}
		if (line > 0)
			return true;
		return false;
	}

	/**
	 * 删除一条记录
	 */
	@Override
	public boolean deleteMingPian(int BianHao) {
		// TODO Auto-generated method stub
		int line = 0;
		StringBuilder strSql = new StringBuilder();
		strSql.append("delete from mingpianbiao where BianHao=?");
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
	 * 更新一条记录
	 */
	@Override
	public boolean updateMingPian(MingPianModel mp) {
		// TODO Auto-generated method stub
		int line = 0;
		StringBuilder strSql = new StringBuilder();
		strSql.append("update mingpianbiao set XingMing=?,ZhiWu=?,LianXiFangShi=?,YouXiang=?,GongZuoDanWei=? ");
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
	 * 获取所有记录
	 */
	@Override
	public List<MingPianModel> getAllMingPian() {
		// TODO Auto-generated method stub
		StringBuilder strSql = new StringBuilder();
		List<MingPianModel> list = new ArrayList<MingPianModel>();
		strSql.append("select * from mingpianbiao ");
		// 静态方法即可
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
	 * 通过主键获取一条记录
	 */
	@Override
	public MingPianModel getMingPianById(int BianHao) {
		// TODO Auto-generated method stub
		MingPianModel mpModel = null;
		StringBuilder strSql = new StringBuilder();
		strSql.append("select * from mingpianbiao where BianHao=?");
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
	 * 判断记录是否存在
	 */
	@Override
	public boolean Exists(int BianHao) {
		// TODO Auto-generated method stub
		int flag = 0;
		StringBuilder strSql = new StringBuilder();
		strSql.append("select count(1) from mingpianbiao ");
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
	 * 模糊查询
	 */
	@Override
	public List<MingPianModel> getMingPianByMoHu(String name) {
		// TODO Auto-generated method stub
		StringBuilder strSql = new StringBuilder();
		List<MingPianModel> list = new ArrayList<MingPianModel>();
		strSql.append("select * from mingpianbiao where XingMing like ?");
		try {
			pst = conn.prepareStatement(strSql.toString());
			pst.setString(1, "%" + name + "%");
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
	 * 分页获取数据
	 */
	public List<MingPianModel> getMingPianByPage(int index, int pageSize) {
		StringBuilder strSql = new StringBuilder();
		List<MingPianModel> list = new ArrayList<MingPianModel>();
		strSql.append("select * from mingpianbiao limit ?,?");
		try {
			pst = conn.prepareStatement(strSql.toString());
			pst.setInt(1, index);
			pst.setInt(2, pageSize);
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
	 * 批量删除
	 */
	public boolean deleteMingPianList(String idList) {
		int line = 0;
		StringBuilder strSql = new StringBuilder();
		strSql.append("delete from mingpianbiao where BianHao in (" + idList + ")");
		try {
			pst = conn.prepareStatement(strSql.toString());
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
	 * 获得记录总数
	 */
	public int getRecord() {
		int count = 0;
		StringBuilder strSql = new StringBuilder();
		strSql.append("select count(*) from mingpianbiao");
		try {
			pst = conn.prepareStatement(strSql.toString());
			rs = pst.executeQuery();
			if (rs.next())
				count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.DBUtil.closeAll(rs, pst);
		}
		return count;
	}

	/**
	 * 批量获取数据
	 */
	public List<MingPianModel> getMingPianPiLiang(String idList) {
		StringBuilder strSql = new StringBuilder();
		List<MingPianModel> list = new ArrayList<MingPianModel>();
		strSql.append("select * from mingpianbiao where BianHao in (" + idList + ")");
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
	 * 根据外键编号获取名片信息
	 */
	public MingPianModel getMingPianByWJ(int ZHBianHao) {
		MingPianModel mpModel = null;
		StringBuilder strSql = new StringBuilder();
		strSql.append("select * from mingpianbiao where ZHBianHao=?");
		try {
			pst = conn.prepareStatement(strSql.toString());
			pst.setInt(1, ZHBianHao);
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
}

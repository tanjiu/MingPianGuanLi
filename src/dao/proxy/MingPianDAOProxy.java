package dao.proxy;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.MingPianDAO;
import dao.impl.MingPianImpl;
import vo.MingPianModel;

public class MingPianDAOProxy implements MingPianDAO {
	private Connection conn=null;
	private MingPianDAO dao=null;
	
	public MingPianDAOProxy() {
		try {
			this.conn=DBConnection.DBUtil.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.dao=new MingPianImpl(this.conn);
	}
	
	/**
	 * 添加一条记录
	 */
	public boolean addMingPian(MingPianModel mp) {
		boolean flag=false;
		try {
			flag=this.dao.addMingPian(mp);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return flag;
	}
	
	/**
	 * 添加一条记录，包含外键信息
	 */
	public boolean addMingPianAll(MingPianModel mp) {
		boolean flag=false;
		try {
			flag=this.dao.addMingPianAll(mp);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return flag;
	}
	/**
	 * 删除一条记录
	 */
	public boolean deleteMingPian(int BianHao) {
		boolean flag=false;
		try {
			flag=this.dao.deleteMingPian(BianHao);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return flag;
	}
	
	/**
	 * 更新一条记录
	 */
	public boolean updateMingPian(MingPianModel mp) {
		boolean flag=false;
		try {
			flag=this.dao.updateMingPian(mp);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return flag;
	}
	
	/**
	 * 获取全部记录
	 */
	public List<MingPianModel> getAllMingPian(){
		List<MingPianModel> list=new ArrayList<MingPianModel>();
		try {
			list=this.dao.getAllMingPian();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return list;
	}
	
	/**
	 * 模糊查询
	 */
	public List<MingPianModel> getMingPianByMoHu(String name){
		List<MingPianModel> list=new ArrayList<MingPianModel>();
		try {
			list=this.dao.getMingPianByMoHu(name);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return list;
	}
	
	/**
	 * 通过主键获取一条数据
	 */
	public MingPianModel getMingPianById(int BianHao) {
		MingPianModel mp=new MingPianModel();
		try {
			mp=this.dao.getMingPianById(BianHao);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return mp;
	}
	
	/**
	 * 判断记录是否存在
	 */
	public boolean Exists(int BianHao) {
		boolean flag=false;
		try {
			flag=this.dao.Exists(BianHao);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return flag;
	}
	
	/**
	 * 分页获取数据
	 */
	public List<MingPianModel> getMingPianByPage(int index,int pageSize){
		List<MingPianModel> list=new ArrayList<MingPianModel>();
		try {
			list=this.dao.getMingPianByPage(index, pageSize);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return list;
	}
	
	/**
	 * 批量删除数据
	 */
	public boolean deleteMingPianList(String idList) {
		boolean flag=false;
		try {
			flag=this.dao.deleteMingPianList(idList);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return flag;
	}
	/**
	 * 获得记录总数
	 */
	public int getRecord() {
		int count=0;
		try {
			count=this.dao.getRecord();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return count;
	}
	
	/**
	 * 批量获取数据
	 */
	public List<MingPianModel> getMingPianPiLiang(String idList){
		List<MingPianModel> list=new ArrayList<MingPianModel>();
		try {
			list=this.dao.getMingPianPiLiang(idList);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return list;
	}
	
	
	/**
	 * 根据外键编号获取名片信息
	 */
	public MingPianModel getMingPianByWJ(int ZHBianHao) {
		MingPianModel mp=new MingPianModel();
		try {
			mp=this.dao.getMingPianByWJ(ZHBianHao);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.DBUtil.closeConn(conn);
		}
		return mp;
	}
}

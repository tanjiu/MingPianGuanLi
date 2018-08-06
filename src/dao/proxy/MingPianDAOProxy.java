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
	 * ���һ����¼
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
	 * ���һ����¼�����������Ϣ
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
	 * ɾ��һ����¼
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
	 * ����һ����¼
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
	 * ��ȡȫ����¼
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
	 * ģ����ѯ
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
	 * ͨ��������ȡһ������
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
	 * �жϼ�¼�Ƿ����
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
	 * ��ҳ��ȡ����
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
	 * ����ɾ������
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
	 * ��ü�¼����
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
	 * ������ȡ����
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
	 * ���������Ż�ȡ��Ƭ��Ϣ
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

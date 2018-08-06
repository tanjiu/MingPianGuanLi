package service;

import java.util.List;

import vo.MingPianModel;

public class MingPianBLL {
	public boolean addMingPian(MingPianModel mp) {
		return factory.DAOFactory.getMingPianDAOInstance().addMingPian(mp);
	}
	public boolean addMingPianAll(MingPianModel mp) {
		return factory.DAOFactory.getMingPianDAOInstance().addMingPianAll(mp);
	}
	public boolean deleteMingPian(int BianHao) {
		return factory.DAOFactory.getMingPianDAOInstance().deleteMingPian(BianHao);
	}
	public boolean updateMingPian(MingPianModel mp) {
		return factory.DAOFactory.getMingPianDAOInstance().updateMingPian(mp);
	}
	public boolean Exists(int BianHao) {
		return factory.DAOFactory.getMingPianDAOInstance().Exists(BianHao);
	}
	public MingPianModel getMingPianById(int BianHao) {
		return factory.DAOFactory.getMingPianDAOInstance().getMingPianById(BianHao);
	}
	public List<MingPianModel> getAllMingPian(){
		return factory.DAOFactory.getMingPianDAOInstance().getAllMingPian();
	}
	public List<MingPianModel> getMingPianByMoHu(String name){
		return factory.DAOFactory.getMingPianDAOInstance().getMingPianByMoHu(name);
	}
	public List<MingPianModel> getMingPianByPage(int index,int pageSize){
		return factory.DAOFactory.getMingPianDAOInstance().getMingPianByPage(index, pageSize);
	}
	public int getRecord() {
		return factory.DAOFactory.getMingPianDAOInstance().getRecord();
	}
	public boolean deleteMingPianList(String idList) {
		return factory.DAOFactory.getMingPianDAOInstance().deleteMingPianList(idList);
	}
	public List<MingPianModel> getMingPianPiLiang(String idList){
		return factory.DAOFactory.getMingPianDAOInstance().getMingPianPiLiang(idList);
	}
	public MingPianModel getMingPianByWJ(int ZHBianHao) {
		return factory.DAOFactory.getMingPianDAOInstance().getMingPianByWJ(ZHBianHao);
	}
}

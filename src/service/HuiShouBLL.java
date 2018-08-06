package service;

import java.util.List;

import vo.MingPianModel;

public class HuiShouBLL {
	public boolean addMingPian(MingPianModel mp) {
		return factory.HuiShouDAOFactory.getMingPianDAOInstance().addMingPian(mp);
	}
	public boolean deleteMingPian(int BianHao) {
		return factory.HuiShouDAOFactory.getMingPianDAOInstance().deleteMingPian(BianHao);
	}
	public boolean updateMingPian(MingPianModel mp) {
		return factory.HuiShouDAOFactory.getMingPianDAOInstance().updateMingPian(mp);
	}
	public boolean Exists(int BianHao) {
		return factory.HuiShouDAOFactory.getMingPianDAOInstance().Exists(BianHao);
	}
	public MingPianModel getMingPianById(int BianHao) {
		return factory.HuiShouDAOFactory.getMingPianDAOInstance().getMingPianById(BianHao);
	}
	public List<MingPianModel> getAllMingPian(){
		return factory.HuiShouDAOFactory.getMingPianDAOInstance().getAllMingPian();
	}
	public List<MingPianModel> getMingPianByMoHu(String name){
		return factory.HuiShouDAOFactory.getMingPianDAOInstance().getMingPianByMoHu(name);
	}
	public List<MingPianModel> getMingPianByPage(int index,int pageSize){
		return factory.HuiShouDAOFactory.getMingPianDAOInstance().getMingPianByPage(index, pageSize);
	}
	public int getRecord() {
		return factory.HuiShouDAOFactory.getMingPianDAOInstance().getRecord();
	}
	public boolean deleteMingPianList(String idList) {
		return factory.HuiShouDAOFactory.getMingPianDAOInstance().deleteMingPianList(idList);
	}
	public List<MingPianModel> getMingPianPiLiang(String idList){
		return factory.HuiShouDAOFactory.getMingPianDAOInstance().getMingPianPiLiang(idList);
	}
	public MingPianModel getMingPianByWJ(int ZHBianHao) {
		return factory.HuiShouDAOFactory.getMingPianDAOInstance().getMingPianByWJ(ZHBianHao);
	}
}

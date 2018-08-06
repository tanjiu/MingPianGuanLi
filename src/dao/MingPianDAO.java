package dao;

import java.util.List;
import vo.*;
public interface MingPianDAO {
	public boolean addMingPian(MingPianModel mp);
	public boolean addMingPianAll(MingPianModel mp);
	public boolean deleteMingPian(int BianHao);
	public boolean deleteMingPianList(String idList);
	public boolean updateMingPian(MingPianModel mp);
	public List<MingPianModel> getAllMingPian();
	public MingPianModel getMingPianById(int BianHao);
	public boolean Exists(int BianHao);
	public List<MingPianModel> getMingPianByMoHu(String name);
	public List<MingPianModel> getMingPianByPage(int index,int pageSize);
	public List<MingPianModel> getMingPianPiLiang(String idList);
	public int getRecord();	
	public MingPianModel getMingPianByWJ(int ZHBianHao);
}
package dao;



public interface YongHuLoginDAO {
	//登陆用
	public boolean Exists(String User,String Pwd);
	//注册判断用
	public boolean ExistsZH(String ZhangHao);
	//注册
	public boolean AddZhangHao(String User,String Pwd);		
	//根据登陆表中的账号获取登陆信息的编号
	public int getBianHao(String ZhangHao);
	//更新密码
	public boolean updateMiMa(String User,String Pwd);
}

package service;



public class LoginBLL {

	public boolean Exists(String User,String Pwd) {
		return factory.LoginDAOFactory.getLoginDAOInstance().Exists(User,Pwd);
	}
	public boolean AddZhangHao(String User,String Pwd) {
		return factory.LoginDAOFactory.getLoginDAOInstance().AddZhangHao(User, Pwd);
	}
	public boolean ExistsZH(String ZhangHao) {
		return factory.LoginDAOFactory.getLoginDAOInstance().ExistsZH(ZhangHao);
	}	
	public int getBianHao(String ZhangHao) {
		return factory.LoginDAOFactory.getLoginDAOInstance().getBianHao(ZhangHao);
	}	
	public boolean updateMiMa(String User,String Pwd) {
		return factory.LoginDAOFactory.getLoginDAOInstance().updateMiMa(User, Pwd);
	}
}

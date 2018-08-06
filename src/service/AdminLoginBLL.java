package service;

public class AdminLoginBLL {
	public boolean Exists(String User,String Pwd) {
		return factory.AdminLoginDAOFactory.getAdminLoginDAOInstance().Exists(User, Pwd);
	}
}

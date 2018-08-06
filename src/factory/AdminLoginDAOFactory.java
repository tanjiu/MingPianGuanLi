package factory;

import dao.AdminLoginDAO;
import dao.proxy.AdminLoginDAOProxy;

public class AdminLoginDAOFactory {
	public static AdminLoginDAO getAdminLoginDAOInstance() {
		return new AdminLoginDAOProxy();
	}
}

package factory;

import dao.YongHuLoginDAO;
import dao.proxy.LoginDAOProxy;

public class LoginDAOFactory {

	public static YongHuLoginDAO getLoginDAOInstance() {
		return new LoginDAOProxy();
	}
}

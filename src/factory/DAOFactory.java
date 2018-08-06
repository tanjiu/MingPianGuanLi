package factory;

import dao.MingPianDAO;
import dao.proxy.MingPianDAOProxy;

public class DAOFactory {
	public static MingPianDAO getMingPianDAOInstance() {
		return new MingPianDAOProxy();
	}
}

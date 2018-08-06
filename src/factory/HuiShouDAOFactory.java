package factory;

import dao.MingPianDAO;
import dao.proxy.HuiSHouDAOProxy;

public class HuiShouDAOFactory {
	public static MingPianDAO getMingPianDAOInstance(){
		return new HuiSHouDAOProxy();
	}
}

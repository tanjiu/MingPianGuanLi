package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import service.HuiShouBLL;
import service.MingPianBLL;
import vo.MingPianModel;

/**
 * Servlet implementation class HuiShouHuanYuan
 */
@WebServlet("/HuiShouHuanYuan")
public class HuiShouHuanYuan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HuiShouHuanYuan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service.HuiShouBLL mainBLL = new HuiShouBLL();
		service.MingPianBLL mpBLL = new MingPianBLL();
		String action = ((request.getParameter("action") != null) ? request.getParameter("action") : "123").toString();
		String shanchu = ((request.getParameter("shanchu") != null) ? request.getParameter("shanchu") : "123")
				.toString();
		if (action.equals("deletes") && shanchu.equals("123")) {
			// 删除单条数据
			int BianHao = Integer.parseInt(request.getParameter("id"));
			// 数据还原
			MingPianModel model = mainBLL.getMingPianById(BianHao);
			mpBLL.addMingPian(model);

			boolean flag = mainBLL.deleteMingPian(BianHao);
			String message = "";
			if (flag)
				message = "ok";
			else
				message = "fail";
			List<String> list = new ArrayList<String>();
			list.add(message);
			JSONArray jsonString = JSONArray.fromObject(list);
			message = jsonString.toString();
			response.getWriter().println(message);
		} else if (shanchu.equals("shanchu") && action.equals("123")) {
			String idList = request.getParameter("ids").toString();
			// 批量还原
			List<MingPianModel> lists = mainBLL.getMingPianPiLiang(idList);
			for (int i = 0; i < lists.size(); i++) {
				mpBLL.addMingPian(lists.get(i));
			}

			boolean flag = mainBLL.deleteMingPianList(idList);
			String message = "";
			if (flag)
				message = "ok";
			else
				message = "fail";
			List<String> list = new ArrayList<String>();
			list.add(message);
			JSONArray jsonString = JSONArray.fromObject(list);
			message = jsonString.toString();
			response.getWriter().println(message);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

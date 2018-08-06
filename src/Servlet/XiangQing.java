package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MingPianBLL;
import vo.MingPianModel;

/**
 * Servlet implementation class XiangQing
 */
@WebServlet("/XiangQing")
public class XiangQing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XiangQing() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		service.MingPianBLL mainBLL = new MingPianBLL();
		int BianHao = Integer.parseInt((request.getParameter("id") != null) ? request.getParameter("id") : "1");
		vo.MingPianModel model = new MingPianModel();
		model = mainBLL.getMingPianById(BianHao);
		// List<vo.MingPianModel> list1=new ArrayList<vo.MingPianModel>();
		// list1.add(model);
		request.setAttribute("model", model);
		// JSONArray jsonString = JSONArray.fromObject(list1);

		// 根据参数进行不同跳转
		String tiao = request.getParameter("tiao");
		if (!"2".equals(tiao))
			request.getRequestDispatcher("Users/Show.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

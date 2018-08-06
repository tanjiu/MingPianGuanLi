package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.HuiShouBLL;
import vo.MingPianModel;

/**
 * Servlet implementation class HuiShouXiangQing
 */
@WebServlet("/HuiShouXiangQing")
public class HuiShouXiangQing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HuiShouXiangQing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service.HuiShouBLL mainBLL=new HuiShouBLL();
		int BianHao=Integer.parseInt((request.getParameter("id")!=null)?request.getParameter("id"):"1");
		vo.MingPianModel model=new MingPianModel();
		model=mainBLL.getMingPianById(BianHao);
		//List<vo.MingPianModel> list1=new ArrayList<vo.MingPianModel>();
		//list1.add(model);
		request.setAttribute("model",model);
		//JSONArray jsonString = JSONArray.fromObject(list1);
		request.getRequestDispatcher("Users/Show.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

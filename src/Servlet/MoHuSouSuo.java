package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.MingPianBLL;
import vo.MingPianModel;

/**
 * Servlet implementation class MoHuSouSuo
 */
@WebServlet("/MoHuSouSuo")
public class MoHuSouSuo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoHuSouSuo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;");
		response.setCharacterEncoding("utf-8");
		//int page=Integer.parseInt((request.getParameter("currPage")!=null)?request.getParameter("currPage"):"1");
		//int pageSize=Integer.parseInt((request.getParameter("pageSize")!=null)?request.getParameter("pageSize"):"5");
		String name=request.getParameter("txt").toString();
		service.MingPianBLL mainBLL=new MingPianBLL();
		List<MingPianModel> list=new ArrayList<MingPianModel>();
		list=mainBLL.getMingPianByMoHu(name);
		request.setAttribute("list", list);
		//×ªÏò·¢ËÍ
		request.getRequestDispatcher("Users/ChaXunJieGuo.jsp").forward(request, response);
//		int count=list.size();		
//		int totalPage=0;
//		if(count%pageSize==0)
//			totalPage=count/pageSize;
//		else
//			totalPage=count/pageSize+1;
//		List<Object> list1=new ArrayList<Object>();
//		list1.add(list);
//		list1.add(totalPage);
//		JSONArray jsonString = JSONArray.fromObject(list1);
//		String json=jsonString.toString();
//		response.getWriter().println(json);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

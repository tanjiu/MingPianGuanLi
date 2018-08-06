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
 * Servlet implementation class CSHModel
 */
@WebServlet("/CSHModel")
public class CSHModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSHModel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service.MingPianBLL mainBLL=new MingPianBLL();
		int BianHao=Integer.parseInt((request.getParameter("id")!=null)?request.getParameter("id"):"1");
		vo.MingPianModel model=new MingPianModel();
		if(BianHao!=0) {			
			model=mainBLL.getMingPianById(BianHao);			
		}		
		request.setAttribute("model",model);
		request.getRequestDispatcher("Users/Edit.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginBLL;
import service.MingPianBLL;
import vo.MingPianModel;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String xm=request.getParameter("xm").toString();
		String zw=request.getParameter("zw").toString();
		String lxfs=request.getParameter("lxfs").toString();
		String yx=request.getParameter("yx").toString();
		String gzdw=request.getParameter("gzdw").toString();
		service.MingPianBLL mainBLL=new MingPianBLL();
		MingPianModel model=new MingPianModel(xm,zw,lxfs,yx,gzdw);
		
		//根据是后台管理添加还是用户第一次编辑进行判断
		String action=request.getParameter("action");
		boolean flag=false;
		if("first".equals(action)) {			
			service.LoginBLL logBLL=new LoginBLL();
			HttpSession session=request.getSession();
			String zhanghao=session.getAttribute("role").toString();
			//获取登陆信息数据编号
			int logBianHao=logBLL.getBianHao(zhanghao);
			//将编号及信息添加到名片表中
			model.setZHBianHao(logBianHao);
			flag=mainBLL.addMingPianAll(model);			
		}else {
			flag=mainBLL.addMingPian(model);			
		}
		if(flag) {
			response.getWriter().println("ok");
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

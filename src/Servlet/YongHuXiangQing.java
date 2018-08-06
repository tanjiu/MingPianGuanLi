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
 * Servlet implementation class YongHuXiangQing
 */
@WebServlet("/YongHuXiangQing")
public class YongHuXiangQing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YongHuXiangQing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String zhanghao=session.getAttribute("role").toString();
		service.LoginBLL mainBLL=new LoginBLL();
		//获取登陆表的编号
		int bianhao=mainBLL.getBianHao(zhanghao);
		//通过登陆信息的编号获取名片表的相应信息
		service.MingPianBLL mpBLL=new MingPianBLL();
		MingPianModel model=mpBLL.getMingPianByWJ(bianhao);
		request.setAttribute("yonghumodel", model);
		request.getRequestDispatcher("Users/YongHuShow.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

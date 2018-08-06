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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("bh"));
		service.MingPianBLL mainBLL=new MingPianBLL();
		MingPianModel model=new MingPianModel();
		model=mainBLL.getMingPianById(id);
		String xm=request.getParameter("xm").toString();
		String zw=request.getParameter("zw").toString();
		String lxfs=request.getParameter("lxfs").toString();
		String yx=request.getParameter("yx").toString();
		String gzdw=request.getParameter("gzdw").toString();
		model.setXingMing(xm);
		model.setZhiWu(zw);
		model.setLianXiFangShi(lxfs);
		model.setYouXiang(yx);
		model.setGongZuoDanWei(gzdw);
		boolean flag=mainBLL.updateMingPian(model);
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

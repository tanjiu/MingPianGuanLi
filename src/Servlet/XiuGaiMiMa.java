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
import service.LoginBLL;

/**
 * Servlet implementation class XiuGaiMiMa
 */
@WebServlet("/XiuGaiMiMa")
public class XiuGaiMiMa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XiuGaiMiMa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String jiumima=request.getParameter("form-username").toString();
		String xinmima=request.getParameter("form-password").toString();
		String user=request.getSession().getAttribute("role").toString();
		service.LoginBLL mainBLL=new LoginBLL();
		boolean flag=false;
		String message="500";
		//»Áπ˚’À∫≈√‹¬Îœ‡∆•≈‰
		String jiumd5=DBConnection.MD5JM.md5Password(jiumima);
		boolean b=mainBLL.Exists(user, jiumd5);
		if(b) {
			String md5mima=DBConnection.MD5JM.md5Password(xinmima);
			flag=mainBLL.updateMiMa(user, md5mima);
			if(flag)
				message="200";
		}else
			message="404";
		List<String> list=new ArrayList<String>();
		list.add(message);
		JSONArray jsonString=JSONArray.fromObject(list);
		String json=jsonString.toString();
		response.getWriter().println(json);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import service.AdminLoginBLL;

/**
 * Servlet implementation class checkCode
 */
@WebServlet("/checkCode")
public class checkCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public checkCode() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setHeader("Content-type", "text/html;charset=UTF-8");
		// 这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String code = request.getParameter("code");
		// 验证验证码
		String sessionCode = request.getSession().getAttribute("code").toString();
		String message = "500";
		if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
			if (!code.equalsIgnoreCase(sessionCode))
				message = "500";
			else {
				// 获得页面账号密码
				String User = request.getParameter("form-username").toString();
				String Pwd = request.getParameter("form-password").toString();

				service.AdminLoginBLL mainBLL = new AdminLoginBLL();
				boolean flag = mainBLL.Exists(User, Pwd);
				// 账号密码不存在
				if (!flag)
					message = "404";
				else {
					// 检验成功，跳转到后台
					// response.sendRedirect("/test2/Users/ShouYe1.jsp");
					session.removeAttribute("role");
					session.setAttribute("role", User);
					message = "200";
					// request.getRequestDispatcher("Users/ShouYe1.jsp").forward(request,response);
					// 所有的数据都是返回给ajax的，无法跳转，只能返回一个页面
				}

			}

		} else {
			message = "500";
		}
		List<String> list1 = new ArrayList<String>();
		list1.add(message);
		JSONArray jsonString = JSONArray.fromObject(list1);
		String json = jsonString.toString();
		response.getWriter().println(json);
	}

}

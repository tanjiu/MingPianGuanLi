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
		// ��仰����˼���Ǹ���servlet��UTF-8ת�룬��������Ĭ�ϵ�ISO8859
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String code = request.getParameter("code");
		// ��֤��֤��
		String sessionCode = request.getSession().getAttribute("code").toString();
		String message = "500";
		if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
			if (!code.equalsIgnoreCase(sessionCode))
				message = "500";
			else {
				// ���ҳ���˺�����
				String User = request.getParameter("form-username").toString();
				String Pwd = request.getParameter("form-password").toString();

				service.AdminLoginBLL mainBLL = new AdminLoginBLL();
				boolean flag = mainBLL.Exists(User, Pwd);
				// �˺����벻����
				if (!flag)
					message = "404";
				else {
					// ����ɹ�����ת����̨
					// response.sendRedirect("/test2/Users/ShouYe1.jsp");
					session.removeAttribute("role");
					session.setAttribute("role", User);
					message = "200";
					// request.getRequestDispatcher("Users/ShouYe1.jsp").forward(request,response);
					// ���е����ݶ��Ƿ��ظ�ajax�ģ��޷���ת��ֻ�ܷ���һ��ҳ��
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

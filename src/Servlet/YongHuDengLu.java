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
import service.LoginBLL;

/**
 * Servlet implementation class YongHuDengLu
 */
@WebServlet("/YongHuDengLu")
public class YongHuDengLu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YongHuDengLu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		// 这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
		response.setCharacterEncoding("UTF-8");	
		HttpSession session=request.getSession();
		String code = request.getParameter("code");
		// 验证验证码
		String sessionCode = request.getSession().getAttribute("code").toString();
		String message = "500";
		if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
			if (!code.equalsIgnoreCase(sessionCode))
				message = "500";
			else {
				String zhanghao=request.getParameter("form-username").toString();
				String mima=request.getParameter("form-password").toString();
				//执行md5加密
				mima=DBConnection.MD5JM.md5Password(mima);
				service.LoginBLL mainBLL=new LoginBLL();		
				//判断账号密码是否已经存在
				boolean b=mainBLL.Exists(zhanghao,mima);
				if(b) {	
					session.removeAttribute("role");
					session.setAttribute("role", zhanghao);
					message="200";
				}else {					
					message="404";					
				}		
			}
		} else {
			message = "500";
		}		
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

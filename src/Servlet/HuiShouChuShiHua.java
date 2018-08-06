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
import service.HuiShouBLL;

import vo.MingPianModel;

/**
 * Servlet implementation class HuiShouChuShiHua
 */
@WebServlet("/HuiShouChuShiHua")
public class HuiShouChuShiHua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HuiShouChuShiHua() {
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
		int page=Integer.parseInt((request.getParameter("currPage")!=null)?request.getParameter("currPage"):"1");
		int pageSize=Integer.parseInt((request.getParameter("pageSize")!=null)?request.getParameter("pageSize"):"5");
		service.HuiShouBLL mainBLL=new HuiShouBLL();
		List<MingPianModel> list=mainBLL.getMingPianByPage((page-1)*pageSize, pageSize);	
		int count=mainBLL.getRecord();
		int totalPage=0;
		if(count%pageSize==0)
			totalPage=count/pageSize;
		else
			totalPage=count/pageSize+1;
		List<Object> list1=new ArrayList<Object>();
		list1.add(list);
		list1.add(totalPage);
		JSONArray jsonString = JSONArray.fromObject(list1);
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

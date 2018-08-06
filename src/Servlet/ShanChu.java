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
import service.MingPianBLL;
import vo.MingPianModel;

/**
 * Servlet implementation class ShanChu
 */
@WebServlet("/ShanChu")
public class ShanChu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShanChu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service.MingPianBLL mainBLL=new MingPianBLL();
		service.HuiShouBLL  hsBLL=new HuiShouBLL();
		String action=((request.getParameter("action")!=null)?request.getParameter("action"):"123").toString();
		String shanchu=((request.getParameter("shanchu")!=null)?request.getParameter("shanchu"):"123").toString();
		if (action.equals("deletes") && shanchu.equals("123")) {
			//删除单条数据
			int BianHao=Integer.parseInt(request.getParameter("id"));
			//将数据放入回收站
			MingPianModel model=new MingPianModel();
			model=mainBLL.getMingPianById(BianHao);
			hsBLL.addMingPian(model);			
			
			boolean flag=mainBLL.deleteMingPian(BianHao);
			String message="";
			if(flag) 
				 message="ok";
			else
				message="fail";		
			List<String> list=new ArrayList<String>();
			list.add(message);
			JSONArray jsonString = JSONArray.fromObject(list);
			message=jsonString.toString();
			response.getWriter().println(message);
		}
		 else if (shanchu.equals("shanchu") && action.equals("123")) {
			 //批量删除数据
			 String idList=request.getParameter("ids").toString();
			 //将数据放入回收站
			 List<MingPianModel> lists=mainBLL.getMingPianPiLiang(idList);
			 for(int i=0;i<lists.size();i++)
				 hsBLL.addMingPian(lists.get(i));
			 
			 
			 boolean flag=mainBLL.deleteMingPianList(idList);
				String message="";
				if(flag) 
					 message="ok";
				else
					message="fail";		
				List<String> list=new ArrayList<String>();
				list.add(message);
				JSONArray jsonString = JSONArray.fromObject(list);
				message=jsonString.toString();
				response.getWriter().println(message);
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

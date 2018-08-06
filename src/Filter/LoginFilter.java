package Filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
	private String sessionKey;
	private String redirectUrl;
	private String unCheckedUrls;
	public void init(FilterConfig config) throws ServletException{
		ServletContext servletContext=config.getServletContext();
		
		//获取xml文件中配置参数
		sessionKey=servletContext.getInitParameter("userSessionKey");
		System.out.println("sessionKey===="+sessionKey);
		redirectUrl=servletContext.getInitParameter("redirectPage");
		System.out.println("redirectUrl==="+redirectUrl);
		unCheckedUrls=servletContext.getInitParameter("unCheckedUrls");
		System.out.println("unCheckedUrls==="+unCheckedUrls);	
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//获得在下面代码中要用到的request,response,sesseion对象
		HttpServletRequest httpRequest=(HttpServletRequest)servletRequest;
		HttpServletResponse httpResponse=(HttpServletResponse)servletResponse;
		
		//1、获取请求URL
		String servletPath=httpRequest.getServletPath();  
		
		//2、检测1中获取的servletPath是否为不需要检测的URL中的，是的话放行
		List<String> urls=Arrays.asList(unCheckedUrls.split(","));
		if(urls.contains(servletPath)) {
			filterChain.doFilter(httpRequest, httpResponse);//继续请求；
		}
		
		
		//3、从session中获取SeeionKey对应值，若值不存在，则重定向到redircetUrl
		Object user=httpRequest.getSession().getAttribute("role");
		if(user==null) {
			httpResponse.sendRedirect(httpRequest.getContextPath()+redirectUrl);
			//注意重定向的基路径，在web.xml中要拼接好路径
			//httpResponse.sendRedirect("http://www.baidu.com");
			return;
		}
		filterChain.doFilter(httpRequest, httpResponse);

	}
	
	
	public void destory() {}
	
	

}

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
		
		//��ȡxml�ļ������ò���
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
		//��������������Ҫ�õ���request,response,sesseion����
		HttpServletRequest httpRequest=(HttpServletRequest)servletRequest;
		HttpServletResponse httpResponse=(HttpServletResponse)servletResponse;
		
		//1����ȡ����URL
		String servletPath=httpRequest.getServletPath();  
		
		//2�����1�л�ȡ��servletPath�Ƿ�Ϊ����Ҫ����URL�еģ��ǵĻ�����
		List<String> urls=Arrays.asList(unCheckedUrls.split(","));
		if(urls.contains(servletPath)) {
			filterChain.doFilter(httpRequest, httpResponse);//��������
		}
		
		
		//3����session�л�ȡSeeionKey��Ӧֵ����ֵ�����ڣ����ض���redircetUrl
		Object user=httpRequest.getSession().getAttribute("role");
		if(user==null) {
			httpResponse.sendRedirect(httpRequest.getContextPath()+redirectUrl);
			//ע���ض���Ļ�·������web.xml��Ҫƴ�Ӻ�·��
			//httpResponse.sendRedirect("http://www.baidu.com");
			return;
		}
		filterChain.doFilter(httpRequest, httpResponse);

	}
	
	
	public void destory() {}
	
	

}

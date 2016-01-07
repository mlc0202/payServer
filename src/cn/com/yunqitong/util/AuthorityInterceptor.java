package cn.com.yunqitong.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthorityInterceptor implements HandlerInterceptor{
	private Logger log = Logger.getLogger(AuthorityInterceptor.class);  
	 public AuthorityInterceptor() {  
	    }  
	 
	private String mappingURL;//利用正则映射到需要拦截的路径    
     public void setMappingURL(String mappingURL) {    
            this.mappingURL = mappingURL;    
    }   
//	preHandle：拦截器的前端，执行控制器之前所要处理的方法，通常用于权限控制、日志，其中，Object o表示下一个拦截器；
//	postHandle：控制器的方法已经执行完毕，转换成视图之前的处理；
//	afterCompletion：视图已处理完后执行的方法，通常用于释放资源；
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		System.out.println("afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("preHandle");
		String url=request.getRequestURL().toString();    
//        if(mappingURL==null || url.matches(mappingURL)){    
//            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);  
//            return false;   
//        }    
		return true;
	}

}

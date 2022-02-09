package com.insurance.handler;


import java.io.PrintWriter;

import java.util.List;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.insurance.service.auuserService;

public class MyInterceptor implements HandlerInterceptor{
	
	@Autowired
	private auuserService auuserservice;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

       

		
		// 得到请求的url
        String url = request.getRequestURI();
        System.out.println(url);
        //Cookie cookie = null;
        Cookie[] cookies = request.getCookies();
        // 获取与该域相关的 Cookie 的数组
        System.out.println(cookies);
        //System.out.println(cookies.length);
		
		  for (Cookie cookie:cookies){ 
			  //cookie = cookies[i];
			  System.out.println(cookie.getName()); 
			  System.out.println(cookie.getValue());
			  if(cookie.getName().equals("id")) { 
				  String Userid = cookie.getValue();
				  System.out.println(Userid);
				  System.out.println("hhh");
				List<String> Uurls = auuserservice.queryurl(Userid);
				System.out.println(Uurls); 
				for(String aurl:Uurls) { 
					if(url.equals(aurl)) { 
						return true; 
						} 
					} 
				} 
			  }
		 
            
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//Map<String,Object> map = new HashMap<String, Object>();
		// TODO Auto-generated method stub
//		if(preHandle(request, response, handler))
//		{
//			//map.put("","");
//			System.out.println("成功");
//		}else {
//			//map.put("msg","对不起，您没有该权限访问！");
//			System.out.println("失败");
//		}
//		
		
		
	}

}

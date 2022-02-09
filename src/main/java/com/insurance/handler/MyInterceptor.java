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

       

		
		// �õ������url
        String url = request.getRequestURI();
        System.out.println(url);
        //Cookie cookie = null;
        Cookie[] cookies = request.getCookies();
        // ��ȡ�������ص� Cookie ������
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
//			System.out.println("�ɹ�");
//		}else {
//			//map.put("msg","�Բ�����û�и�Ȩ�޷��ʣ�");
//			System.out.println("ʧ��");
//		}
//		
		
		
	}

}

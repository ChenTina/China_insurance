package com.insurance.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CrossFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CrossFilter() {

    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request; 
		httpServletRequest.getSession(); 
		HttpServletResponse httpResponse = (HttpServletResponse) response; 
		String origin = ((HttpServletRequest) request).getHeader("Origin");
//		if(origin != null){
//		   ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", origin);
//		}else{
//		   ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "*");
//		}
		httpResponse.setHeader("Access-Control-Allow-Origin", origin);
		httpResponse.setHeader("Access-Control-Allow-Methods", "*");
		httpResponse.setHeader("Access-Control-Max-Age", "86400");
		httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Connection, User-Agent, Cookie");
		httpResponse.setHeader("Access-Control-Allow-Credentials", "true"); 
		httpResponse.setHeader("Content-type", "application/json");
		httpResponse.setHeader("Cache-Control", "no-cache, must-revalidate");
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

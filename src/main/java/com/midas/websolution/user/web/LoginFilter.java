package com.midas.websolution.user.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.midas.websolution.user.vo.UserVO;



public class LoginFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LoginFilter.class);
	
    public LoginFilter() {

    }

	
	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		UserVO user = (UserVO) req.getSession().getAttribute("_USER_");
	
		if(user == null) {
			HttpServletResponse res = (HttpServletResponse) response;
			
			res.sendRedirect(req.getContextPath()+"/signin");
		}
		
		else {
			
			request.setAttribute("_USER_", user);
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

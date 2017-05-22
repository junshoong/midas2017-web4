package com.midas.websolution.user.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.DispatcherServlet;

import com.midas.websolution.user.vo.UserVO;



public class LoginFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LoginFilter.class);
	
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		UserVO user = (UserVO) req.getSession().getAttribute("_USER_");
	
		if(user == null) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("/sample/signin");
		}
		
		else {
			logger.info(user.getUserId());
			request.setAttribute("_USER_", user);
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

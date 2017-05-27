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
<<<<<<< HEAD
import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.web.servlet.DispatcherServlet;
=======
>>>>>>> d5685f11f223670a13b2f3878bc4c8919ce152e9

import com.midas.websolution.user.vo.UserVO;



public class LoginFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LoginFilter.class);
<<<<<<< HEAD
    public LoginFilter() {}
	public void destroy() {}
=======
	
    public LoginFilter() {

    }

	
	public void destroy() {
		
	}
>>>>>>> d5685f11f223670a13b2f3878bc4c8919ce152e9


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		UserVO user = (UserVO) req.getSession().getAttribute("_USER_");
	
		if(user == null) {
			HttpServletResponse res = (HttpServletResponse) response;
			
			res.sendRedirect(req.getContextPath()+"/signin");
		}
		
		else {
<<<<<<< HEAD
				if(user.getUser_permission()==20 && req.getRequestURI().equals(req.getContextPath() + "/menu/manage")) {
					
					HttpServletResponse res = (HttpServletResponse) response;
					res.sendRedirect(req.getContextPath()+"/signin");
					return ;
				}
				
				request.setAttribute("_USER_", user);
			}
=======
			
			request.setAttribute("_USER_", user);
		}
>>>>>>> d5685f11f223670a13b2f3878bc4c8919ce152e9
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

package com.midas.websolution.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.midas.websolution.user.service.UserService;
import com.midas.websolution.user.vo.UserVO;

@Controller
public class UserController {
	
	private UserService userService;
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signIn() {
		return "user/signIn";
	}
	
	
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public String signIn(UserVO user, HttpServletRequest request) {
		
		user = userService.loginUser(user);
		
		if(user != null) {
			System.out.println("쉬고싶다");
			HttpSession session = request.getSession();
			logger.info(user.getUser_id());
			session.setAttribute("_USER_", user);
			return "redirect:/";
		}
	
	
		return "user/signIn";
	}
	

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signUp() {
		return "user/signUp";
	}
	

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signUp(HttpServletRequest request) {
		
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		
		UserVO user = new UserVO();
		
		if(userService.isDuplicateUserId(userId))
			return "user/signUp";
		
		user.setUser_id(userId);
		user.setUser_password(userPassword);
		user.setUser_name(userName);
		
		if(userService.registNewUser(user))
			return "redirect:/signin";

		return "user/signUp";
		
	}
	

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/signin";
	}
	
	
	
	
}

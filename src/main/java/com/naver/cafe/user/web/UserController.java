package com.naver.cafe.user.web;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.cafe.common.Auth;
import com.naver.cafe.user.service.UserService;
import com.naver.cafe.user.vo.UserVO;

@Controller
public class UserController {
	
	private UserService userService;
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Auth("USR")
	@RequestMapping(value="/club/signin", method=RequestMethod.POST)
	public String signIn(HttpServletRequest request) {
		
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String ip = request.getRemoteAddr();
		
		UserVO user = new UserVO();
		user.setUserId(userId);
		user.setUserPassword(userPassword);
		user = userService.loginUser(user);
		if(user != null) {
			HttpSession session = request.getSession();
			logger.info(user.getUserId());
			session.setAttribute("_USER_", user);
		}
		
		return "redirect:/club/1";
	}
	
	@Auth("USR")
	@RequestMapping(value="/club/signup", method=RequestMethod.GET)
	public String signUp() {
		return "user/signUp";
	}
	
	@Auth("USR")
	@RequestMapping(value="/club/signup", method=RequestMethod.POST)
	public String signUp(HttpServletRequest request) {
		
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		
		UserVO user = new UserVO();
		
		user.setUserId(userId);
		user.setUserPassword(userPassword);
		user.setUserName(userName);
		
		if(userService.registNewUser(user)) {
			return "redirect:/club/1543";
		}
		
		else
			return "user/signUp";
		
	}
	
	@Auth("USR")
	@RequestMapping(value="/club/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/club/1";
	}
	
	
	@Auth("USR")
	@RequestMapping(value="/club/signup/passwordcheck", method=RequestMethod.POST)
	public HashMap<String, String> passwordCheck(HttpServletRequest request) {
	
		String userPassword = request.getParameter("userPassword");
		
		
		String passwordPolicy = "((?=.*[a-zA-Z]))";
		Pattern pattern = Pattern.compile(passwordPolicy);
		Matcher matcher = pattern.matcher(userPassword);
		
		HashMap<String, String> result = new HashMap<String, String>();
		
		if(matcher.matches()) {
			result.put("SUCCESS", "YES");
		}
		else {
			result.put("SUCCESS", "NO");
		}
		
		return result;
	}

	
	
}

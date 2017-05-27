package com.midas.websolution.menu.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.midas.websolution.menu.service.MenuService;
import com.midas.websolution.menu.vo.MenuRegistRequestVO;

@Controller
public class MenuManageController {
	
	private Logger logger = LoggerFactory.getLogger(MenuManageController.class);
	private MenuService menuService;

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@RequestMapping(value="/menu/regist", method=RequestMethod.GET)
	public ModelAndView regist() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/menu/regist");
		return view;
	}
	
	@RequestMapping(value="/menu/regist", method=RequestMethod.POST)
	public ModelAndView registMenu(MenuRegistRequestVO menuRegistRequestVO, HttpServletRequest request) {
		System.out.println(menuRegistRequestVO.toString());
		System.out.println(menuRegistRequestVO.getFoodVO().size());
		
		HttpSession session = request.getSession(); 
		String root_path = session.getServletContext().getRealPath("/"); 
		String attach_path = "resources/upload/";
		String file_path = root_path + attach_path;
		System.out.println(file_path);
		
		menuService.uploadFile(menuRegistRequestVO.getImage_file(), file_path);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/menu/regist");
		return view;
		
	}
}

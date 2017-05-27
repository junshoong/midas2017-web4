package com.midas.websolution.menu.web;

import java.util.ArrayList;
import java.util.List;

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
import com.midas.websolution.menu.vo.MenuVO;

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
		String root_path = session.getServletContext().getRealPath("resources/upload/"); 
		System.out.println(root_path);
		menuService.uploadFile(menuRegistRequestVO.getImage_file(), root_path);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/menu/regist");
		return view;
		
	}
	
	
	@RequestMapping(value="/menu/today", method=RequestMethod.GET)
	public ModelAndView today() {
		
		int menu_kind = 10;
		int i = 0;
		ArrayList[] menuList = new ArrayList[3];
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/index");
		
		List<MenuVO> todayMenu = menuService.getTodayMenu();
		
		
		
		while(!todayMenu.isEmpty()) {
			if(menu_kind!= todayMenu.get(i).getMenu_kind()) {
				menu_kind += 10;
			}
			
			else {
				menuList[(menu_kind/10) - 1].add(todayMenu.get(i).getFoodSetVO().getFoodVO().getFood_name());
			}
			
			todayMenu.remove(i);
		}
		
		view.addObject("todayBreakFast", menuList[0]);
		view.addObject("todayLunch", menuList[1]);
		view.addObject("todayDinner", menuList[2]);
		
		return view;
	}
	
	
}

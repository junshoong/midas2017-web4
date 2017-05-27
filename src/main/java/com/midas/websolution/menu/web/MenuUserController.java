package com.midas.websolution.menu.web;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.midas.websolution.menu.service.MenuService;
import com.midas.websolution.menu.vo.MenuResultVO;

@Controller
public class MenuUserController {
	
	private Logger logger = LoggerFactory.getLogger(MenuUserController.class);
	private MenuService menuService;

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@RequestMapping(value="/menu/search", method=RequestMethod.GET)
	public ModelAndView search(
			@RequestParam(value="q", required=false) String q) {
		ModelAndView view = new ModelAndView();
		List<MenuResultVO> menu_list = null;
		if (q != null) {
			if (q.matches("\\d{4}-\\d{2}-\\d{2}"))
				menu_list =  menuService.getMenuListByDate(q);
			else
				menu_list =  menuService.getMenuListByFoodName(q);
		}
		view.addObject("menu_list", menu_list);
		view.addObject("content", "menu/search.jsp");
		view.setViewName("/index");
		return view;
	}
	
}

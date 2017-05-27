package com.midas.websolution.menu.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.midas.websolution.menu.service.MenuService;
import com.midas.websolution.menu.vo.FoodSetVO;
import com.midas.websolution.menu.vo.FoodVO;
import com.midas.websolution.menu.vo.MenuMainRequestVO;
import com.midas.websolution.menu.vo.MenuRegistRequestVO;

@Controller
public class MenuManageController {
	
	private Logger logger = LoggerFactory.getLogger(MenuManageController.class);
	private MenuService menuService;

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@RequestMapping(value="/menu/manage", method=RequestMethod.GET)
	public ModelAndView manage() {
		ModelAndView view = new ModelAndView();
		view.addObject("menu_list", menuService.getMenuList());
		
		view.addObject("content", "menu/manage.jsp");
		view.setViewName("/index");
		return view;
	}
	
	@RequestMapping(value="/menu/regist", method=RequestMethod.GET)
	public ModelAndView regist() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/menu/regist");
		return view;
	}
	
	@RequestMapping(value="/menu/regist", method=RequestMethod.POST)
	public ModelAndView registMenu(MenuRegistRequestVO menuRegistRequestVO, HttpServletRequest request) {
		
//		HttpSession session = request.getSession(); 
//		String root_path = session.getServletContext().getRealPath("resources/upload/"); 
//		System.out.println(root_path);
//		menuService.uploadFile(menuRegistRequestVO.getImage_file(), root_path);
		
		int menu_no = menuService.insertOneMenu(menuRegistRequestVO.getMenuVO());
		
		List<FoodVO> foodVOs = menuRegistRequestVO.getFoodVO();
		for(int i=0; i<foodVOs.size(); i++) {
			int food_no = menuService.updateOneFood(foodVOs.get(i));
			if(food_no == 0) {
				String food_name = foodVOs.get(i).getFood_name();
				food_no = menuService.getFoodNoByFoodName(food_name);
			}
			
			FoodSetVO foodSetVO = new FoodSetVO();
			foodSetVO.setMenu_no(menu_no);
			foodSetVO.setFood_no(food_no);
			menuService.insertOneFoodSet(foodSetVO);
		}
		
		
		ModelAndView view = new ModelAndView();

		view.setViewName("redirect:/menu/regist");
		return view;
		
	}
	
	
	@RequestMapping(value="/menu/today", method=RequestMethod.GET)
	public ModelAndView today() {
		
		int menu_kind = 10;
		int i = 0;
		String menuList[] = new String[3];
		
		for(int j = 0; j < 3; j ++) menuList[j] = "";
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/index");
		
		List<MenuMainRequestVO> todayMenu = menuService.getTodayMenu();
		
		System.out.println(todayMenu.size());
		
		while(i < todayMenu.size()) {
			
			if(menu_kind!= todayMenu.get(i).getMenu_kind()) {
				menu_kind += 10;
			}
			
			else {
				if(todayMenu.get(i).getFood_name() != null) 
					menuList[(menu_kind/10) - 1] += (todayMenu.get(i).getFood_name()) + "</br>";
			}
			
			i++;
		}
		
		view.addObject("content", "menu/today.jsp");
		view.addObject("todayBreakFast", menuList[0]);
		view.addObject("todayLunch", menuList[1]);
		view.addObject("todayDinner", menuList[2]);
		
		return view;
	}
	
	
}

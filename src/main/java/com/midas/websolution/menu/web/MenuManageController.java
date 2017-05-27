package com.midas.websolution.menu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.midas.websolution.menu.service.MenuService;
import com.midas.websolution.menu.vo.FoodSetVO;
import com.midas.websolution.menu.vo.FoodVO;
import com.midas.websolution.menu.vo.MenuLikeRequestVO;
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
		
		String root_path = request.getSession().getServletContext().getRealPath("resources/upload/"); 
		menuService.uploadFile(menuRegistRequestVO.getImage_file(), root_path);
		System.out.println(root_path);
		
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

		view.setViewName("redirect:/menu/manage");
		return view;
		
	}
	
	
	@RequestMapping(value="/menu/today", method=RequestMethod.GET)
	public ModelAndView today() {
		
		int menuThreeNo[] = new int[3];
		int menu_kind = 10;
		int i = 0; int count = 1;
		String menuList[] = new String[3];
		
		for(int j = 0; j < 3; j ++) menuList[j] = "";
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/index");
		
		List<MenuMainRequestVO> todayMenu = menuService.getTodayMenu();
		
		System.out.println(todayMenu.size());
		
		for(int z = 0; z < todayMenu.size(); z++) {
			if(todayMenu.get(z).getMenu_kind() == menu_kind) {
				menu_kind += 10;
				menuThreeNo[(menu_kind / 10) - 1] = todayMenu.get(z).getMenu_kind();
			}
		}
		
		
		while(i < todayMenu.size()) {
			
			if(menu_kind!= todayMenu.get(i).getMenu_kind()) {
				menu_kind += 10;
			}
			
			else {
				menuList[(menu_kind/10) - 1] += (todayMenu.get(i).getFood_name()) + "</br>";
				i++;
			}
			
			
		}
		
		view.addObject("content", "menu/today.jsp");
		view.addObject("todayBreakFast", menuList[0]);
		view.addObject("todayLunch", menuList[1]);
		view.addObject("todayDinner", menuList[2]);
		
		view.addObject("first", menuThreeNo[0]);
		view.addObject("second", menuThreeNo[1]);
		view.addObject("third", menuThreeNo[2]);
		
		return view;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/menu/insertLike", method=RequestMethod.POST)
	public Map<String, String> insertLike(MenuLikeRequestVO menuLikeRequestVO) {
		
		Map<String, String> result = new HashMap<String, String>();
		
		if(menuService.insertLike(menuLikeRequestVO)) {
			result.put("SUCCESS", "YES");
		}
		
		else {
			result.put("NO", "FAIL");
		}
		
		return result;
	}
	
	
}

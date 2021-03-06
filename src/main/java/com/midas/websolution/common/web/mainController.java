package com.midas.websolution.common.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.midas.websolution.menu.service.MenuService;
import com.midas.websolution.menu.vo.MenuMainRequestVO;
import com.midas.websolution.menu.vo.MenuVO;

@Controller
public class mainController {
	
	private MenuService menuService;
	
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index() {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
		String menuText[][] = new String[3][5];
		int week = 2;
		int count = 0;
	
		ModelAndView view = new ModelAndView();
		List<MenuMainRequestVO> weekMenu = new ArrayList<MenuMainRequestVO>();
		view.setViewName("/index");
		view.addObject("content", "menu/weekmenu.jsp");
		
		for(int i = 10; i <= 30; i += 10) {
			 weekMenu = menuService.getOneWeekMenu(i);
			 
			
				 
				 	if(weekMenu.size() == 0) break;
					
					while(week <= 6) {
							cal.set(Calendar.DAY_OF_WEEK, week);
							if(!dateFmt.format(cal.getTime()).equals(weekMenu.get(count++).getMenu_date())) {
								week++;
								continue;
							}
							
							else {
								menuText[(i/10) - 1][week] += weekMenu.get(count++).getFood_name();
								menuText[(i/10) - 1][week] += "<br/>";
								//System.out.println(menuText[j][week]);
							}
						
					
					
					count = 0;
					week = 2;
				}
			 
		}
		
		
		System.out.println(menuText[0]);
		System.out.println(menuText[1]);
		System.out.println(menuText[2]);

		view.addObject("weekMenuBreakFast",  menuText[0]);
		view.addObject("weekMenuLunch",  menuText[1]);
		view.addObject("weekMenuDinner",  menuText[2]);

		
		return view;
	}
}

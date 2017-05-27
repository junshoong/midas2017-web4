package com.midas.websolution.common.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.midas.websolution.menu.service.MenuService;
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
	
		ModelAndView view = new ModelAndView();
		List<MenuVO> weekMenu = new ArrayList<MenuVO>();
		view.setViewName("/index");
		view.addObject("content", "menu/weekmenu.jsp");
		for(int i = 10; i <= 30; i += 10) {
			 weekMenu = menuService.getOneWeekMenu(i);
		}
		
	/*	for(int j = 0; j < 3; j ++) {
			for(int i = Calendar.MONDAY; i <= Calendar.FRIDAY; i++) {
				while(true) {
					cal.set(Calendar.DAY_OF_WEEK, i);
					if(!dateFmt.format(cal.getTime()).equals(weekMenu.get(i - 2).getMenu_date())) {
						break;
					}
					
					else {
						menuText[j][i] += weekMenu.get(i - 2).getFoodSetVO().getFoodVO().getFood_name();
						menuText[j][i] +="\n";
					}
				}
			}
		}

		

		view.addObject("weekMenuBreakFast",  menuText[0]);
		view.addObject("weekMenuLunch",  menuText[1]);
		view.addObject("weekMenuDinner",  menuText[2]);

		*/
		return view;
	}
}

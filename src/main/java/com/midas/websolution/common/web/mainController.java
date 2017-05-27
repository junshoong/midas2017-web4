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
import com.midas.websolution.menu.vo.MenuMainRequestVO;

@Controller
public class mainController {

	private MenuService menuService;

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat day = new SimpleDateFormat("dd");
		SimpleDateFormat month = new SimpleDateFormat("MM");
		String menuText[][] = new String[3][5];
		String dayArray[] = new String[5];
		int week = 2;
		int count = 0;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				menuText[i][j] = "";
			}
		}
		
		for(int i = 0; i < 5; i ++) {
			cal.set(Calendar.DAY_OF_WEEK, week);
			dayArray[i] = day.format(cal.getTime()) + "ÀÏ";
			week++;
		}
		
		week = 2;

		ModelAndView view = new ModelAndView();
		List<MenuMainRequestVO> weekMenu = new ArrayList<MenuMainRequestVO>();
		view.setViewName("/index");
		view.addObject("content", "menu/weekmenu.jsp");

		for (int i = 10; i <= 30; i += 10) {
			weekMenu = menuService.getOneWeekMenu(i);
			
			System.out.println(weekMenu.size());

			if (weekMenu.size() == 0)
				break;

			while (week <= 6 && count < weekMenu.size()) {
				cal.set(Calendar.DAY_OF_WEEK, week);
				
/*				System.out.println("first = " + dateFmt.format(cal.getTime()));
				System.out.println("second = " + weekMenu.get(count).getMenu_date());*/
				
				if (!dateFmt.format(cal.getTime()).equals(weekMenu.get(count).getMenu_date())) {
					week++;
				}

				else {
/*					System.out.println("test = " + weekMenu.get(count).getFood_name());*/
					menuText[(i / 10) - 1][week - 2] += weekMenu.get(count).getFood_name();
					menuText[(i / 10) - 1][week - 2] += "<br/>";
					count++;
				}

				
			}
			
			week = 2;
			count = 0;	
		}

/*		System.out.println(Arrays.toString(menuText[0]));
		System.out.println(Arrays.toString(menuText[1]));
		System.out.println(Arrays.toString(menuText[2]));*/

		view.addObject("weekMenuBreakFast", menuText[0]);
		view.addObject("weekMenuLunch", menuText[1]);
		view.addObject("weekMenuDinner", menuText[2]);
		view.addObject("dayArray", dayArray);
		
		cal.set(Calendar.DAY_OF_WEEK, 2);
		view.addObject("month",month.format(cal.getTime()) + "¿ù");

		return view;
	}
}

package com.midas.websolution.menu.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.midas.websolution.menu.service.MenuService;
import com.midas.websolution.user.vo.UserVO;

@Controller
public class MenuStatisticsController {
	
	private Logger logger = LoggerFactory.getLogger(MenuStatisticsController.class);
	private MenuService menuService;

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@RequestMapping(value="/menu/statistics")
	public ModelAndView hello(HttpServletRequest request) {
		Date date= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		logger.info(""+month+date.toString());
		
		HttpSession session = request.getSession();
		
		UserVO userVO = (UserVO) session.getAttribute("_USER_");
		
//		List<MenuVO> list = menuService.getMenuListByIdAndMonth(userVO.getUser_no(), month);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/index");
		view.addObject("meals", menuService.getTimesOfMeal(userVO.getUser_no()));
		view.addObject("content", "menu/statistics.jsp");
		


		return view;
	}

}

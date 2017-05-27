package com.midas.websolution.menu.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.midas.websolution.menu.service.MenuService;

@Controller
public class MenuStatisticsController {
	
	private Logger logger = LoggerFactory.getLogger(MenuStatisticsController.class);
	private MenuService menuService;

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
}
package com.midas.websolution.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ElonController {
	
	@RequestMapping("/ElonTest")
	public ModelAndView ElonTest() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/ElonTest");
		return view;
	}
}
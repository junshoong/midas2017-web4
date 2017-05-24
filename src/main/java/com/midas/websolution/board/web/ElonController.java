package com.midas.websolution.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.midas.websolution.board.service.ElonService;

@Controller
public class ElonController {
	
	private ElonService elonService;
	public void setElonService(ElonService elonService) {
		this.elonService = elonService;
	}
	
	@RequestMapping("/ElonTest")
	public ModelAndView ElonTest() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/ElonTest");
		
//		elonService.ElonTest();
		view.addObject("value", elonService.ElonTest());
		
		return view;
	}
}
package com.midas.websolution.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.midas.websolution.board.service.JunsuService;


@Controller
public class JunsuController {
	
	private JunsuService junsuService;
	
	public void setJunsuService(JunsuService junsuService) {
		this.junsuService = junsuService;
	}
	
	@RequestMapping("/junsu")
	public ModelAndView junsuPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("junsu");
		view.addObject("value", junsuService.getSomething());
		return view;
	}

}

package com.midas.websolution.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JunsuController {
	
	@RequestMapping("/junsu")
	public ModelAndView junsuPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("junsu");
		return view;
	}

}

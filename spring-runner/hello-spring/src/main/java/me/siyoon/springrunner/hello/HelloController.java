package me.siyoon.springrunner.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam("name") String name) {
		HelloModel model = new HelloModel(name);
		
//		View view = new JstlView("/WEB-INF/templates/HelloView.jsp");
		String viewName = "/WEB-INF/templates/HelloView.jsp";
		
		
		ModelAndView mav = new ModelAndView();
//		mav.setView(view);
		mav.setViewName(viewName);
		
		
		mav.addObject("hello", model);
		return mav;
	}
}

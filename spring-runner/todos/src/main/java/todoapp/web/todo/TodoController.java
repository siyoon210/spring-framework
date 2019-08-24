package todoapp.web.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import todoapp.web.model.SiteProperties;

@Controller
public class TodoController {
	private SiteProperties site;
	
	public TodoController (SiteProperties site) {
		this.site = site;
	}
	
	@RequestMapping("/todos")
	public ModelAndView todos() {
		return new ModelAndView("todos", "site", site);
	}

}

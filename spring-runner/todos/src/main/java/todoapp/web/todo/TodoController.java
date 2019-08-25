package todoapp.web.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import todoapp.commons.domain.Spreadsheet;
import todoapp.core.todos.application.TodoFinder;
import todoapp.core.todos.domain.Todo;
import todoapp.web.convert.TodoToSpreadsheetConverter;
import todoapp.web.model.SiteProperties;

@Controller
public class TodoController {
	private SiteProperties site;
	private final TodoFinder finder;
	
	public TodoController (SiteProperties site, TodoFinder finder) {
		this.site = site;
		this.finder = finder;
	}

	@RequestMapping("/todos") 
	public void todos(Model model) {
		List<Todo> todos = finder.getAll();
		Spreadsheet sheet = new TodoToSpreadsheetConverter().convert(todos);
		
		model.addAttribute("site", site);
		model.addAttribute(sheet);
	}

}

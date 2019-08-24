package todoapp.web.todo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import todoapp.core.todos.application.TodoEditor;
import todoapp.core.todos.application.TodoFinder;
import todoapp.core.todos.domain.Todo;

@RestController
public class TodoRestController {
	private final Logger log = LoggerFactory.getLogger(TodoRestController.class);
	private final TodoFinder finder;
	private final TodoEditor editor;
	
	public TodoRestController(TodoFinder finder, TodoEditor editor) {
		this.finder = finder;
		this.editor = editor;
	}
	
	@GetMapping("/api/todos")
	public List<Todo> todos(){
		return finder.getAll();
	}
	
	@PostMapping("/api/todos")
	public void create(@RequestBody TodoWriteCommand command) {
		log.debug("command.title: '{}'", command.getTitle());
		editor.create(command.getTitle());
	}
	
	@PutMapping("/api/todos/{id}")
	public void update(@PathVariable("id") Long id, @RequestBody TodoWriteCommand command) {
		log.debug("command.title: '{}', command.completed: '{}'", command.getTitle());
		editor.update(id, command.getTitle(), command.getCompleted());
	}
	
	@DeleteMapping("/api/todos/{id}")
	public void delete(@PathVariable("id") Long id) {
		editor.delete(id);
	}
	
	public static class TodoWriteCommand{
		private String title;
		private boolean completed;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public boolean getCompleted() {
			return completed;
		}

		public void setCompleted(boolean completed) {
			this.completed = completed;
		}
	}
}

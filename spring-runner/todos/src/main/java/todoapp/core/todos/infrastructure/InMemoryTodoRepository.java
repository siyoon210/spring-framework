package todoapp.core.todos.infrastructure;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import todoapp.Constant;
import todoapp.core.todos.domain.Todo;
import todoapp.core.todos.domain.TodoRepository;

/**
 * 메모리 기반 할 일 저장소 구현체
 *
 * @author springrunner.kr@gmail.com
 */
@Profile(Constant.PROFILE_DEVELOPMENT)
@Repository
public class InMemoryTodoRepository implements TodoRepository, InitializingBean, CommandLineRunner, ApplicationRunner{

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final List<Todo> todos = new CopyOnWriteArrayList<>();

    @Override
    public List<Todo> findAll() {
        return Collections.unmodifiableList(todos);
    }

    @Override
    public List<Todo> findByUsername(String username) {
        List<Todo> result = todos.stream()
                                 .filter(todo -> Objects.equals(username, todo.getUsername()))
                                 .collect(Collectors.toList());
        return Collections.unmodifiableList(result);
    }

    public Optional<Todo> findById(Long id) {
        return todos.stream().filter(todo -> Objects.equals(id, todo.getId())).findFirst();
    }

    @Override
    public Todo save(Todo todo) {
        if (todos.contains(todo) == false) {
            todos.add(todo);
        }
        return todo;
    }

    @Override
    public void delete(Todo todo) {
        todos.remove(todo);
    }

	@Override
	public void run(ApplicationArguments args) throws Exception {
		save(Todo.create("Task One"));
	}

	@Override
	public void run(String... args) throws Exception {
		save(Todo.create("Task Two"));
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("애플리케이션 러너가 수행되었습니다.");
	}
}
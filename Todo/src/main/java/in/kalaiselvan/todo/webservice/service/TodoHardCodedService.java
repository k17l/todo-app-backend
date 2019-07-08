package in.kalaiselvan.todo.webservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import in.kalaiselvan.todo.webservice.bean.Todo;

@Service
public class TodoHardCodedService {

	private static List<Todo> todos = new ArrayList<>();
	private static long idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "in28minutes", "Learn to Dance 2", LocalDate.now(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn about Microservices 2", LocalDate.now(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn about Angular", LocalDate.now(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo == null)
			return null;

		if (todos.remove(todo)) {
			return todo;
		}

		return null;
	}

	public Todo findById(long id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
}
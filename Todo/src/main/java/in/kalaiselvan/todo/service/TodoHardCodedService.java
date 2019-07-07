package in.kalaiselvan.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import in.kalaiselvan.todo.bean.TodoBean;

@Service
public class TodoHardCodedService {

	private static List<TodoBean> todos = new ArrayList<>();
	private static long idCounter = 0;

	static {
		todos.add(new TodoBean(++idCounter, "in28minutes", "Learn to Dance 2", LocalDate.now(), false));
		todos.add(new TodoBean(++idCounter, "in28minutes", "Learn about Microservices 2", LocalDate.now(), false));
		todos.add(new TodoBean(++idCounter, "in28minutes", "Learn about Angular", LocalDate.now(), false));
	}

	public List<TodoBean> findAll() {
		return todos;
	}

	public TodoBean deleteById(long id) {
		TodoBean todo = findById(id);
		if (todo == null)
			return null;

		if (todos.remove(todo)) {
			return todo;
		}

		return null;
	}

	public TodoBean findById(long id) {
		for (TodoBean todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public TodoBean save(TodoBean todo) {
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
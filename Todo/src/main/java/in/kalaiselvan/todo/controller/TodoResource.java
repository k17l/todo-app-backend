package in.kalaiselvan.todo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import in.kalaiselvan.todo.bean.TodoBean;
import in.kalaiselvan.todo.service.TodoHardCodedService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

	@Autowired
	TodoHardCodedService todoHardCodedService;

	@GetMapping(path = "/users/{username}/todos")
	public List<TodoBean> getAllTodos(@PathVariable String username) {
		return todoHardCodedService.findAll();
	}

	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		TodoBean todo = todoHardCodedService.deleteById(id);

		if (todo != null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public TodoBean getTodo(@PathVariable String username, @PathVariable long id) {
		return todoHardCodedService.findById(id);
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<TodoBean> updateTodo(
			@PathVariable String username,
			@PathVariable long id, @RequestBody TodoBean todo){
		
		todo.setUsername(username);
		
		TodoBean todoUpdated = todoHardCodedService.save(todo);
		
		return new ResponseEntity<TodoBean>(todoUpdated, HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Void> createTodo(
			@PathVariable String username, @RequestBody TodoBean todo){
		
		todo.setUsername(username);
		
		TodoBean createdTodo = todoHardCodedService.save(todo);
		
		//Location
		//Get current resource url
		///{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
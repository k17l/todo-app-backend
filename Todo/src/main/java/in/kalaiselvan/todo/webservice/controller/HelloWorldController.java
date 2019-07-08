package in.kalaiselvan.todo.webservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.kalaiselvan.todo.webservice.bean.HelloWorldBean;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
public class HelloWorldController {
	
	
	@GetMapping(path = "/")
	public String home() {
		return "Hello World!!!";
	}
	
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World!!!";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World!!!");
	}
	
	@GetMapping(path = "/hello-world/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World!!! %s",name));
	}
}
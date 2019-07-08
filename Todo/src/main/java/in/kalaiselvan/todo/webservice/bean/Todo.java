package in.kalaiselvan.todo.webservice.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Todo {

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String description;
	private LocalDate targetDate;
	private boolean isDone;
}
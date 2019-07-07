package in.kalaiselvan.todo.bean;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoBean {

	private long id;
	private String username;
	private String description;
	private LocalDate targetDate;
	private boolean isDone;
}
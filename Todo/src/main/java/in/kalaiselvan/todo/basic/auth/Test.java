package in.kalaiselvan.todo.basic.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for (int i = 0; i <= 10; i++) {
			String password = encoder.encode("password");
			System.out.println(password);
		}
	}
}
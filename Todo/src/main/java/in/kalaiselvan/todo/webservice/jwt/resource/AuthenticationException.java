package in.kalaiselvan.todo.webservice.jwt.resource;

public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = 5273220274814435599L;

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
}

package big_project_phase1_partial_rewrite;

import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("serial")
public class InvalidLoginException extends Exception {
	public InvalidLoginException() {
		super("Invalid login info");
	}
}

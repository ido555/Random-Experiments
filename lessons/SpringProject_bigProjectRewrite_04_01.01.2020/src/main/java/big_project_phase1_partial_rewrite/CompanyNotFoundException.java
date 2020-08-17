package big_project_phase1_partial_rewrite;

import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("serial")
public class CompanyNotFoundException extends Exception {
	public CompanyNotFoundException() {
		super("Company not found");
	}
}

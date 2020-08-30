package big_project_phase1_partial_rewrite;

public class Company {
	private int companyId;
	private String name, email, password;

	/**
	 * This CTOR is used to RETRIEVE or UPDATE a company FROM the DB
	 * 
	 * @param companyId - int
	 * @param name      - String
	 * @param email     - String
	 * @param password  - String
	 */
	public Company(int companyId, String name, String email, String password) {
		this.companyId = companyId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	/**
	 * This CTOR is used to INSERT a company INTO the DB
	 * 
	 * @param name     - String
	 * @param email    - String
	 * @param password - String
	 */
	public Company(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCompanyId() {
		return companyId;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", name=" + name + ", email=" + email + ", password=" + password
				+ "]";
	}

}

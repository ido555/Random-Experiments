package ex_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Employee extends Worker {
	private String jobDesc;
	private int numDaysOff;
	@Autowired
	private CEO ceo;

	public Employee(String name, double salary, String jobDesc, int numDaysOff, CEO ceo) {
		super(name, salary);
		this.jobDesc = jobDesc;
		this.numDaysOff = numDaysOff;
		this.ceo = ceo;
	}
	
	
	@Override
	public String toString() {
		return String.format("Employee [jobDesc=%s, numDaysOff=%s, getName()=%s, getSalary()=%s, ceo=%s]", jobDesc,
				numDaysOff, getSalary(), getName(), ceo);
	}


	public String getJobDesc() {
		return jobDesc;
	}

	public int getNumDaysOff() {
		return numDaysOff;
	}

	public CEO getCeo() {
		return ceo;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public void setNumDaysOff(int numDaysOff) {
		this.numDaysOff = numDaysOff;
	}

	public void setCeo(CEO ceo) {
		this.ceo = ceo;
	}

}
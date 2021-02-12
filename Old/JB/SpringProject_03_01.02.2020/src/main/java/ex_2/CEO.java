package ex_2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class CEO extends Worker {
	private double yearlyBonus;

	public CEO() {
		setName("pp");
		setSalary(90_000);
		setYearlyBonus(900_000.5);
	}

	@Override
	public String toString() {
		return String.format("CEO [yearlyBonus=%s, getName()=%s, getSalary()=%s]", yearlyBonus, getName(), getSalary());
	}

	public double getYearlyBonus() {
		return yearlyBonus;
	}

	public void setYearlyBonus(double yearlyBonus) {
		this.yearlyBonus = yearlyBonus;
	}

}

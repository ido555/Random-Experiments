package proj.tests;

import java.util.Random;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proj.DBDAO.CompanyDBDAO;
import proj.DBDAO.CouponDBDAO;
import proj.beans.Company;
import proj.beans.Coupon;
import proj.beans.Employee;
import proj.config.SpringConfig;
import proj.enums.CategoryType;

public class Test {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)) {
			int leftLimit = 48; // numeral '0'
			int rightLimit = 122; // letter 'z'
			int targetStringLength = 10;
			Random random = new Random();
			String generatedString = random.ints(leftLimit, rightLimit + 1)
					.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

			CompanyDBDAO companyDBDAO = ctx.getBean(CompanyDBDAO.class);
			CouponDBDAO couponDBDAO = ctx.getBean(CouponDBDAO.class);
			companyDBDAO.addCompany(new Company("testComp", generatedString, "1234"));
			companyDBDAO.addCompany(new Company("BBBBBBBBB", generatedString + "aa", "4441414"));
			couponDBDAO.addCoupon(new Coupon(companyDBDAO.getOneCompany(1), "2eltiTtset", "ABCDEFGHIJKLMNOP", 7,
					CategoryType.Vacation));
			couponDBDAO.addCoupon(
					new Coupon(companyDBDAO.getOneCompany(1), "testTitle2", "BBBBBBBB", 5, CategoryType.Shoes));
			System.out.println(companyDBDAO.getOneCompany(1) + " " + companyDBDAO.getOneCompany(1).getCoupons());
			System.out.println(companyDBDAO.getOneCompany(2) + " " + companyDBDAO.getOneCompany(2).getCoupons());
			System.out.println(companyDBDAO.getFirstCompanyByEmail(generatedString));
			System.out.println(companyDBDAO.getFirstCompanyByEmail(generatedString + "aa"));
			System.out.println(couponDBDAO.getAllCouponsByCategory(CategoryType.Vacation));
			System.out.println(couponDBDAO.getAllCouponsUnderPrice(9));
			Employee employee = new Employee("a", 1234, 5, companyDBDAO.getOneCompany(5));
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
// understand create-drop and create better
package proj.DBDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proj.beans.Coupon;
import proj.enums.CategoryType;

/* In layman terms, a Spring Component is responsible for some operations*/
/* the Repository annotation indicates that the class deals with CRUD operations,
 *  usually it’s used with DAO implementations that deal with database tables.*/

/* Spring uses Components for DI(dependency injections - Reflections)*/

@Component
//@Repository
@Transactional // reverts if something goes wrong
public class CouponDBDAO {
	@Autowired
	private SessionFactory LocalSesh; // Hibernate SessionFactory not java
	// LocalSesh.getCurrentSession() - kind of like opening Connection - changing DB
	// stuff - closing Connection. it does that by itself

	public void addCoupon(Coupon coupon) {
		LocalSesh.getCurrentSession().save(coupon);
	}

	public void updateCoupon(Coupon coupon) {
		LocalSesh.getCurrentSession().update(coupon);
	}

	public void deleteCoupon(int id) {
		LocalSesh.getCurrentSession().delete(getOneCoupon(id));
	}

	public Coupon getOneCoupon(int id) {
		return LocalSesh.getCurrentSession().get(Coupon.class, id);
	}

	public List<Coupon> getAllCouponsByCategory(CategoryType cat) {
		ArrayList<Coupon> coupons = new ArrayList<Coupon>();
		for (Coupon coupon : getAllCoupons()) {
			if (coupon.getCategory().ordinal() == cat.ordinal()) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}

	public List<Coupon> getAllCouponsUnderPrice(int price) {
		ArrayList<Coupon> catCoupons = new ArrayList<Coupon>();
		for (Coupon coupon : getAllCoupons()) {
			if (coupon.getPrice() < price) {
				catCoupons.add(coupon);
			}
		}
		return catCoupons;
	}

	public List<Coupon> getAllCoupons() {
		TypedQuery<Coupon> query = LocalSesh.getCurrentSession().createQuery("FROM Coupon", Coupon.class);
		return query.getResultList();
	}
}

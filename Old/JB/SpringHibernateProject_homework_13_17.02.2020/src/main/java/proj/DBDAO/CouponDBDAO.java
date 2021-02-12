package proj.DBDAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proj.beans.Coupon;
import proj.enums.CategoryType;

@Repository // for DB stuff // speaks with db
// @Service - for BL - buisness logic - facades
// @Controller - web
// all of these are just @Component
// they just clarify stuff to the reader 
public class CouponDBDAO {
	@Autowired
	private SessionFactory LocalSesh;

	public void addCoupon(Coupon coupon) {
		LocalSesh.getCurrentSession().save(coupon);
	}

	public List<Coupon> getAllCoupons() {
		TypedQuery<Coupon> query = LocalSesh.getCurrentSession().createQuery("FROM Coupon", Coupon.class);
		return query.getResultList();
	}

	public List<Coupon> getAllCouponsUnderMaxPrice(int price) {
		TypedQuery<Coupon> query = LocalSesh.getCurrentSession()
				.createQuery("SELECT coupon FROM Coupon coupon WHERE coupon.price <= :price" /* ?1 */, Coupon.class);
		query.setParameter("price", price);
//		query.setParameter(1, price);
		return query.getResultList();
	}

	public List<Coupon> getCouponsByCategory(CategoryType category) {
		TypedQuery<Coupon> query = LocalSesh.getCurrentSession().createQuery
				("SELECT Coupon FROM Coupon coupon WHERE coupon.category = :cat", Coupon.class);
		query.setParameter("cat", category);
		return query.getResultList();
	}

}

import { CouponCategory } from './../enums/coupon-category.enum';
import { Coupon } from './../models/coupon';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
	providedIn: 'root'
})
export class CompanyControllerService {

	constructor(private httpClient: HttpClient) { }
	public getDetails(token: String) {
		return this.httpClient.get("http://localhost:8080/company/details/" + token)
	}
	public getAllCoupons(token: String) {
		return this.httpClient.get("http://localhost:8080/company/allCoupons/" + token)
	}
	public getCouponsByCategory(token: String, type: CouponCategory) {
		return this.httpClient.get("http://localhost:8080/company/categoryCoupons/" + token + "/" + type)
	}
	public getCouponsUnderPrice(token: String, maxPrice: Number) {
		return this.httpClient.get("http://localhost:8080/company/priceCoupons/" + token + "/" + maxPrice)
	}
	public addCoupon(token: String, coupon: Coupon) {
		return this.httpClient.post("http://localhost:8080/company/addCoupon/" + token, coupon)
	}
	public updateCoupon(token: String, coupon: Coupon) {
		return this.httpClient.put("http://localhost:8080/company/updateCoupon/" + token, coupon)
	}
	public deleteCoupon(token: String, coupon: Coupon) {
		return this.httpClient.delete("http://localhost:8080/company/deleteCoupon/" + token, coupon)
	}
}
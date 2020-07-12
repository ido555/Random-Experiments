import { CouponCategory } from './../enums/coupon-category.enum';
import { Coupon } from './../models/coupon';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
	providedIn: 'root'
})
export class CompanyControllerService {

	constructor(private httpClient: HttpClient) { }
	public getDetails(token: string) {
		return this.httpClient.get("http://localhost:8080/company/details/" + token)
	}
	public getAllCoupons(token: string) {
		return this.httpClient.get("http://localhost:8080/company/allCoupons/" + token)
	}
	public getCouponsByCategory(token: string, type: CouponCategory) {
		return this.httpClient.get("http://localhost:8080/company/categoryCoupons/" + token + "/" + type)
	}
	public getCouponsUnderPrice(token: string, maxPrice: number) {
		return this.httpClient.get("http://localhost:8080/company/priceCoupons/" + token + "/" + maxPrice)
	}
	public addCoupon(token: string, coupon: Coupon) {
		return this.httpClient.post("http://localhost:8080/company/addCoupon/" + token, coupon)
	}
	public updateCoupon(token: string, coupon: Coupon) {
		return this.httpClient.put("http://localhost:8080/company/updateCoupon/" + token, coupon)
	}
	public deleteCoupon(token: string, id: number) {
		return this.httpClient.delete("http://localhost:8080/company/deleteCoupon/" + token + "/" + id)
	}
}
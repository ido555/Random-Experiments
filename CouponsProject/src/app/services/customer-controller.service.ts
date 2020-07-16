import {Coupon} from '../models/coupon';
import {CouponCategory} from '../enums/coupon-category.enum';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomerControllerService {

  constructor(private httpClient: HttpClient) { }
  public getDetails(token: string) {
    return this.httpClient.get('http://localhost:8080/customer/details/' + token);
  }
  public getAllCoupons(token: string) {
    return this.httpClient.get('http://localhost:8080/customer/allCoupons/' + token);
  }
  public getCouponsByCategory(token: string, type: CouponCategory) {
    return this.httpClient.get('http://localhost:8080/customer/categoryCoupons/' + token + '/' + type);
  }
  public getCouponsUnderPrice(token: string, maxPrice: number) {
    return this.httpClient.get('http://localhost:8080/customer/priceCoupons/' + token + '/' + maxPrice);
  }
  public purchaseCoupon(token: string, coupon: Coupon) {
    return this.httpClient.post('http://localhost:8080/customer/priceCoupons/' + token, coupon);
  }
}

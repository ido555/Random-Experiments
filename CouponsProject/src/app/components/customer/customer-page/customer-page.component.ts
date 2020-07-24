import {Component, OnInit} from '@angular/core';
import {GlobalService} from '../../../services/global.service';
import {LoginControllerService} from '../../../services/login-controller.service';
import {Coupon} from '../../../models/coupon';
import {CustomerControllerService} from '../../../services/customer-controller.service';
import {CouponCategory} from '../../../enums/coupon-category.enum';
import {newArray} from '@angular/compiler/src/util';

@Component({
  selector: 'app-customer-page',
  templateUrl: './customer-page.component.html',
  styleUrls: ['./customer-page.component.css']
})
export class CustomerPageComponent implements OnInit {
  coupons;
  temp: any[] = new Array();

  constructor(private glob: GlobalService, private logMan: LoginControllerService, private cont: CustomerControllerService) {
  }

  ngOnInit(): void {
    var elements = document.getElementsByTagName('BODY') as HTMLCollectionOf<HTMLElement>;
    elements[0].style.overflowY = 'visible';
    this.coupons = this.getAllCoupons();
  }

  getPurchasedCouponsByCategory(cat: CouponCategory) {
    let coupons;
    this.cont.getCouponsByCategory(this.glob.getToken(), cat).subscribe(
      s => coupons = s,
      e => this.glob.errPopup(e.error)
    );
    return coupons;
  }

  getPurchasedCouponsUnderPrice(maxPrice: number) {
    let coupons;
    this.cont.getCouponsUnderPrice(this.glob.getToken(), maxPrice).subscribe(
      s => coupons = s,
      e => this.glob.errPopup(e.error)
    );
    return coupons;
  }

  // TODO snackbar popup confirmation
  purchaseCoupon(coupon: Coupon) {
    this.cont.purchaseCoupon(this.glob.getToken(), coupon).subscribe(
      s => console.log(s),
      e => this.glob.errPopup(e.error)
    );
  }

  getAllPurchasedCoupons() {
    let coupons;
    this.cont.getAllCoupons(this.glob.getToken()).subscribe(
      s => coupons = s,
      e => this.glob.errPopup(e.error)
    );
    return coupons;
  }

  initCoupons(s) {
    this.temp = s;
    for (let i = 0; i < this.temp.length; i++) {
      let ref = this.temp[i];
      let c:Coupon = new Coupon(ref.couponId, ref.amount, ref.price, ref.title, ref.description,
        ref.image, ref.startDate, ref.endDate, ref.category);
      console.log(c)
    }
  }

  getAllCoupons() {
    this.logMan.getAllCoupons(this.glob.getToken()).subscribe(
      s => {this.initCoupons(Object.create(s))},
      e => this.glob.errPopup(e.error)
    );

    return null;
  }

  getDetails() {
    console.log();
    this.cont.getDetails(this.glob.getToken()).subscribe(
      s => console.log(s),
      e => this.glob.errPopup(e.error));
  };

  counter(n: number) {
    let nums = new Array(n);
    for (let i = 0; i < n; i++) {
      nums[i] = i + 1;
    }
    return nums;
  }
}

import {Component, OnInit} from '@angular/core';
import {GlobalService} from '../../../services/global.service';
import {LoginControllerService} from '../../../services/login-controller.service';
import {Coupon} from '../../../models/coupon';
import {CustomerControllerService} from '../../../services/customer-controller.service';
import {CouponCategory} from '../../../enums/coupon-category.enum';

@Component({
  selector: 'app-customer-page',
  templateUrl: './customer-page.component.html',
  styleUrls: ['./customer-page.component.css']
})
export class CustomerPageComponent implements OnInit {
  coupons: Array<Coupon> = new Array<Coupon>();
  purchasedCoupons: Array<Coupon> = new Array<Coupon>();

  constructor(private glob: GlobalService, private logMan: LoginControllerService, private cont: CustomerControllerService) {
  }

  ngOnInit(): void {
    var elements = document.getElementsByTagName('BODY') as HTMLCollectionOf<HTMLElement>;
    elements[0].style.overflowY = 'visible';
    this.getAllPurchasedCoupons();
    this.getAllCoupons();
  }

  isCouponAlreadyBought(coupToCheck: Coupon) {
    for (let coupon of this.purchasedCoupons) {
        if (coupon.$couponId == coupToCheck.$couponId)
          return true;
    }
    return false;
  }

  getAllPurchasedCoupons() {
    this.cont.getAllCoupons(this.glob.getToken()).subscribe(
      s => {
        this.purchasedCoupons = this.glob.initCoupons(s);
      },
      e => this.glob.errPopup(e.error)
    );
  }

  getPurchasedCouponsByCategory(cat: CouponCategory) {
    this.cont.getCouponsByCategory(this.glob.getToken(), cat).subscribe(
      s => s,
      e => this.glob.errPopup(e.error)
    );
  }

  getPurchasedCouponsUnderPrice(maxPrice: number) {
    this.cont.getCouponsUnderPrice(this.glob.getToken(), maxPrice).subscribe(
      s => s,
      e => this.glob.errPopup(e.error)
    );
  }

  // TODO snackbar popup confirmation
  purchaseCoupon(coupon: Coupon) {

    this.cont.purchaseCoupon(this.glob.getToken(), coupon).subscribe(
      s => {
        console.log(s);
        this.purchasedCoupons.push(coupon);
      },
      e => this.glob.errPopup(e.error)
    );
  }


  getAllCoupons() {
    this.logMan.getAllCoupons(this.glob.getToken()).subscribe(
      s => this.coupons = this.glob.initCoupons(s),
      e => this.glob.errPopup(e.error)
    );
  }

}

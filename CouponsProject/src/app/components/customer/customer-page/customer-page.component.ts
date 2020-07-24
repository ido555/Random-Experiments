import {Component, OnInit} from '@angular/core';
import {GlobalService} from '../../../services/global.service';
import {LoginControllerService} from '../../../services/login-controller.service';
import {Coupon} from '../../../models/coupon';
import {CustomerControllerService} from '../../../services/customer-controller.service';

@Component({
  selector: 'app-customer-page',
  templateUrl: './customer-page.component.html',
  styleUrls: ['./customer-page.component.css']
})
export class CustomerPageComponent implements OnInit {
  coupons: Array<Coupon>;

  constructor(glob: GlobalService, private logMan: LoginControllerService, cont: CustomerControllerService) {
  }

  ngOnInit(): void {
    var elements = document.getElementsByTagName("BODY") as HTMLCollectionOf<HTMLElement>;
    // elements[0].style.overflow = "auto"
    elements[0].style.overflowY = "visible"
  }

  counter(n: number) {
    let nums = new Array(n);
    for (let i = 0; i < n; i++) {
      nums[i] = i + 1;
    }
    return nums;
  }
}

import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {GlobalService} from '../../../services/global.service';
import {CustomerControllerService} from '../../../services/customer-controller.service';
import {Customer} from '../../../models/customer';
import {Coupon} from '../../../models/coupon';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {
  coupons: Array<Coupon> = new Array<Coupon>();
  // initialize cust because html interpolation starts too early and throws errors
  // just before getDetails() completes
  cust: Customer = new Customer(
    undefined, undefined,undefined,undefined,undefined,undefined,);

  constructor(private dialogRef: MatDialogRef<CustomerDetailsComponent>, private glob: GlobalService,
              private cont: CustomerControllerService) {
  }

  ngOnInit(): void {
    this.getDetails()
  }

  initCust(cust){
    this.cust = new Customer(cust.customerId, cust.password, cust.email, cust.firstName, cust.lastName, cust.coupons);
  }
  getAllPurchasedCoupons() {
    this.cont.getAllCoupons(this.glob.getToken()).subscribe(
      s => {
        this.coupons = this.glob.initCoupons(s);
      },
      e => this.glob.errPopup(e.error)
    );
  }


  getDetails() {
    this.cont.getDetails(this.glob.getToken()).subscribe(
      s => this.initCust(s),
      e => this.glob.errPopup(e.error));
  };
}

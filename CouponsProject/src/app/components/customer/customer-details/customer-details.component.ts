import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {GlobalService} from '../../../services/global.service';
import {CustomerControllerService} from '../../../services/customer-controller.service';
import {Customer} from '../../../models/customer';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {
  cust: Customer;


  constructor(private dialogRef: MatDialogRef<CustomerDetailsComponent>, private glob: GlobalService,
              private cont: CustomerControllerService) {
  }

  ngOnInit(): void {
    this.getDetails()
  }

  initCust(cust){
    this.cust = new Customer(cust.customerId, cust.password, cust.email, cust.firstName, cust.lastName, cust.coupons);
  }
  getDetails() {
    this.cont.getDetails(this.glob.getToken()).subscribe(
      s => this.initCust(s),
      e => this.glob.errPopup(e.error));
  };
}

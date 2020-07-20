import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {AdminControllerService} from '../../../services/admin-controller.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {GlobalService} from '../../../services/global.service';
import {Customer} from '../../../models/customer';

@Component({
  selector: 'app-customer-add-update-delete',
  templateUrl: './customer-add-update-delete.component.html',
  styleUrls: ['./customer-add-update-delete.component.css']
})
export class CustomerAddUpdateDeleteComponent implements OnInit {
  err: any;
  cust: Customer;
  text: object;
  // TODO fix? (make seperate classes for comp and cust) cant have just 1 clientForm for some reason - i tried for too long so i just moved on
  custForm: FormGroup;

  constructor(private dialogRef: MatDialogRef<CustomerAddUpdateDeleteComponent>, @Inject(MAT_DIALOG_DATA) public data,
              private cont: AdminControllerService, private dialog: MatDialog, private fb: FormBuilder, public glob: GlobalService) {
  }

  ngOnInit(): void {
    this.cust = new Customer(this.client.customerId, this.client.password, this.client.email,
      this.client.firstName, this.client.lastName, []);

    this.custForm = this.fb.group({
      firstName: [this.cust.$firstName],
      lastName: [this.cust.$lastName],
      password: [this.cust.$password, [Validators.required]],
      email: [this.cust.$email, [Validators.required, Validators.email]]
    });
  }

  closeDialog() {
    this.dialogRef.close();
  }

  errPopup(e: string) {
    this.glob.errPopup(e);
  }

  refreshCustomer() {
    this.cust.$firstName = this.custForm.controls.firstName.value;
    this.cust.$lastName = this.custForm.controls.lastName.value;
    this.cust.$email = this.custForm.controls.email.value;
    this.cust.$password = this.custForm.controls.password.value;
  }
  addCustomer() {
    refreshCustomer()
    this.updateClients();
    this.cont.addCustomer(sessionStorage.getItem('token'), this.cust).subscribe(
      () => this.closeDialog(),
      e => this.errPopup(e.error));
  }
  updateCustomer() {
    refreshCustomer()
    this.cont.updateCustomer(sessionStorage.getItem('token'), this.cust).subscribe(
      () => this.closeDialog(),
      e => this.errPopup(e));
  }
  deleteCustomer() {
    this.cont.deleteCustomer(sessionStorage.getItem('token'), this.cust.$customerId).subscribe(
      () => this.closeDialog(),
      e => this.errPopup(e));
  }
}

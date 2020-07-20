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
  custForm: FormGroup;

  constructor(private dialogRef: MatDialogRef<CustomerAddUpdateDeleteComponent>, @Inject(MAT_DIALOG_DATA) public data,
              private cont: AdminControllerService, private dialog: MatDialog, private fb: FormBuilder, public glob: GlobalService) {
  }

  ngOnInit(): void {
    if (this.data != undefined) {
      this.cust = new Customer(this.data.customerId, this.data.password, this.data.email,
        this.data.firstName, this.data.lastName, []);
      this.custForm = this.fb.group({
        firstName: [this.cust.$firstName],
        lastName: [this.cust.$lastName],
        password: [this.cust.$password, [Validators.required]],
        email: [this.cust.$email, [Validators.required, Validators.email]]
      });
    } else {
      this.custForm = this.fb.group({
        firstName: [''],
        lastName: [''],
        password: ['', [Validators.required]],
        email: ['', [Validators.required, Validators.email]]
      });
    }

    console.log(this.data);
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
    this.refreshCustomer();
    this.cont.addCustomer(sessionStorage.getItem('token'), this.cust).subscribe(
      () => this.closeDialog(),
      e => this.errPopup(e.error));
  }

  updateCustomer() {
    this.refreshCustomer();
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

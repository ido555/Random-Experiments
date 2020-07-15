import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { Component, OnInit, Inject } from '@angular/core';
import { ClientType } from 'src/app/enums/client-type.enum';
import { AdminControllerService } from 'src/app/services/admin-controller.service';
import { Company } from 'src/app/models/company';
import { Customer } from 'src/app/models/customer';
import { ErrorBoxComponent } from '../error-box/error-box.component';
import { FormBuilder, FormGroup, FormControl, Validators, AbstractControl } from '@angular/forms';

@Component({
  selector: 'app-client-info-popup',
  templateUrl: './client-info-popup.component.html',
  styleUrls: ['./client-info-popup.component.css']
})
export class ClientInfoPopupComponent implements OnInit {
  err: any;
  client;
  comp: Company = null;
  cust: Customer = null;
  text: Object;
  // TODO fix? (make seperate classes for comp and cust) cant have just 1 clientForm for some reason - i tried for too long
  compForm: FormGroup;
  custForm: FormGroup;
  ClientType = ClientType;

  constructor(private dialogRef: MatDialogRef<ClientInfoPopupComponent>, @Inject(MAT_DIALOG_DATA) public data,
    private cont: AdminControllerService, private dialog: MatDialog, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.client = this.data;
    if (this.client.companyId != null)
      this.comp = new Company(this.client.companyId, this.client.password, this.client.name, this.client.email)
    if (this.client.customerId != null)
      this.cust = new Customer(this.client.customerId, this.client.password, this.client.email, this.client.firstName, this.client.lastName, [])
    
    if (this.comp != null) {
      this.compForm = this.fb.group({
        password: [this.comp.$password, Validators.required],
        email: [this.comp.$email, [Validators.required, Validators.email]],
        name: [this.comp.$name, Validators.required],
      })
    }
    if (this.cust != null) {
      this.custForm = this.fb.group({
        firstName: [this.cust.$firstName],
        lastName: [this.cust.$lastName],
        password: [this.cust.$password, [Validators.required]],
        email: [this.cust.$email, [Validators.required, Validators.email]]
      })
    }
  }
  closeDialog() {
    this.dialogRef.close()
  }
  errPopup(err: string) {
    this.dialog.open(ErrorBoxComponent,
      {
        minHeight: 400, minWidth: 400, disableClose: false,
        data: { err: err }
      })
  }
  log() {
    console.log(this.compForm);
  }

    update(type: ClientType) {
      this.updateClients();
      if(type == ClientType.Company)
      this.updateCompany(this.comp);
      if(type == ClientType.Customer)
      this.updateCustomer(this.cust);
    }

    updateClients(){
      if (this.cust != null)
      if (this.custForm.valid) {
        this.cust.$firstName = this.custForm.controls['firstName'].value;
        this.cust.$lastName = this.custForm.controls['lastName'].value;
        this.cust.$email = this.custForm.controls['email'].value;
        this.cust.$password = this.custForm.controls['password'].value;
      }
    if (this.comp != null)
      if (this.compForm.valid) {
        this.comp.$name = this.compForm.controls['name'].value;
        this.comp.$email = this.compForm.controls['email'].value;
        this.comp.$password = this.compForm.controls['password'].value;
      }
    }

  updateCustomer(cust: Customer) {
    console.log(this.cust)
    this.cont.updateCustomer(localStorage.getItem("token"), cust).
      subscribe(
        s => this.closeDialog(),
        e => this.errPopup(e))
  }
  updateCompany(comp: Company) {
    this.cont.updateCompany(localStorage.getItem("token"), comp).
      subscribe(
        s => this.closeDialog(),
        e => this.errPopup(e))
  }
  deleteCustomer(customerId: number) {
    console.log(this.custForm)
    this.cont.deleteCustomer(localStorage.getItem("token"), customerId).
      subscribe(
        s => this.closeDialog(),
        e => this.errPopup(e))
  }
  deleteCompany(companyId: number) {
    this.cont.deleteCompany(localStorage.getItem("token"), companyId).
      subscribe(
        s => this.closeDialog(),
        e => this.errPopup(e))
  }
}

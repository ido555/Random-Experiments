import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { Component, OnInit, Inject } from '@angular/core';
import { ClientType } from 'src/app/enums/client-type.enum';
import { AdminControllerService } from 'src/app/services/admin-controller.service';
import { Company } from 'src/app/models/company';
import { Customer } from 'src/app/models/customer';
import { ErrorBoxComponent } from '../error-box/error-box.component';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-client-info-popup',
  templateUrl: './client-info-popup.component.html',
  styleUrls: ['./client-info-popup.component.css']
})
export class ClientInfoPopupComponent implements OnInit {
  err;
  client;
  text;
  clientForm: FormGroup;
  clientType: ClientType;
  ClientType = ClientType;

  constructor(private dialogRef: MatDialogRef<ClientInfoPopupComponent>, @Inject(MAT_DIALOG_DATA) public data,
    private cont: AdminControllerService, private dialog: MatDialog, private fb: FormBuilder) { }

    ngOnInit(): void {
      this.clientForm = this.fb.group({
        password: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
        name: [''],
        firstName: [''],
        lastName: [''],
      })

    this.client = this.data.row[0];
    console.log(this.client.email)
    if (this.client.companyId != null){
      this.clientType = ClientType.Company
      var comp:Company = new Company(client.companyId)
    }
      if (this.client.customerId != null)
    this.clientType = ClientType.Customer
  }
  closeDialog() {
    this.dialogRef.close()
  }
  errPopup(err: String) {
    this.dialog.open(ErrorBoxComponent,
      {
        minHeight: 200, minWidth: 200, disableClose: false,
        data: { err: err }
      })
  }
  updateCustomer(cust: Customer) {
    this.cont.updateCustomer(localStorage.getItem("token"), cust).
      subscribe(
        s => this.text = s,
        e => this.errPopup(e))
  }
  updateCompany(comp: Company) {
    this.cont.updateCompany(localStorage.getItem("token"), comp).
      subscribe(
        s => this.text = s,
        e => this.errPopup(e))
  }
  deleteCustomer(cust: Customer) {
    this.cont.deleteCustomer(localStorage.getItem("token"), cust).
      subscribe(
        s => this.text = s,
        e => this.errPopup(e))
  }
  deleteCompany(comp: Company) {
    this.cont.deleteCompany(localStorage.getItem("token"), comp).
      subscribe(
        s => this.text = s,
        e => this.errPopup(e))
  }
}

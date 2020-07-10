import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { Component, OnInit, Inject } from '@angular/core';
import { ClientType } from 'src/app/enums/client-type.enum';
import { AdminControllerService } from 'src/app/services/admin-controller.service';
import { Company } from 'src/app/models/company';
import { Customer } from 'src/app/models/customer';
import { ErrorBoxComponent } from '../error-box/error-box.component';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-client-info-popup',
  templateUrl: './client-info-popup.component.html',
  styleUrls: ['./client-info-popup.component.css']
})
export class ClientInfoPopupComponent implements OnInit {
  err;
  client;
  clientForm: FormGroup;
  text;
  clientType: ClientType;

  constructor(private dialogRef: MatDialogRef<ClientInfoPopupComponent>, @Inject(MAT_DIALOG_DATA) public data
    , private cont: AdminControllerService, private dialog: MatDialog, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.client = this.data.client
    if (this.client.companyId != null)
      this.clientType = ClientType.Company
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

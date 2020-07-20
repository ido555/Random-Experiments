// import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
// import {Component, Inject, OnInit} from '@angular/core';
// import {ClientType} from 'src/app/enums/client-type.enum';
// import {AdminControllerService} from 'src/app/services/admin-controller.service';
// import {Company} from 'src/app/models/company';
// import {Customer} from 'src/app/models/customer';
// import {FormBuilder, FormGroup, Validators} from '@angular/forms';
// import {GlobalService} from '../../../services/global.service';
//
// @Component({
//   selector: 'app-client-info-popup',
//   templateUrl: './client-info-popup.component.html',
//   styleUrls: ['./client-info-popup.component.css']
// })
// export class ClientInfoPopupComponent implements OnInit {
//   err: any;
//   client;
//   comp: Company = null;
//   cust: Customer = null;
//   text: object;
//   // TODO fix? (make seperate classes for comp and cust) cant have just 1 clientForm for some reason - i tried for too long so i just moved on
//   compForm: FormGroup;
//   custForm: FormGroup;
//   ClientType = ClientType;
//
//   constructor(private dialogRef: MatDialogRef<ClientInfoPopupComponent>, @Inject(MAT_DIALOG_DATA) public data,
//               private cont: AdminControllerService, private dialog: MatDialog, private fb: FormBuilder, public glob: GlobalService) {
//   }
//
//   ngOnInit(): void {
//     this.client = this.data;
//     console.log(this.client);
//     if (this.client.companyId != null) {
//       this.comp = new Company(this.client.companyId, this.client.password, this.client.name, this.client.email);
//     }
//     if (this.client.customerId != null) {
//       this.cust = new Customer(this.client.customerId, this.client.password, this.client.email,
//         this.client.firstName, this.client.lastName, []);
//     }
//
//     if (this.comp != null) {
//       this.compForm = this.fb.group({
//         password: [this.comp.$password, Validators.required],
//         email: [this.comp.$email, [Validators.required, Validators.email]],
//         name: [this.comp.$name, Validators.required],
//       });
//     }
//     if (this.cust != null) {
//       this.custForm = this.fb.group({
//         firstName: [this.cust.$firstName],
//         lastName: [this.cust.$lastName],
//         password: [this.cust.$password, [Validators.required]],
//         email: [this.cust.$email, [Validators.required, Validators.email]]
//       });
//     }
//   }
//
//   closeDialog() {
//     this.dialogRef.close();
//   }
//
//   errPopup(e: string) {
//     this.glob.errPopup(e);
//   }
//
//   update(type: ClientType) {
//     this.updateClients();
//     if (type === ClientType.Company) {
//       this.updateCompany(this.comp);
//     }
//     if (type === ClientType.Customer) {
//       this.updateCustomer(this.cust);
//     }
//   }
//
//   updateClients() {
//     if (this.comp != null) {
//       if (this.compForm.valid) {
//         this.comp.$name = this.compForm.controls.name.value;
//         this.comp.$email = this.compForm.controls.email.value;
//         this.comp.$password = this.compForm.controls.password.value;
//       }
//     }
//   }
//   updateCompany(comp: Company) {
//     this.cont.updateCompany(sessionStorage.getItem('token'), comp).subscribe(
//       () => this.closeDialog(),
//       e => this.errPopup(e));
//   }
//
//
//
//   deleteCompany(companyId: number) {
//     this.cont.deleteCompany(sessionStorage.getItem('token'), companyId).subscribe(
//       () => this.closeDialog(),
//       e => this.errPopup(e));
//   }
//   addCompany() {
//     this.updateClients();
//     this.cont.addCompany(sessionStorage.getItem('token'), this.comp).subscribe(
//       () => this.closeDialog(),
//       e => this.errPopup(e.error));
//   }
// }

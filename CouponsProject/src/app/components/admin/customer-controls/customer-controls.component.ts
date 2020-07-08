import { Customer } from './../../../models/customer';
import { Company } from './../../../models/company';
import { ErrorBoxComponent } from './../../error-box/error-box.component';
import { TableComponent } from '../../table/table.component';
import { AdminControllerService } from './../../../services/admin-controller.service';
import { Component, OnInit } from '@angular/core';
import { ColumnMode } from '@swimlane/ngx-datatable';
import { MatDialog } from '@angular/material/dialog';


@Component({
  selector: 'app-customer-controls',
  templateUrl: './customer-controls.component.html',
  styleUrls: ['./customer-controls.component.css']
})
export class CustomerControlsComponent implements OnInit {

  constructor(private cont: AdminControllerService, private table: TableComponent, private dialog: MatDialog) { }
  err
  ColumnMode = ColumnMode;
  token: String;
  rows;
  columns;
  custColNames = [{ prop: 'firstName' }, { prop: 'lastName' }, { prop: 'email' }, { prop: 'password' }];
  compColNames = [{ prop: 'name' }, { prop: 'email' }, { prop: 'password' }];

  ngOnInit(): void {
    console.log("test123")
    this.token = localStorage.getItem("token");
  }
  errPopup(err: String) {
    this.dialog.open(ErrorBoxComponent,
      {
        minHeight: 200, minWidth: 200, disableClose: false,
        data: { err: err }
      })
  }

  getAllCustomers() {
    this.columns = this.custColNames;
    this.cont.getAllCustomers(localStorage.getItem("token")).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }
  getAllCompanies() {
    this.columns = this.compColNames;
    this.cont.getAllCompanies(localStorage.getItem("token")).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }

  getOneCustomer(cust: Customer) {
    this.columns = this.custColNames;
    this.cont.getOneCustomer(localStorage.getItem("token"), cust).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }
  getOneCompany(comp: Company) {
    this.columns = this.compColNames;
    this.cont.getOneCompany(localStorage.getItem("token"), comp).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }
  addCustomer(cust: Customer) {
    this.cont.addCustomer(localStorage.getItem("token"), cust).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }
  addCompany(comp: Company) {
    this.cont.addCompany(localStorage.getItem("token"), comp).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }
  updateCustomer(cust: Customer) {
    this.cont.updateCustomer(localStorage.getItem("token"), cust).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }
  updateCompany(comp: Company) {
    this.cont.updateCompany(localStorage.getItem("token"), comp).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }
  deleteCustomer(cust: Customer) {
    this.cont.deleteCustomer(localStorage.getItem("token"), cust).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }
  deleteCompany(comp: Company) {
    this.cont.deleteCompany(localStorage.getItem("token"), comp).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }
  updateTable(s: Object) {
    this.rows = s;
    this.rows = [...this.rows];
  }
}


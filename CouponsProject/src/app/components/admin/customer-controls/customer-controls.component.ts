import { ClientInfoPopupComponent } from './../../client-info-popup/client-info-popup.component';
import { Customer } from './../../../models/customer';
import { Company } from './../../../models/company';
import { ErrorBoxComponent } from './../../error-box/error-box.component';
import { TableComponent } from '../../table/table.component';
import { AdminControllerService } from './../../../services/admin-controller.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { ColumnMode, SelectionType } from '@swimlane/ngx-datatable';

import { MatDialog } from '@angular/material/dialog';


@Component({
  selector: 'app-customer-controls',
  templateUrl: './customer-controls.component.html',
  styleUrls: ['./customer-controls.component.css']
})
export class CustomerControlsComponent implements OnInit {
  @ViewChild(CustomerControlsComponent) filterTable: CustomerControlsComponent;

  constructor(private cont: AdminControllerService, private table: TableComponent, private dialog: MatDialog) { }
  err;
  selectedRow = [];
  SelectionType = SelectionType;
  ColumnMode = ColumnMode;
  token: String;
  rows;
  beforeSearch = null;
  columns;
  queryLength: number = 0;
  custColNames = [{ prop: 'customerId' }, { prop: 'firstName' }, { prop: 'lastName' }, { prop: 'email' }, { prop: 'password' }];
  compColNames = [{ prop: 'companyId' }, { prop: 'name' }, { prop: 'email' }, { prop: 'password' }];

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
  clientPopup() {
    this.dialog.open(ClientInfoPopupComponent,
      {
        minHeight: 200, minWidth: 200, disableClose: false,
        data: {}
      })
  }
  resetTable(){
    if(this.beforeSearch == null)
      return;
    this.rows = this.beforeSearch;
    this.rows = [...this.rows];
    this.beforeSearch = null;
    this.selectedRow = [];
  }
  updateFilter(event) {
    // get the value of the key pressed and make it lowercase
    let val = event.target.value.toLowerCase();
    // get the amount of columns in the table
    let colsAmt = this.columns.length;
    // get the key names of each column in the dataset
    let keys = Object.keys(this.rows[0]);
    // assign filtered matches to the active datatable
    if (this.beforeSearch == null) {
      this.beforeSearch = this.rows;
    }
    this.rows = this.rows.filter(function (item) {
      // iterate through each row's column data
      for (let i = 0; i < colsAmt; i++) {
        // check for a match
        if (item[keys[i]].toString().toLowerCase().indexOf(val) !== -1 || !val) {
          console.log(item)
          return true;
        }
      }
    });

  }
  onSelect({ selected }) {
    console.log('Select Event', selected, this.selectedRow);
  }
  onActivate(event) {
    console.log('Activate Event', event);
  }
  updateTable(s: Object) {
    this.rows = s;
    this.rows = [...this.rows];
    this.selectedRow = [];
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
  getOneCustomer(id: number) {
    this.columns = this.custColNames;
    this.cont.getOneCustomer(localStorage.getItem("token"), id).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }
  getOneCompany(id: number) {
    this.columns = this.compColNames;
    this.cont.getOneCompany(localStorage.getItem("token"), id).
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
}
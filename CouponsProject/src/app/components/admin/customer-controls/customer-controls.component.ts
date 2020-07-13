import { ClientType } from 'src/app/enums/client-type.enum';
import { ClientInfoPopupComponent } from './../../client-info-popup/client-info-popup.component';
import { Customer } from './../../../models/customer';
import { Company } from './../../../models/company';
import { ErrorBoxComponent } from './../../error-box/error-box.component';
import { TableComponent } from '../../table/table.component';
import { AdminControllerService } from './../../../services/admin-controller.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { ColumnMode, SelectionType } from '@swimlane/ngx-datatable';


import { MatDialog } from '@angular/material/dialog';

// TODO fix and improve this entire component and its html. its poorly written and poorly structered
@Component({
  selector: 'app-customer-controls',
  templateUrl: './customer-controls.component.html',
  styleUrls: ['./customer-controls.component.css']
})
export class CustomerControlsComponent implements OnInit {
  @ViewChild(CustomerControlsComponent) filterTable: CustomerControlsComponent;

  constructor(private cont: AdminControllerService, private table: TableComponent, private dialog: MatDialog) { }
  // general logic stuff
  lastAction: ClientType;
  beforeSearch: any;
  token: string;

  // data table stuff
  columns: string | any[];
  SelectionType = SelectionType;
  ColumnMode = ColumnMode;
  selectedRow = [];
  custColNames = [{ prop: 'customerId' }, { prop: 'firstName' }, { prop: 'lastName' }, { prop: 'email' }, { prop: 'password' }];
  compColNames = [{ prop: 'companyId' }, { prop: 'name' }, { prop: 'email' }, { prop: 'password' }];
  rows;
  // particles stuff
  myStyle: object = {};
  myParams: object = {};
  width: number = 100;
  height: number = 100;

  ngOnInit(): void {
    this.token = localStorage.getItem("token");
    this.myStyle = {
      'position': 'fixed',
      'width': '100%',
      'height': '100%',
      'z-index': -1,
      'top': 0,
      'left': 0,
      'right': 0,
      'bottom': 0,
    };

    this.myParams = {
      particles: {
        number: {
          value: 200,
        },
        color: {
          value: '#ff0000'
        },
        shape: {
          type: 'triangle',
        },
      }
    };
  }
  errPopup(err: string) {
    this.dialog.open(ErrorBoxComponent,
      {
        minHeight: 200, minWidth: 200, disableClose: false,
        maxHeight: 400, maxWidth: 600,
        data: { err: err }
      })
  }
  clientPopup() {
    let row = this.selectedRow;
    this.dialog.open(ClientInfoPopupComponent,
      {
        minHeight: 400, minWidth: 400, disableClose: false,
        data: row[0]
      })

    this.dialog.afterAllClosed.subscribe(
      s => this.lastAction == ClientType.Customer ? this.getAllCustomers() : this.getAllCompanies()
    )
  }
  resetTable() {
    if (this.beforeSearch == null)
      return;
    this.rows = this.beforeSearch;
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
        if (item[keys[i]] == null)
          return false;
        // check for a match - how? magic!
        if (item[keys[i]].toString().toLowerCase().indexOf(val) !== -1 || !val)
          return true;
      }
    });

  }
  updateTable(s: Object) {
    this.rows = s;
    this.rows = [...this.rows];
    this.selectedRow = [];
  }
  getAllCustomers() {
    this.lastAction = ClientType.Customer
    this.columns = this.custColNames;
    this.cont.getAllCustomers(localStorage.getItem("token")).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }
  getAllCompanies() {
    this.lastAction = ClientType.Company
    this.columns = this.compColNames;
    this.cont.getAllCompanies(localStorage.getItem("token")).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }
  getOneCustomer(customerId: number) {
    this.columns = this.custColNames;
    this.cont.getOneCustomer(localStorage.getItem("token"), customerId).
      subscribe(
        s => this.updateTable(s),
        e => this.errPopup(e.error))
  }
  getOneCompany(customerId: number) {
    this.columns = this.compColNames;
    this.cont.getOneCompany(localStorage.getItem("token"), customerId).
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
}
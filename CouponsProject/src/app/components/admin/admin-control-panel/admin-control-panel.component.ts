import {TableComponent} from '../../table/table.component';
import {AdminControllerService} from '../../../services/admin-controller.service';
import {Component, OnInit, ViewChild} from '@angular/core';
import {ColumnMode, SelectionType} from '@swimlane/ngx-datatable';
import {MatDialog} from '@angular/material/dialog';
import {GlobalService} from '../../../services/global.service';
import {CustomerAddUpdateDeleteComponent} from '../customer-add-update-delete/customer-add-update-delete.component';
import {CompanyAddUpdateDeleteComponent} from '../company-add-update-delete/company-add-update-delete.component';

// TODO fix and improve this entire component and its html. its poorly written and poorly structered
@Component({
  selector: 'app-customer-controls',
  templateUrl: './admin-control-panel.component.html',
  styleUrls: ['./admin-control-panel.component.css']
})
export class AdminControlPanel implements OnInit {
  @ViewChild(AdminControlPanel) filterTable: AdminControlPanel;
  // sidenav stuff
  events: string[] = [];
  opened: boolean;
  // logic stuff
  beforeSearch: any;
  token: string;

  // data table stuff
  columns: string | any[];
  SelectionType = SelectionType;
  ColumnMode = ColumnMode;
  selectedRow = [];
  custColNames = [{prop: 'customerId'}, {prop: 'firstName'}, {prop: 'lastName'}, {prop: 'email'}, {prop: 'password'}];
  compColNames = [{prop: 'companyId'}, {prop: 'name'}, {prop: 'email'}, {prop: 'password'}];
  isCompany = false;
  rows;

  constructor(private cont: AdminControllerService, private table: TableComponent, private dialog: MatDialog, private glob: GlobalService) {
  }

// TODO improve and finalize (cust/comp add + success popup / icon)
  ngOnInit(): void {
    this.token = sessionStorage.getItem('token');
  }

  errPopup(e: string) {
    this.glob.errPopup(e);
  }
  companyAddPopup(){
    this.selectedRow = [{add:true}];
    this.customerPopup();
  }
  customerAddPopup(){
    this.selectedRow = [{add:true}];
    this.customerPopup();
  }
  customerPopup() {
    console.log(this.selectedRow)
    this.dialog.open(CustomerAddUpdateDeleteComponent,
      {
        minHeight: 400, minWidth: 400, disableClose: false,
        data: this.selectedRow[0]
      });

    this.dialog.afterAllClosed.subscribe(
      () => this.getAllCustomers()
    );
  }

  companyPopup() {
    this.dialog.open(CompanyAddUpdateDeleteComponent,
      {
        minHeight: 400, minWidth: 400, disableClose: false,
        data: this.selectedRow[0]
      });

    this.dialog.afterAllClosed.subscribe(
      () => this.getAllCompanies()
    );
  }

  resetTable() {
    if (this.beforeSearch == null) {
      return;
    }
    this.rows = this.beforeSearch;
    this.beforeSearch = null;
    this.selectedRow = [];
  }

  // TODO make this work globally with GlobalService so its easier to share across components
  // TODO improve by allowing user to delete chars from query and get previous
  // O(n)
  updateFilter(event) {
    // get the value of the key pressed and make it lowercase
    const val = event.target.value.toLowerCase();
    // get the amount of columns in the table
    const colsAmt = this.columns.length;
    // get the key names of each column in the dataset
    const keys = Object.keys(this.rows[0]);
    // assign filtered matches to the active datatable
    if (this.beforeSearch == null) {
      this.beforeSearch = this.rows;
    }
    this.rows = this.rows.filter(item => {
      // iterate through each row's column data
      for (let i = 0; i < colsAmt; i++) {
        if (item[keys[i]] == null) {
          return false;
        }
        // check for a match - how? magic!
        if (item[keys[i]].toString().toLowerCase().indexOf(val) !== -1 || !val) {
          return true;
        }
      }
    });
  }

  updateTable(s: object) {
    this.rows = s;
    this.rows = [...this.rows];
    this.selectedRow = [];
  }

  getAllCustomers() {
    this.columns = this.custColNames;
    this.cont.getAllCustomers(sessionStorage.getItem('token')).subscribe(
      s => {
        this.updateTable(s);
        this.isCompany = false;
      },
      e => this.errPopup(e.error));
  }

  getAllCompanies() {
    this.columns = this.compColNames;
    this.cont.getAllCompanies(sessionStorage.getItem('token')).subscribe(
      s => {
        this.updateTable(s);
        this.isCompany = true;
      },
      e => this.errPopup(e.error));
  }

  // getOneCustomer(customerId: number) {
  //   this.columns = this.custColNames;
  //   this.cont.getOneCustomer(sessionStorage.getItem('token'), customerId).subscribe(
  //     s => this.updateTable(s),
  //     e => this.errPopup(e.error));
  // }
  //
  // getOneCompany(customerId: number) {
  //   this.columns = this.compColNames;
  //   this.cont.getOneCompany(sessionStorage.getItem('token'), customerId).subscribe(
  //     s => this.updateTable(s),
  //     e => this.errPopup(e.error));
  // }
}

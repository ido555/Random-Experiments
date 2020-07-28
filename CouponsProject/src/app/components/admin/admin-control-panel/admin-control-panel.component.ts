import {AdminControllerService} from '../../../services/admin-controller.service';
import {Component, OnInit, ViewChild} from '@angular/core';
import {ColumnMode, SelectionType} from '@swimlane/ngx-datatable';
import {MatDialog} from '@angular/material/dialog';
import {GlobalService} from '../../../services/global.service';
import {CustomerAddUpdateDeleteComponent} from '../customer-add-update-delete/customer-add-update-delete.component';
import {CompanyAddUpdateDeleteComponent} from '../company-add-update-delete/company-add-update-delete.component';
import {fromEvent} from 'rxjs';
import {debounceTime, map} from 'rxjs/operators';

@Component({
  selector: 'app-admin-control-panel',
  templateUrl: './admin-control-panel.component.html',
  styleUrls: ['./admin-control-panel.component.css']
})
export class AdminControlPanel implements OnInit {
  @ViewChild('search', {static: false}) search;
  // sidenav stuff
  events: string[] = [];
  opened: boolean;
  // logic stuff
  beforeSearch: any;
  token: string;
  // data table stuff
  columns;
  rows;
  temp;
  SelectionType = SelectionType;
  ColumnMode = ColumnMode;
  selectedRow = [];
  custColNames = [{prop: 'customerId'}, {prop: 'firstName'}, {prop: 'lastName'}, {prop: 'email'}, {prop: 'password'}];
  compColNames = [{prop: 'companyId'}, {prop: 'name'}, {prop: 'email'}, {prop: 'password'}];
  isCompany = false;

  constructor(private cont: AdminControllerService, private dialog: MatDialog, private glob: GlobalService) {
  }

  ngOnInit(): void {
    this.token = sessionStorage.getItem('token');
  }

  prepSearch() {
    setTimeout(() => {
      this.temp = this.rows;
      fromEvent(this.search.nativeElement, 'keydown')
        .pipe(
          debounceTime(200),
          map(x => x['target']['value'])
        )
        .subscribe(value => {
          this.updateFilter(value);
        });
    }, 1000);

  }

  updateFilter(val: any) {
    const value = val.toString().toLowerCase().trim();
    // get the amount of columns in the table
    const count = this.columns.length;
    // get the key names of each column in the dataset
    const keys = Object.keys(this.temp[0]);
    // assign filtered matches to the active datatable
    this.rows = this.temp.filter(item => {
      // iterate through each row's column data
      for (let i = 0; i < count; i++) {
        // check for a match
        if (
          (item[keys[i]] &&
            item[keys[i]]
              .toString()
              .toLowerCase()
              .indexOf(value) !== -1) ||
          !value
        ) {
          // found match, return true to add to result set
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

  errPopup(e: string) {
    this.glob.errPopup(e);
  }

  companyAddPopup() {
    this.selectedRow = [{add: true}];
    this.companyPopup();
  }

  customerAddPopup() {
    this.selectedRow = [{add: true}];
    this.customerPopup();
  }

  customerPopup() {
    console.log(this.selectedRow);
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


  getAllCustomers() {
    this.columns = this.custColNames;
    this.cont.getAllCustomers(sessionStorage.getItem('token')).subscribe(
      s => {
        this.updateTable(s);
        this.prepSearch();
        this.isCompany = false;
      },
      e => this.errPopup(e.error));
  }

  getAllCompanies() {
    this.columns = this.compColNames;
    this.cont.getAllCompanies(sessionStorage.getItem('token')).subscribe(
      s => {
        this.updateTable(s);
        this.prepSearch();
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

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
  openDialog() {
    this.dialog.open(ErrorBoxComponent,
      {
        minHeight: 200, minWidth: 200, disableClose: false,
        data: { err: "Error 123 has occured" }
      })
  }

  getAllCustomers() {
    this.columns = this.custColNames;
    this.cont.getAllCustomers(localStorage.getItem("token")).
      subscribe(
        s => this.updateTable(s),
        e => console.log(e))
  }
  getAllCompanies() {
    this.columns = this.compColNames;
    this.cont.getAllCompanies(localStorage.getItem("token")).
      subscribe(
        s => this.updateTable(s),
        e => console.log(e))
  }
  updateTable(s: Object) {
    this.rows = s;
    this.rows = [...this.rows];
    console.log(s)
  }
}


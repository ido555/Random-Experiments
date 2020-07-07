import { TableComponent } from '../../table/table.component';
import { AdminControllerService } from './../../../services/admin-controller.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-controls',
  templateUrl: './customer-controls.component.html',
  styleUrls: ['./customer-controls.component.css']
})
export class CustomerControlsComponent implements OnInit {

  constructor(private cont: AdminControllerService, private table: TableComponent) { }
  token: String;
  rows;
  columns = [{ prop: 'firstName' }, { name: 'lastName' }, { name: 'email' }, { name: 'password' }];

  ngOnInit(): void {
    console.log("test123")
    this.token = localStorage.getItem("token");
  }
  getAllCustomers() {
    this.cont.getAllCustomers(localStorage.getItem("token")).
      subscribe(
        s => this.update(s),
        e => console.log(e))
  }
  update(s: Object) {
    this.rows = s;
    this.rows = [...this.rows];
    console.log(s)
  }
}


import {AdminControllerService} from '../../services/admin-controller.service';
import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  rows;
  columns = [{prop: 'firstName'}, {name: 'lastName'}, {name: 'email'}, {name: 'password'}];

  constructor(private adminController: AdminControllerService) {
  }

  ngOnInit(): void {

  }

  go() {
    this.adminController.getAllCustomers(localStorage.getItem('token')).subscribe(
      s => this.update(s),
      e => console.log(e));
  }

  update(s: object) {
    this.rows = s;
    this.rows = [...this.rows];
    console.log(s);
  }
}

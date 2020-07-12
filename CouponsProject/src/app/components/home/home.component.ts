import { LoginBoxComponent } from './../login-box/login-box.component';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private loginBox:MatDialog) { }

  ngOnInit(): void {
  }
  showDialog() {
    this.loginBox.open(LoginBoxComponent, { minHeight: 200, minWidth: 200, disableClose: false });
  }
}

import {LoginBoxComponent} from '../login-box/login-box.component';
import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {GlobalService} from '../../services/global.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private loginBox: MatDialog, public glob:GlobalService) {
  }

  ngOnInit(): void {

  }

  showDialog() {
   this.loginBox.open(LoginBoxComponent,
      {minHeight: 200, minWidth: 200, disableClose: false});
    this.loginBox.afterAllClosed.subscribe()

  }
}

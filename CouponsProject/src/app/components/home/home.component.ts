import {LoginBoxComponent} from '../login-box/login-box.component';
import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {GlobalService} from '../../services/global.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private loginBox: MatDialog, private glob:GlobalService) {
  }

  ngOnInit(): void {
    // this.globalClientType
  }

  showDialog() {
   this.loginBox.open(LoginBoxComponent,
      {minHeight: 200, minWidth: 200, disableClose: false});
    // dialogRef.afterClosed().subscribe(
    //   s => console.log(s)
    // );

  }
}

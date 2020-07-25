import {Component, OnInit} from '@angular/core';
import {LoginControllerService} from '../../services/login-controller.service';
import {GlobalService} from '../../services/global.service';
import {MatDialog} from '@angular/material/dialog';
import {CustomerDetailsComponent} from '../customer/customer-details/customer-details.component';
import {CompanyDetailsComponent} from '../company/company-details/company-details.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private logMan: LoginControllerService, public glob: GlobalService, private clientDetails: MatDialog) {
  }

  ngOnInit(): void {

  }
  custDetails() {
    this.clientDetails.open(CustomerDetailsComponent,
      {
        minHeight: 200, minWidth: 200, disableClose: false,
        maxHeight: 400, maxWidth: 600,
      });
  }
  compDetails() {
    this.clientDetails.open(CompanyDetailsComponent,
      {
        minHeight: 200, minWidth: 200, disableClose: false,
        maxHeight: 400, maxWidth: 600,
      });
  }

  public logOut() {
    console.log(this.logMan);
    this.logMan.logout(sessionStorage.getItem('token')).subscribe(
      () => {
        sessionStorage.removeItem('token');
        sessionStorage.removeItem('ct');
      },
      e => console.log(e)
    );
  }
}

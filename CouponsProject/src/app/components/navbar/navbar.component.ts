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
        minHeight: 600, minWidth: 480, disableClose: false,
        maxHeight: 1200, maxWidth: 960,
      });
  }
  compDetails() {
    this.clientDetails.open(CompanyDetailsComponent,
      {
        minHeight: 500, minWidth: 400, disableClose: false,
        maxHeight: 1200, maxWidth: 960,
      });
  }

  public logOut() {
    console.log(this.logMan);
    this.logMan.logout(sessionStorage.getItem('token')).subscribe(
      () => {
        sessionStorage.removeItem('token');
        sessionStorage.removeItem('ct');
        setTimeout(() => {this.glob.navigateClientHome()} , 150)
      },
      e => console.log(e)
    );
  }
}

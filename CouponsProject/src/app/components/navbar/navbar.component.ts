import { Component, OnInit } from '@angular/core';
import {LoginControllerService} from '../../services/login-controller.service';
import {GlobalService} from '../../services/global.service';
import {AdminControllerService} from '../../services/admin-controller.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  clientType: String;

  constructor(private logMan: LoginControllerService, private glob: GlobalService) { }

  ngOnInit(): void {
    setInterval(() => console.log(this.glob), 1000)
    console.log(this.glob.getClientType())
    console.log(this.logMan)
  }

  public isLogged() {
    return localStorage.getItem('token') != null;
  }

  public logOut() {
    localStorage.removeItem('token');
    this.logMan.logout(localStorage.getItem('token')).subscribe(
      () => {

      },
      () => {
      }
    );
  }
}

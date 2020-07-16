import {LoginControllerService} from '../../services/login-controller.service';
import {Component, OnInit} from '@angular/core';

// TODO fix and improve this entire component and its html. its poorly written and poorly structured
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private logMan: LoginControllerService) {
  }

  ngOnInit(): void {
  }

  public isLogged() {
    return localStorage.getItem('token') != null;

  }

  public logOut() {
    this.logMan.logout(localStorage.getItem('token')).subscribe(
      () => {
        localStorage.removeItem('token');
      },
      () => {
      }
    );
  }
}

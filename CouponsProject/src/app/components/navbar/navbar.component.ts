import { LoginControllerService } from './../../services/login-controller.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private logMan:LoginControllerService) { }

  ngOnInit(): void {
  }
  public isLogged(){
    if (localStorage.getItem('token') != null ) 
      return true
    return false
  }
  public logOut(){
    console.log("tryna logout")
    this.logMan.logout(localStorage.getItem('token')).subscribe(
      s => {localStorage.removeItem('token')},
      e => {}
    );
  }
}
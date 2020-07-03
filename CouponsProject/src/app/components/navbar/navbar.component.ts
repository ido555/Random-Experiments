import { Component, OnInit } from '@angular/core';



@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedIn:boolean;

  constructor() { }

  ngOnInit(): void {
    this.isLoggedIn = true;
  }
  public flipBool(){
    this.isLoggedIn = !this.isLoggedIn;
  }
}

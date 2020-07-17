import {Component, OnInit} from '@angular/core';
import {LoginControllerService} from '../../services/login-controller.service';
import {GlobalService} from '../../services/global.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  clientType: String;

  constructor(private logMan: LoginControllerService, private glob: GlobalService) {
  }

  ngOnInit(): void {
    setInterval(() => console.log(this.glob.getClientType()), 1000);
  }

  public logOut() {
    console.log(this.logMan)
    // TODO figure out why when i use .subscribe() to only clear sessionStorage after the server deletes its token
    // it doesnt remove items from storage?
    this.logMan.logout(sessionStorage.getItem('token')).subscribe(
      () => {
        sessionStorage.removeItem('token');
        sessionStorage.removeItem('ct');
      },
      e => console.log(e)
    );
  }
}

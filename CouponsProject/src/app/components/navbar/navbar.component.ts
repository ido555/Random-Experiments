import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {LoginControllerService} from '../../services/login-controller.service';
import {GlobalService} from '../../services/global.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  clientType: String;

  constructor(private logMan: LoginControllerService, public glob: GlobalService, private changeDecRef: ChangeDetectorRef) {
  }

  ngOnInit(): void {
    // had to use ChangeDetectorRef here to since some *NgIf conditions weren't updating
    // TODO changeRef didnt work, stackoverflow says this.ngoninit() will reload entire component

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

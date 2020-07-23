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
  isLogged : boolean = this.glob.isLogged();

  constructor(private logMan: LoginControllerService, public glob: GlobalService, private changeDecRef: ChangeDetectorRef) {
  }

  ngOnInit(): void {
    // had do this since some *NgIf conditions weren't updating
    setInterval(this.updateIf , 1000)
  }
  updateIf(){
    if (this.glob.isLogged())
      this.isLogged = true;
    this.isLogged = false;
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

import {Injectable} from '@angular/core';
import {ErrorBoxComponent} from '../components/error-box/error-box.component';
import {MatDialog} from '@angular/material/dialog';
import {Router} from '@angular/router';
import {Coupon} from '../models/coupon';

// singleton shared across angular project
@Injectable({
  providedIn: 'root'
})
export class GlobalService {
  constructor(private dialog: MatDialog, private router: Router) {
  }
  initCoupons(couponsObject): Array<Coupon>{
    let temp = couponsObject;
    let coupons = new Array<Coupon>();
    for (let i = 0; i < temp.length; i++) {
      let tempCoup = temp[i];
      let c:Coupon = new Coupon(tempCoup.couponId, tempCoup.amount, tempCoup.price, tempCoup.title, tempCoup.description,
        tempCoup.image, tempCoup.startDate, tempCoup.endDate, tempCoup.category, tempCoup.company);
      coupons.push(c);
    }
    console.log(coupons)
    return coupons;
  }
  navigateClientHome() {
    let type = this.getClientType();
    switch (type) {
      case 'Administrator':
        this.router.navigateByUrl('/adminControlPanel');
        break;
      case 'Company':
        this.router.navigateByUrl('/companyControlPanel');
        break;
      case 'Customer':
        this.router.navigateByUrl('/customerPage');
        break;
      default:
        this.router.navigateByUrl('/home');
        break;
    }
  }
  public isLogged() {
    return sessionStorage.getItem('token') != null;
  }

  public getToken() {
    return sessionStorage.getItem("token");
  }

  public getClientType() {
    return sessionStorage.getItem("ct");
  }

  public setClientType(ct: string) {
    sessionStorage.setItem("ct" , ct);
  }
  errPopup(err: string) {
    this.dialog.open(ErrorBoxComponent,
      {
        minHeight: 400, minWidth: 300, disableClose: false,
        maxHeight: 400, maxWidth: 600,
        data: {err}
      });
  }
}

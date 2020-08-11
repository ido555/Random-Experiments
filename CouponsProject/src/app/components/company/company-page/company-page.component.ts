import {Component, OnInit, ViewChild} from '@angular/core';
import {CompanyControllerService} from '../../../services/company-controller.service';
import {MatDialog} from '@angular/material/dialog';
import {GlobalService} from '../../../services/global.service';
import {ErrorBoxComponent} from '../../error-box/error-box.component';
import {ColumnMode, SelectionType} from '@swimlane/ngx-datatable';
import {CouponCategory} from '../../../enums/coupon-category.enum';
import {CouponAddUpdateDeleteComponent} from '../coupon-add-update-delete/coupon-add-update-delete.component';
import {fromEvent} from 'rxjs';
import {debounceTime, map} from 'rxjs/operators';


@Component({
  selector: 'app-company-page',
  templateUrl: './company-page.component.html',
  styleUrls: ['./company-page.component.css']
})
export class CompanyPageComponent implements OnInit {
  @ViewChild('search', {static: false}) search;
  // sidenav stuff
  events: string[] = [];
  opened: boolean;
  // logic stuff
  beforeSearch: any;
  token: string;
  // data table stuff
  rows;
  temp;
  columns = [{prop: 'amount'}, {prop: 'price'}, {prop: 'title'}, {prop: 'description'}, {prop: 'image'}, {prop: 'startDate'}, {prop: 'endDate'}, {prop: 'category'}];
  SelectionType = SelectionType;
  ColumnMode = ColumnMode;
  selectedRow = [];

  constructor(private cont: CompanyControllerService, private dialog: MatDialog, private glob: GlobalService) {
  }

  ngOnInit(): void {
    this.token = this.glob.getToken();
  }


  prepSearch() {
    setTimeout(() => {
      console.log(this.search);
      this.temp = this.rows;
      fromEvent(this.search.nativeElement, 'keydown')
        .pipe(
          debounceTime(200),
          map(x => x['target']['value'])
        )
        .subscribe(value => {
          this.updateFilter(value);
        });
    }, 1000);

  }

  updateFilter(val: any) {
    const value = val.toString().toLowerCase().trim();
    // get the amount of columns in the table
    const count = this.columns.length;
    // get the key names of each column in the dataset
    const keys = Object.keys(this.temp[0]);
    // assign filtered matches to the active datatable
    this.rows = this.temp.filter(item => {
      // iterate through each row's column data
      for (let i = 0; i < count; i++) {
        // check for a match
        if (
          (item[keys[i]] &&
            item[keys[i]]
              .toString()
              .toLowerCase()
              .indexOf(value) !== -1) ||
          !value
        ) {
          // found match, return true to add to result set
          return true;
        }
      }
    });
  }

  updateTable(s: object) {
    this.rows = s;
    this.rows = [...this.rows];
    this.selectedRow = [];
  }

  couponAdd() {
    this.dialog.open(CouponAddUpdateDeleteComponent,
      {
        minHeight: 400, minWidth: 400, disableClose: false,
        data: {add: true}
      });
  }
  couponPopup() {
    const row = this.selectedRow;
    this.dialog.open(CouponAddUpdateDeleteComponent,
      {
        minHeight: 400, minWidth: 400, disableClose: false,
        data: row[0]
      });

    this.dialog.afterAllClosed.subscribe(
      () => this.getAllCoupons()
    )
  }

  getAllCoupons() {
    this.prepSearch()
    this.cont.getAllCoupons(this.token).subscribe(
      s => this.updateTable(s),
      e => this.glob.errPopup(e.error));
  };
  getCouponsUnderPrice(maxPrice: number) {
    this.cont.getCouponsUnderPrice(this.token, maxPrice).subscribe(
      s => this.updateTable(s),
      e => this.glob.errPopup(e.error));
  }

  getCouponsByCategory(c: CouponCategory) {
    this.cont.getCouponsByCategory(this.token, c).subscribe(
      s => this.updateTable(s),
      e => this.glob.errPopup(e.error));
  }
}

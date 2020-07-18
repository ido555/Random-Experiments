import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {AdminControllerService} from '../../../services/admin-controller.service';
import {FormBuilder} from '@angular/forms';
import {Coupon} from '../../../models/coupon';
import {ErrorBoxComponent} from '../../error-box/error-box.component';
import {GlobalService} from '../../../services/global.service';

@Component({
  selector: 'app-coupon-update-delete',
  templateUrl: './coupon-update-delete.component.html',
  styleUrls: ['./coupon-update-delete.component.css']
})
export class CouponUpdateDeleteComponent implements OnInit {
  token: String;

  constructor(private dialogRef: MatDialogRef<CouponUpdateDeleteComponent>, @Inject(MAT_DIALOG_DATA) public data,
              private cont: AdminControllerService , private fb: FormBuilder, public glob:GlobalService) {
  }

  ngOnInit(): void {
    this.token = sessionStorage.getItem('token');
  }

  closeDialog() {
    this.dialogRef.close();
  }

  addCoupon(coup: Coupon) {
    this.cont.addCoupon(this.token, coup).subscribe(
      s => this.updateTable(s),
      e => this.errPopup(e.error));
  }
  errPopup(e: String){
    this.glob.errPopup(e);
  }
  updateCoupon(coup: Coupon) {
    this.cont.updateCoupon(this.token, coup).subscribe(
      s => this.updateTable(s),
      e => this.errPopup(e.error));
  }
}

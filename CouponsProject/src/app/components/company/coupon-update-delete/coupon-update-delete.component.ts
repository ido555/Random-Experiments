import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Coupon} from '../../../models/coupon';
import {GlobalService} from '../../../services/global.service';
import {CompanyControllerService} from '../../../services/company-controller.service';

@Component({
  selector: 'app-coupon-update-delete',
  templateUrl: './coupon-update-delete.component.html',
  styleUrls: ['./coupon-update-delete.component.css']
})
export class CouponUpdateDeleteComponent implements OnInit {
  token: string;
  coupForm: FormGroup;
  coup: Coupon;

  constructor(private dialogRef: MatDialogRef<CouponUpdateDeleteComponent>, @Inject(MAT_DIALOG_DATA) public data,
              private cont: CompanyControllerService, private fb: FormBuilder, public glob: GlobalService) {
  }

  ngOnInit(): void {
    this.token = sessionStorage.getItem('token');
    this.coup = new Coupon(this.data.couponId, this.data.amount, this.data.price, this.data.title, this.data.description,
      this.data.image, this.data.startDate, this.data.endDate, this.data.couponCategory);
    console.log(this.coup);
    // this.compForm = this.fb.group({
    //   password: [this.comp.$password, Validators.required],
    //   email: [this.comp.$email, [Validators.required, Validators.email]],
    //   name: [this.comp.$name, Validators.required],
    // });
  }

  closeDialog() {
    this.dialogRef.close();
  }

  errPopup(e: string) {
    this.glob.errPopup(e);
  }

  addCoupon(coup: Coupon) {
    this.cont.addCoupon(this.token, coup).subscribe(
      s => this.updateTable(s),
      e => this.errPopup(e.error));
  }

  updateCoupon(coup: Coupon) {
    this.cont.updateCoupon(this.token, coup).subscribe(
      s => this.updateTable(s),
      e => this.errPopup(e.error));
  }
}

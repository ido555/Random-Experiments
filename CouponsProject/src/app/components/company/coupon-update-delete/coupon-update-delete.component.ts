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
    this.coup = new Coupon(this.data.$couponId, this.data.amount, this.data.price, this.data.title, this.data.description,
      this.data.image, this.data.startDate, this.data.endDate, this.data.category);
    console.log(this.coup.$amount);
    console.log(this.coup);
    this.coupForm = this.fb.group({
      amount: [this.coup.$amount, Validators.required],
      price: [this.coup.$price, Validators.required],
      title: [this.coup.$title, Validators.required],
      description: [this.coup.$description],
      image: [this.coup.$image],
      startDate: [this.coup.$startDate, [Validators.required]],
      endDate: [this.coup.$endDate, [Validators.required]],
      couponCategory: [this.coup.$category, Validators.required],
    });
  }

  refreshCoupon() {
    this.coup.$amount = this.coupForm.controls.amount.value;
    this.coup.$price = this.coupForm.controls.price.value;
    this.coup.$title = this.coupForm.controls.title.value;
    this.coup.$description = this.coupForm.controls.description.value;
    this.coup.$image = this.coupForm.controls.image.value;
    this.coup.$startDate = this.coupForm.controls.startDate.value.toString();
    this.coup.$endDate = this.coupForm.controls.endDate.value.toString();
    this.coup.$category = this.coupForm.controls.couponCategory.value;
  }

  closeDialog() {
    this.dialogRef.close();
  }

  errPopup(e: string) {
    this.glob.errPopup(e);
  }

  addCoupon(coup: Coupon) {
    this.cont.addCoupon(this.token, coup).subscribe(
      () => this.closeDialog(),
      e => this.errPopup(e.error));
  }

  deleteCoupon() {
    this.cont.deleteCoupon(this.token, this.coup.$couponId).subscribe(
      () => this.closeDialog(),
      e => this.errPopup(e.error));
  }

  updateCoupon() {
    this.refreshCoupon();
    this.cont.updateCoupon(this.token, this.coup).subscribe(
      () => this.closeDialog(),
      e => this.errPopup(e.error));
  }
}

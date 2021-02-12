import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {AdminControllerService} from '../../../services/admin-controller.service';
import {GlobalService} from '../../../services/global.service';
import {Company} from '../../../models/company';

@Component({
  selector: 'app-company-add-update-delete',
  templateUrl: './company-add-update-delete.component.html',
  styleUrls: ['./company-add-update-delete.component.css']
})
export class CompanyAddUpdateDeleteComponent implements OnInit {
  err: any;
  comp: Company;
  compForm: FormGroup;

  constructor(private dialogRef: MatDialogRef<CompanyAddUpdateDeleteComponent>, @Inject(MAT_DIALOG_DATA) public data,
              private cont: AdminControllerService, private dialog: MatDialog, private fb: FormBuilder, public glob: GlobalService) {
  }

  ngOnInit(): void {
    if (!this.data['add']) {
      this.comp = new Company(this.data.companyId, this.data.password, this.data.name, this.data.email);
      this.compForm = this.fb.group({
        name: [this.comp.$name, [Validators.required]],
        password: [this.comp.$password, [Validators.required]],
        email: [this.comp.$email, [Validators.required, Validators.email]]
      });
    } else {
      this.comp = new Company(0, '', '', '');
      this.compForm = this.fb.group({
        name: [''],
        password: ['', [Validators.required]],
        email: ['', [Validators.required, Validators.email]]
      });
    }
  }

  closeDialog() {
    this.dialogRef.close();
  }

  errPopup(e: string) {
    this.glob.errPopup(e);
  }

  refreshCompany() {
    this.comp.$name = this.compForm.controls.name.value;
    this.comp.$email = this.compForm.controls.email.value;
    this.comp.$password = this.compForm.controls.password.value;
  }

  addCompany() {
    this.refreshCompany();
    this.cont.addCompany(this.glob.getToken(), this.comp).subscribe(
      () => this.closeDialog(),
      e => this.errPopup(e.error));
  }

  updateCompany() {
    this.refreshCompany();
    this.cont.updateCompany(this.glob.getToken(), this.comp).subscribe(
      () => this.closeDialog(),
      e => this.errPopup(e));
  }

  deleteCompany() {
    this.cont.deleteCompany(this.glob.getToken(), this.comp.$companyId).subscribe(
      () => this.closeDialog(),
      e => this.errPopup(e));
  }
}

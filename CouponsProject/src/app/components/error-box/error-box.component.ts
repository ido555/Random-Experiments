import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-error-box',
  templateUrl: './error-box.component.html',
  styleUrls: ['./error-box.component.css']
})
export class ErrorBoxComponent implements OnInit {
  err;

  constructor(private dialogRef: MatDialogRef<ErrorBoxComponent>, @Inject(MAT_DIALOG_DATA) public data) {
  }

  ngOnInit(): void {
    this.err = this.data.err;
  }

  closeDialog() {
    this.dialogRef.close();
  }
}

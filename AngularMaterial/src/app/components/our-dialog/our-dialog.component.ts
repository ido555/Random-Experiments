import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';


@Component({
  selector: 'app-our-dialog',
  templateUrl: './our-dialog.component.html',
  styleUrls: ['./our-dialog.component.css']
})
export class OurDialogComponent implements OnInit {

  constructor(private dialogRef:MatDialogRef<OurDialogComponent>) { }

  ngOnInit(): void {
  }
  closeDialog(){
    this.dialogRef.close()
  }
}

import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-error-box',
  templateUrl: './error-box.component.html',
  styleUrls: ['./error-box.component.css']
})
export class ErrorBoxComponent implements OnInit {

  constructor(private dialogRef:MatDialogRef<ErrorBoxComponent>) { }
  
  ngOnInit(): void {
  }

  closeDialog(){
    this.dialogRef.close()
  }
}

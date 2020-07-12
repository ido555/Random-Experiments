import { Component, OnInit } from '@angular/core';
import { MatDialogRef ,MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Inject } from '@angular/core';

@Component({
  selector: 'app-error-box',
  templateUrl: './error-box.component.html',
  styleUrls: ['./error-box.component.css']
})
export class ErrorBoxComponent implements OnInit {
  err

  constructor(private dialogRef:MatDialogRef<ErrorBoxComponent>, @Inject(MAT_DIALOG_DATA) public data) { }
  
  ngOnInit(): void {
    this.err = this.data.err
    console.log(this.err)
  }

  closeDialog(){
    this.dialogRef.close()
  }
}

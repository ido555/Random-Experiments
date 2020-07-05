import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-login-box',
  templateUrl: './login-box.component.html',
  styleUrls: ['./login-box.component.css']
})
export class LoginBoxComponent implements OnInit {

  constructor(private dialogRef:MatDialogRef<LoginBoxComponent>) { }

  ngOnInit(): void {
  }
  closeDialog(){
    this.dialogRef.close()
  }

}

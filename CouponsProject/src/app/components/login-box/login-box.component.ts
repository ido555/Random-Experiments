import { ClientType } from './../../enums/client-type.enum';
import { LoginControllerService } from './../../services/login-controller.service';
import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login-box',
  templateUrl: './login-box.component.html',
  styleUrls: ['./login-box.component.css']
})
export class LoginBoxComponent implements OnInit {

  constructor(private dialogRef:MatDialogRef<LoginBoxComponent>, private logMan:LoginControllerService, private fb: FormBuilder) { }

  loginForm: FormGroup;

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      password:['', Validators.required],
      email:['', Validators.required],
      clientType:['', Validators.required]
    })
  }
  closeDialog(){
    this.dialogRef.close()
  }
  login(clientType:ClientType, password:String ,email:String){
    this.logMan.login(clientType, password, email).subscribe(
      s => {console.log(s);localStorage.setItem("token", s.toString())},
      e => {console.log()}
    )
  }

}

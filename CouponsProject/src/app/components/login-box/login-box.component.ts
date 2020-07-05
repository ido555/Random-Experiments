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
  // private fb: FormBuilder
  // private dialogRef:MatDialogRef<LoginBoxComponent>
  //  private logMan:LoginControllerService
  constructor(private fb: FormBuilder, private dialogRef: MatDialogRef<LoginBoxComponent>, private logMan: LoginControllerService) { }
  clientType: ClientType;
  password: String;
  email: String;
  loginForm: FormGroup;

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      password: ['', Validators.required],
      email: ['', Validators.required],
      // clientType: ['', Validators.required,
      //  Validators.pattern(ClientType.Adminstrator.toString()),
      //  Validators.pattern(ClientType.Company.toString()),
      //  Validators.pattern(ClientType.Customer.toString())]
    })
    this.clientType = ClientType.Customer;
  }

  closeDialog() {
    this.dialogRef.close()
  }
  login() {
    this.logMan.login(this.clientType, this.loginForm.controls["password"].value, this.loginForm.controls["email"].value).subscribe(
      s => { console.log(s); sessionStorage.setItem("token", s.toString()) },
      e => { console.log(e) }
    )
  }
  setClientType(num: number) {
    switch (num) {
      case 0:
        this.clientType = ClientType.Adminstrator
        break;
      case 1:
        this.clientType = ClientType.Company
        break;
      case 2:
        this.clientType = ClientType.Customer
        break;
    }
  }
}


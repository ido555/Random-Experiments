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
  // private logMan:LoginControllerService
  constructor(private fb: FormBuilder, private dialogRef: MatDialogRef<LoginBoxComponent>, private logMan: LoginControllerService) { }

  clientType;
  password: String;
  email: String;
  loginForm: FormGroup;

  ngOnInit(): void {
    this.clientType = "choose a client type"
      this.loginForm = this.fb.group({
      password: ['', Validators.required],
      email: ['', Validators.required],
      // clientType: ['', Validators.required,
      //  Validators.pattern(ClientType.Adminstrator.toString()),
      //  Validators.pattern(ClientType.Company.toString()),
      //  Validators.pattern(ClientType.Customer.toString())]
    })
  }

  closeDialog() {
    this.dialogRef.close()
  }
  login() {
    console.log("client type: " + this.clientType,
      "password: " + this.loginForm.controls["password"].value,
      "email: " + this.loginForm.controls["email"].value)
    this.logMan.login(this.clientType, this.loginForm.controls["password"].value, this.loginForm.controls["email"].value).subscribe(
      s => { console.log(s); sessionStorage.setItem("token", s.toString()) },
      e => { console.log(e) }
    )
  }
  // TODO this is a really bad way to do this. fix later
  setClientType(type: String) {
    switch (type) {
      case "Adminstrator":
        this.clientType = ClientType.Adminstrator
        break;
      case "Company":
        this.clientType = ClientType.Company
        break;
      case "Customer":
        this.clientType = ClientType.Customer
        break;
    }
  }
}


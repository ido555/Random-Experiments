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

// TODO fix and improve this entire component and its html. its poorly written and poorly structered
export class LoginBoxComponent implements OnInit {
  // private fb: FormBuilder
  // private dialogRef:MatDialogRef<LoginBoxComponent>
  // private logMan:LoginControllerService
  constructor(private fb: FormBuilder, private dialogRef: MatDialogRef<LoginBoxComponent>, private logMan: LoginControllerService) { }

  clientType;
  password: String;
  email: String;
  loginForm: FormGroup;
  typeCheck: boolean = false;
  isLoading: boolean = false;
  success = null;

  //   clientType : ['',  [Validators.required,
  //     Validators.pattern(ClientType[0]) || // 0 - Adminstrator
  //     Validators.pattern(ClientType[1]) || // 1 - Company
  //     Validators.pattern(ClientType[2])]]   // 2 - Customer
  ngOnInit(): void {
    // TODO fix
    this.clientType = "Adminstrator"
    this.loginForm = this.fb.group({
      password: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    })

  }

  closeDialog() {
    this.dialogRef.close()
  }
  // TODO properly show error / success with a little loading thingy and popup
  // TODO popup at bottom of screen thingy whatever thats called
  login() {
    this.logMan.login(this.clientType, this.password, this.email).subscribe(
      s => { localStorage.setItem("token", s.toString()) ; this.success = true},
      e => { console.log(e); this.success = false}
    )
  }
  // TODO this is a really bad way to do this. fix later
  setClientType(type: number) {
    this.clientType = ClientType[0];
    this.checkClientType()
  }
  checkClientType() {
    this.password = this.loginForm.controls["password"].value;
    this.email = this.loginForm.controls["email"].value;
    if (this.clientType == ClientType || ClientType[1] || ClientType[2])
      this.typeCheck = true;
    else
      this.typeCheck = false


  }
}


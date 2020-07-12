import { ClientType } from './../../enums/client-type.enum';
import { LoginControllerService } from './../../services/login-controller.service';
import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
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
  clientChosen: boolean = false;
  password: string;
  email: string;
  loginForm: FormGroup;
  typeCheck: boolean = false;
  success = null;
  error
  // TODO implement a way to show if a field isnt valid with validators
  //   clientType : ['',  [Validators.required,
  //     Validators.pattern(ClientType[0]) || // 0 - Administrator
  //     Validators.pattern(ClientType[1]) || // 1 - Company
  //     Validators.pattern(ClientType[2])]]   // 2 - Customer
  ngOnInit(): void {
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
      s => { localStorage.setItem("token", s.toString()); this.success = true },
      e => { this.success = false; this.error = e.error; ; this.tryAgain() }
    )
  }
  tryAgain() {
    setTimeout(() => {
      this.success = null;
    }, 2300)
  }
  // TODO this is a really bad way to do this. fix later
  setClientType(type: number) {
    this.clientType = ClientType[type];
    this.checkClientType()
  }
  checkClientType() {
    this.password = this.loginForm.controls["password"].value;
    this.email = this.loginForm.controls["email"].value;
    if (this.clientType == ClientType || ClientType[1] || ClientType[2]) {
      this.clientChosen = true;
      this.typeCheck = true;
    }
    else
      this.typeCheck = false
  }
}

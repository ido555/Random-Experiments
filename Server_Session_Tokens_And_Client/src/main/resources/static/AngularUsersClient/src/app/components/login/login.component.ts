import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  loginForm: FormGroup;

  constructor(private service: UserService, private fb:FormBuilder, private snack:MatSnackBar) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ["", Validators.required],
      password: ["", Validators.required]
    });
  }

  public login() {
    this.service.login(this.loginForm.controls['username'].value, this.loginForm.controls['password'].value).subscribe(
      (tokenFromServer)=>{
        sessionStorage.token = tokenFromServer;
        this.snack.open("Login successful! You can get info now", "", {duration:1000})
      }, (err)=>{
        alert("Login failed!")
      }
    )
  }

}

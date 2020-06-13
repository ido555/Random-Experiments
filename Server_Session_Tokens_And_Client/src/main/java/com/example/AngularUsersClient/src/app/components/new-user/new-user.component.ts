import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { User } from 'src/app/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit {

  userForm: FormGroup;

  constructor(private service: UserService, private fb:FormBuilder) { }

  ngOnInit(): void {
    this.userForm = this.fb.group({
      username: ["", Validators.required],
      password: ["", Validators.required],
      info: ["", Validators.required]
    });
  }

  addUser(){
    const user: User = new User(
      this.userForm.controls['username'].value,
      this.userForm.controls['password'].value,
      this.userForm.controls['info'].value,
    );
    console.log(user);
    
    
      this.service.addUser(user).subscribe(
        (user)=>{
          alert("User " + user.username + " added")
        }
      );
  }

}

import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-id-validation-hw',
  templateUrl: './id-validation-hw.component.html',
  styleUrls: ['./id-validation-hw.component.css']
})
export class IdValidationHWComponent implements OnInit {

  courseForm: FormGroup;

  userForm: FormGroup;

  constructor(private fb: FormBuilder) { }

  public ngOnInit(): void {
    this.courseForm = this.fb.group({
      title: ['', Validators.required],
      startDate: ['', [Validators.required, this.validDate]] // Validators.min(new Date().getTime())
    });

    //--------------------

    this.userForm = this.fb.group({
      name: ['', Validators.required],
      id: ['', this.checkID]
    });


  }

  public go() {
    console.log(typeof this.userForm.controls['id'].value)
  }

  public checkID(control: AbstractControl) {
    let sum = 0;
    let newId: string = control.value + "";
    // if(newId.length < 9){
    // for(let i=0; i < 9-newId.length; i++){
    //  newId = "0" + newId;
    // }
    // }
    newId = "0".repeat(9 - newId.length) + newId;

    for (let i = 0; i < 9; i++) {
      let num: number;
      if (i % 2 == 0) {
        // זוגי
        num = +newId.charAt(i) * 1;
      } else {
        // אי זוגי
        num = +newId.charAt(i) * 2;
        if (num > 9) {
          num = num % 10 + Math.floor(num / 10);
        }
      }
      sum += num;
    } // end of for

    if (sum % 10 != 0)
      return { idError: true }
  }

  public validDate(control: AbstractControl) {
    const currentDate: Date = new Date(); // current date and time
    currentDate.setHours(0);
    currentDate.setMinutes(0);
    currentDate.setMilliseconds(0);
    let inputDate: Date = new Date(control.value);
    if (currentDate.getTime() > inputDate.getTime())
      return { dateError: true }
  }
}
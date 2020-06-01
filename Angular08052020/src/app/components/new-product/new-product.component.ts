import { Component, OnInit } from '@angular/core';
import { ProductsService } from "src/app/services/products.service";
import { FormGroup, FormControl, Validators, FormBuilder, AbstractControl } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { strict } from 'assert';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {
  /*
  template form stuff
  title: string;
  description: string;
  price: number;
  */

  productForm: FormGroup;
  a?:number;
  

  // private productService: ProductsService
  constructor(private formBuilder:FormBuilder) { }

  // prod;
  ngOnInit(): void {
    // console.log(this.productService.getProductById(129).subscribe(
    //   success=>{this.prod = success},
    //   err=>{err}
    // ))

    // reactive forms 
    /*
    this.productForm = new FormGroup({
      title: new FormControl("Product 1")),
      description: new FormControl("Description 1"),
      price: new FormControl("111")
    });
    */

    // same as above but different syntax
   this.productForm = this.formBuilder.group({
     title: ["aaaaaaa", Validators.required],
     description: ["A", [Validators.required, Validators.pattern("[A-Z]")]],
     price : [],
     password: ['', [Validators.pattern("..[A-Z][a-z].."), Validators.required]]
    //  this.validateLastName - validator
   })
  }
  // fc - form controls
  public fc(){
    return this.productForm.controls;
  }

  // custom validator
  public validateLastName(control: AbstractControl){
    if (control.value.length < 3) {
      // this error will be added to errors.lastNameLength
      return {lastNameLength:true}
    }
  }
  // strong password validator at least 8 characters, at least 1 uppercase letter, 1 lowercase letter, and 1 number. can contain special characters
  // public validatePassword(control:AbstractControl){
  //   control = this.fc['password']
  //   if (JSON.stringify(control.value).match()) {
  //     return {strongPassword:true};
  //   }
  // }

  sendProduct(){
    // alert(this.fc()['title'].value);
    console.log(this.productForm.value);
      
  }
}

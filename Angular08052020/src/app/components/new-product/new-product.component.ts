import { Component, OnInit } from '@angular/core';
import { ProductsService } from "src/app/services/products.service";
import { FormGroup, FormControl, Validators, FormBuilder, AbstractControl } from '@angular/forms';

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
     title: ["", Validators.required],
     description: ["description 1", [Validators.required, Validators.pattern("[A-Z]")]],
     price : ["", this.validateLastName]
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
}

import { Component, OnInit } from '@angular/core';
import { ProductsService } from "src/app/services/products.service";
import { FormGroup, FormControl, Validators } from '@angular/forms';

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

  // private productService: ProductsService
  constructor() { }

  // prod;
  ngOnInit(): void {
    // console.log(this.productService.getProductById(129).subscribe(
    //   success=>{this.prod = success},
    //   err=>{err}
    // ))
    this.productForm = new FormGroup({
      title: new FormControl("Product 1", Validators.pattern("[A-Z]")),
      description: new FormControl("Description 1"),
      price: new FormControl("111", Validators.pattern("123")),
    });
  }

}

import { Component, OnInit } from '@angular/core';
import { ProductsService } from "src/app/services/products.service";

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {

  constructor(private productService: ProductsService) { }
  prod;
  ngOnInit(): void {
    console.log(this.productService.getProductById(129).subscribe(
      success=>{this.prod = success},
      err=>{err}
    ))
  }

}

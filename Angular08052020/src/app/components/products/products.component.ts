import { Component, OnInit } from '@angular/core';
import { MathService } from 'src/app/services/math.service';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  
  posts;
  products;
  
  // Dependency Injection 
  constructor(private math: MathService, private productsSerice: ProductsService) { }
  
  ngOnInit(): void {
    
    // math service
    console.log(this.math.isPrime(11))
    
    // products service
      this.productsSerice.getAllProducts().subscribe(
        success => { this.products = success },
        err => { console.log(err) }
      )
    // subscribe - asynchronous waiting for get request to complete   
    // this.productsSerice.getPosts().subscribe(this.success, this.failure)
    // lambda expression - function(){} turns into =>
    
    //   this.productsSerice.getPosts().subscribe(
      //     (response) => {
        //       // console.log(response)
        //       this.posts = response;
        //     }, (err) => {
          //       console.log(err)
          //     })
          // }
          
          // success(response) {
            //   console.log(response)
            // }
            // failure(err) {
              //   console.log(err)
            }
          }
          
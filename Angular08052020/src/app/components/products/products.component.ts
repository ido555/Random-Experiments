import { Component, OnInit } from '@angular/core';
import { MathService } from 'src/app/services/math.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  // Dependency Injection 
  constructor(private math: MathService) { }

  ngOnInit(): void {
    alert(this.math.isPrime(11))
  }

}

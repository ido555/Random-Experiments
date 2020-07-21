import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-page',
  templateUrl: './customer-page.component.html',
  styleUrls: ['./customer-page.component.css']
})
export class CustomerPageComponent implements OnInit {
  nums = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19];
  constructor() { }

  ngOnInit(): void {
  }

}

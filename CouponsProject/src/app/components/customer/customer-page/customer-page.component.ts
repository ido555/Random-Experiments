import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-page',
  templateUrl: './customer-page.component.html',
  styleUrls: ['./customer-page.component.css']
})
export class CustomerPageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  counter(n:number){
    let nums = new Array(n)
    for (let i = 0; i < n; i++)
      nums[i] = i+1;
    return nums;
  }
}

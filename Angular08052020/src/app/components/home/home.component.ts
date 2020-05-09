import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  /*private - hence need to use public getter*/ today: Date;
  names: string[];
  productPrice: number;
  isDay: boolean;
  imgWidth: number;

  constructor() { }

  ngOnInit(): void {
    this.today = new Date()
    this.productPrice = 199
    this.names = ['one', 'two', 'three', 'four', 'five']
    this.imgWidth = 150
  }

  getToday(): Date {
    return this.today
  }
  randomSize(): void{
    this.imgWidth = ((Math.random())*300)+200
  }
}

import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  /*private - hence need to use public getter*/ today: Date;

  constructor() { }

  ngOnInit(): void {
    this.today = new Date()
  }

  getToday(): Date{
    return this.today
  }
}

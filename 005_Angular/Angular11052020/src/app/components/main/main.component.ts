import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  constructor() { }

  time: Date;
  ngOnInit(): void {
    this.time = new Date;
    setInterval(() => {this.time = new Date;}, 1000);
  }

}

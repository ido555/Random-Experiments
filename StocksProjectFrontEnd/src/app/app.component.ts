import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
   
})
export class AppComponent implements OnInit {

  // title = 'StocksProjectFrontEnd';
  public primaryXAxis: Object;
  public title: string;
  public primaryYAxis: Object;
  public data: Object[];
  ngOnInit(): void {
    this.data = [
      { x: '1', open: 120, high: 160, low: 100, close: 140 },
      { x: '2', open: 150, high: 190, low: 130, close: 170 },
      { x: '3', open: 130, high: 170, low: 110, close: 150 },
      { x: '4', open: 160, high: 180, low: 120, close: 140 },
      { x: '5', open: 160, high: 180, low: 120, close: 140 },
      { x: '6', open: 160, high: 180, low: 120, close: 140 },
      { x: '7', open: 160, high: 180, low: 120, close: 140 },
      { x: '8', open: 160, high: 180, low: 120, close: 140 },
      { x: '9', open: 160, high: 180, low: 120, close: 140 },
      { x: '10', open: 160, high: 180, low: 120, close: 140 },
      { x: '11', open: 160, high: 180, low: 120, close: 140 },
      { x: '12', open: 160, high: 180, low: 120, close: 140 },
      { x: '13', open: 160, high: 180, low: 120, close: 140 },
      { x: '14', open: 160, high: 180, low: 120, close: 140 },
      { x: '15', open: 150, high: 170, low: 110, close: 130 }
    ];
    this.primaryXAxis = {
      title: 'Date',
      valueType: 'Category',
    };
    this.primaryYAxis = {
      title: 'Price in Dollar', minimum: 100, maximum: 200, interval: 20,
    };
    this.title = 'Financial Analysis';
  }
}

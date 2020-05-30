import { Component, OnInit } from '@angular/core';
import { DataManager, Query } from '@syncfusion/ej2-data';
import { StocksService } from "../app/services/stocks.service";
import { Double } from '@syncfusion/ej2-angular-charts';

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
  public data;
  public tooltip: Object;
  public hidden: boolean = true;
  public zoom: Object;
  public max:Double;
  public min:Double;


  constructor(private st: StocksService) {

  }

  ngOnInit(): void {

  }
  toggleDiv(): void {
    this.hidden = !this.hidden;
  }

  showGraph(): void {
    this.st.getMSFT().subscribe(
      success => { this.processGraph(success)},
      fail => { console.log("failed to fetch stock info", fail) })
    this.tooltip = {
      enable: true
    }



  }
  private processGraph(success): void {
    console.log(success); 
    this.data = success;
    this.zoom = {
      enableSelectionZooming: true,
      toolbarItems: ['Zoom', 'Pan', 'Reset']
    };
    // this.data = [
    //   { x: 'May 11, 2020', open: 120, high: 160, low: 100, close: 140 },
    //   { x: 'May 12, 2020', open: 150, high: 190, low: 130, close: 170 },
    //   { x: 'May 13, 2020', open: 130, high: 170, low: 110, close: 150 },
    //   { x: 'May 14, 2020', open: 160, high: 180, low: 120, close: 140 }
    // ];
    this.primaryXAxis = {
      title: 'Date',
      valueType: 'Category',
    };
    this.primaryYAxis = {
      title: 'Price in Dollar', minimum: this.data[0].minPrice-60, maximum: this.data[0].maxPrice, interval: 20,
    };

    this.title = 'MSFT stock';
  }

};




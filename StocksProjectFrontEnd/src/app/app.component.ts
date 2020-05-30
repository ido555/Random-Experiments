import { Component, OnInit } from '@angular/core';
import { DataManager, Query } from '@syncfusion/ej2-data';
import { StocksService } from "../app/services/stocks.service";

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
  public url: string = 'http://localhost:8080/getStock/MSFT/compact'
  public dataManager: DataManager;
  public hidden: boolean = true;
  public zoom: Object;

  constructor(private st: StocksService) {

  }

  ngOnInit(): void {

  }
  showGraph(): void {
    // this.st.getMSFT().subscribe(
    //   success => { console.log(success), this.data = success },
    //   fail => { console.log("failed to fetch", fail) })
    this.tooltip = {
      enable: true
    }
    this.dataManager = new DataManager({
      url: this.url
    });
    this.zoom = {
      enableSelectionZooming: true,
      toolbarItems: ['Zoom', 'Pan', 'Reset']
    };
    console.log(this.dataManager)
    this.data = [
      { x: '1', open: 120, high: 160, low: 100, close: 140 },
      { x: '2', open: 150, high: 190, low: 130, close: 170 },
      { x: '3', open: 130, high: 170, low: 110, close: 150 },
      { x: '4', open: 160, high: 180, low: 120, close: 140 }
    ];
    this.primaryXAxis = {
      title: 'Date',
      valueType: 'Category',
    };
    this.primaryYAxis = {
      title: 'Price in Dollar', minimum: 1, maximum: 400, interval: 20,
    };
    this.title = 'Financial Analysis';
  }

}


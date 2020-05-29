import { Component, OnInit , } from '@angular/core';
import { JstestService } from "../../app/services/jstest.service";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
  providers: [JstestService]
})
export class MainComponent implements OnInit {


  constructor(private testService:JstestService) { 
  }

  ngOnInit(): void {
    this.testService.testFunc();
  }

}

import { AdminControllerService } from './../../../services/admin-controller.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer-controls',
  templateUrl: './customer-controls.component.html',
  styleUrls: ['./customer-controls.component.css']
})
export class CustomerControlsComponent implements OnInit {

  constructor(private cont:AdminControllerService) { }

  ngOnInit(): void {
    console.log("test123")
  }
  public getAllCustomers(){
    this.cont.getAllCustomers("74ff0e68-869f-41f2-af0b-3c8e99b1c0e9").subscribe(
      s => console.log(s),
      e => console.log(e)
    )
  }
}

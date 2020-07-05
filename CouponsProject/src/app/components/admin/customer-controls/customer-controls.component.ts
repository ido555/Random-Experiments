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
    this.cont.getAllCustomers("token 123").subscribe(
      s => console.log(s),
      e => console.log(e)
    )
  }
}

import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {

  info: FormControl;

  constructor(private service: UserService) { }

  ngOnInit(): void {
    this.info = new FormControl("");

    this.service.getInfo().subscribe(
      (information) => {
        this.info.setValue(information);
      }, (err) => {
        alert(err.message);
      }
    );
  }

}

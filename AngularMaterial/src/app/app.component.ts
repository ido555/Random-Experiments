import { FormControl } from '@angular/forms';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
    options = [
        {title:'Audi R8', color: 'red'},
        {title:'Jaguar F-Type', color: 'black'}, 
        {title:'Nissan GTR', color: 'SILVER'} ]
  title = 'AngularMaterial';
  optionSelect: FormControl;
}

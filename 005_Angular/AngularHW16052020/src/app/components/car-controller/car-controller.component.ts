import { Component, OnInit, Input } from '@angular/core';
import { CarService } from 'src/app/services/car.service';
import { Car } from 'src/app/models/car';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-car-controller',
  templateUrl: './car-controller.component.html',
  styleUrls: ['./car-controller.component.css']
})
export class CarControllerComponent implements OnInit {

  constructor(private carService: CarService) { }
  cars: Car[]
  car: Car
  @Input()
  id: number
  ngOnInit(): void {
    // this.addCar(new Car(0,"yellow","porsche",2020))

  }
  getCars() {
    this.carService.getAllCars().subscribe(
      success => { this.cars = success },
      err => { console.log(err) })
  }
  getCar(id: number) {
    this.carService.getCarById(id).subscribe(
      success => { this.car = success },
      err => { this.car = null })
  }
  // addCar(car:Car){
  //   this.carService.addCar(car)
  // }
}

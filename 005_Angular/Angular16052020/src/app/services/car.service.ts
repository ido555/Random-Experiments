import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Car } from '../models/car';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private httpClient: HttpClient) { }

  // addCar( car:Car) {
  //   this.httpClient.post("http://localhost:8080/cars/add", car)
  //   .subscribe(
  //     success=>{console.log(success)},
  //     err=>{console.log(err)}
  //     )
  // }
  getAllCars() {
    return this.httpClient.get<Car[]>("http://localhost:8080/cars")
  }
  getCarById(id: number) {
    return this.httpClient.get<Car>("http://localhost:8080/cars/" + id)
  }
}

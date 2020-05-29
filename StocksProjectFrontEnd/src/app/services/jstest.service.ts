import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JstestService {
  var:any

  constructor() { 
    
  }
  testFunc(){
    console.log("hello")
  }
}

import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MathService {

  constructor() { }

  public isPrime(number: number): boolean {
    // using square root is faster
    for (let i = 0; i < number / 2; i++)
      if (number % i == 0)
        return false;
    return true;
  }
}

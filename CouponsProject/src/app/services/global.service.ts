import {Injectable} from '@angular/core';

// singleton shared across angular project ?
@Injectable({
  providedIn: 'root'
})
export class GlobalService {

  private ct: string;

  constructor() {
  }

  public getClientType() {
    return this.ct;
  }

  public setClientType(ct: string) {
    this.ct = ct;
  }
}

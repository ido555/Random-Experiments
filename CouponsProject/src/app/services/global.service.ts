import {Injectable} from '@angular/core';

// singleton shared across angular project
@Injectable({
  providedIn: 'root'
})
export class GlobalService {

  constructor() {
  }

  public isLogged() {
    return sessionStorage.getItem('token') != null;
  }

  public getClientType() {
    return sessionStorage.getItem("ct");
  }

  public setClientType(ct: string) {
    sessionStorage.setItem("ct" , ct);
  }
}

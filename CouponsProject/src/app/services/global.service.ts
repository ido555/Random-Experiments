import {Injectable} from '@angular/core';
import {ClientType} from '../enums/client-type.enum';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {
  private ct:ClientType;
  constructor() {
  }

  public getClientType(){
    return this.ct;
  }
  public setClientType(ct:ClientType){
    this.ct = ct;
  }
}

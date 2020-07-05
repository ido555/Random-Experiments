import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from "../models/customer";

@Injectable({
  providedIn: 'root'
})
export class AdminControllerService {

  constructor(private httpClient: HttpClient) { }

  public getAllCustomers(token: String) {
    return this.httpClient.get("http://localhost:8080/admin/getAll/customers/" + token)
  }
}

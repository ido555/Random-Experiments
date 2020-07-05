import { ClientType } from './../enums/client-type.enum';
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginControllerService {

  constructor(private httpClient: HttpClient, private httpParams: HttpParams) { }
  public login(clientType: ClientType, password: String, email: String) {
    this.httpParams.append("email", email.toString());
    this.httpParams.append("password", password.toString());
    return this.httpClient.get("http://localhost:8080/login/" + clientType, { params: this.httpParams })
  }
}

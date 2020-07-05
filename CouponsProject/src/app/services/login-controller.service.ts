import { ClientType } from './../enums/client-type.enum';
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginControllerService {
  post:Object;
  constructor(private httpClient: HttpClient ) { }
  public login(clientType: ClientType, password: String, email: String) {
    // idk why httpParams:HttpParams) didnt work (missing provider or something) so i just skipped it
    // this.httpParams.append("email", email.toString());
    // this.httpParams.append("password", password.toString());
    this.post = {'email':email.toString(), "password":password.toString()};
    return this.httpClient.post("http://localhost:8080/login/" + clientType, this.post, this.post)
  }
}

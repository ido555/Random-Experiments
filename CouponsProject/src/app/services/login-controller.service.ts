import { ClientType } from './../enums/client-type.enum';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
// TODO try to make httpParams not throw a provider missing thingy exception
export class LoginControllerService {
  post:Object;
  constructor(private httpClient: HttpClient ) { }

  public login(clientType: ClientType, password: String, email: String) {
    return this.httpClient.post("http://localhost:8080/login/" + clientType, {"email":email.toString(), "password":password.toString()})
  }
  public logout(token:String) {
    return this.httpClient.post("http://localhost:8080/logout/" + token, null)
  }
}

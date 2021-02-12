import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginControllerService {
  post: object;

  constructor(private httpClient: HttpClient) {
  }

  public getAllCoupons(token: string) {
    return this.httpClient.get('http://localhost:8080/getAllCoupons/' + token,{responseType: 'json'});
  }
  public login(clientType: string, password: string, email: string) {
    return this.httpClient.get('http://localhost:8080/login/' + clientType + '/' + email + '/' + password, {responseType: 'text'});
  }

  public logout(token: string) {
    return this.httpClient.delete('http://localhost:8080/logout/' + token, {responseType: 'text'});
  }
}

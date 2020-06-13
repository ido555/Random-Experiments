import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private client:HttpClient) { }

  public login(username:string, password: string){
    console.log("username: " + username + ", password: " + password);
    
    return this.client.post("http://localhost:8080/login/" + username +"/" + password, null, {responseType:'text'});
  }

  public logout(){
    return this.client.post("http://localhost:8080/logout/" + sessionStorage.token, null, {responseType:'text'});
  }

  public addUser(user:User){
    return this.client.post<User>("http://localhost:8080/users", user);
  }

  public getInfo(){
    return this.client.get("http://localhost:8080/users/" + sessionStorage.token, {responseType:'text'});
  }
}

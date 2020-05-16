import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  // DI
  constructor(private httpClient: HttpClient) { }

  public getPosts() {
    return this.httpClient.get("https://jsonplaceholder.typicode.com/posts")
  }
}

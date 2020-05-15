import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  // DI
  constructor(private httpClient: HttpClient) { }

  public getPosts() {
    return this.httpClient.get("https://jsonplaceholder.typicode.com/posts")
  }
  
  addPost(post: Object) {
    // jsonholder does not support post requests
    return this.httpClient.post("https://jsonplaceholder.typicode.com/posts", post)
  }
  
  getAllProducts(){
    return this.httpClient.get<Product[]>("http://localhost:8080/products/getAll")
  }
}

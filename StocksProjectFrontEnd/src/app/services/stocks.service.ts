import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StocksService {
  // DI
  constructor(private httpClient: HttpClient) { }

  public getMSFT() {
    return this.httpClient.get("http://localhost:8080/getStock/MSFT/compact")
  }
}
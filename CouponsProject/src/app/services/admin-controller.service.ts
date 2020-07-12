import { Company } from './../models/company';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from "../models/customer";

@Injectable({
  providedIn: 'root'
})
export class AdminControllerService {

  constructor(private httpClient: HttpClient) { }
  public getAllCustomers(token: string) {
    return this.httpClient.get("http://localhost:8080/admin/getAll/customers/" + token)
  }
  public getAllCompanies(token: string) {
    return this.httpClient.get("http://localhost:8080/admin/getAll/companies/" + token)
  }
  public getOneCustomer(token: string, id: number) {
    return this.httpClient.get("http://localhost:8080/admin/get/customer/" + token + "/" + id)
  }
  public getOneCompany(token: string, id: number) {
    return this.httpClient.get("http://localhost:8080/admin/get/company/" + token + "/" + id)
  }
  public addCustomer(token: string, customer: Customer) {
    return this.httpClient.post("http://localhost:8080/admin/add/customer/" + token, customer)
  }
  public addCompany(token: string, company: Company) {
    return this.httpClient.post("http://localhost:8080/admin/add/company/" + token, company)
  }
  public updateCustomer(token: string, customer: Customer) {
    return this.httpClient.put("http://localhost:8080/admin/update/customer/" + token, customer)
  }
  public updateCompany(token: string, company: Company) {
    return this.httpClient.put("http://localhost:8080/admin/update/company/" + token, company)
  }
  public deleteCustomer(token: string, id: number) {
    return this.httpClient.delete("http://localhost:8080/admin/delete/customer/" + token + "/" + id)
  }
  public deleteCompany(token: string, id: number) {
    return this.httpClient.delete("http://localhost:8080/admin/delete/company/" + token + "/" + id)
  }
}
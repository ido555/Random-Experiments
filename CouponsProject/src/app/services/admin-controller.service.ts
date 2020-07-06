import { Company } from './../models/company';
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
  public getAllCompanies(token: String) {
    return this.httpClient.get("http://localhost:8080/admin/getAll/companies/" + token)
  }
  public getOneCustomer(token: String, customer: Customer) {
    return this.httpClient.get("http://localhost:8080/admin/get/customer/" + token)
  }
  public getOneCompany(token: String, company: Company) {
    return this.httpClient.get("http://localhost:8080/admin/get/company/" + token)
  }
  public addCustomer(token: String, customer: Customer) {
    return this.httpClient.post("http://localhost:8080/admin/add/customer/" + token, customer)
  }
  public addCompany(token: String, company: Company) {
    return this.httpClient.post("http://localhost:8080/admin/add/company/" + token, company)
  }
  public updateCustomer(token: String, customer: Customer) {
    return this.httpClient.put("http://localhost:8080/admin/update/customer/" + token, customer)
  }
  public updateCompany(token: String, company: Company) {
    return this.httpClient.put("http://localhost:8080/admin/update/company/" + token, company)
  }
  public deleteCustomer(token: String, customer: Customer) {
    return this.httpClient.delete("http://localhost:8080/admin/delete/customer/" + token, customer)
  }
  public deleteCompany(token: String, company: Company) {
    return this.httpClient.delete("http://localhost:8080/admin/delete/company/" + token, company)
  }
}
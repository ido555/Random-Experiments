import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Computer } from './../models/computer';

@Injectable({
    providedIn: 'root'
})
export class ComputerService {
    // add the rest at home
    constructor(private client: HttpClient) { }

    addComputer(computer: Computer) {
        return this.client.post<Computer>("http://localhost:8080/comp", computer);
    }
    deleteComputer(id: number) {
        return this.client.post<Computer>("http://localhost:8080/comp/" + id, { responseType: 'text' });
    }
    getComputer(id: number) {
        return this.client.get<Computer>("http://localhost:8080/comp/" + id);
    }
}

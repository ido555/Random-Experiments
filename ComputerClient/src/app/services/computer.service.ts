import { HttpClient } from '@angular/common/http';
import { Computer } from './../models/computer';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class ComputerService {

    constructor(private client: HttpClient) { }

    addComputer(computer:Computer){
        return this.client.post<Computer>("http://localhost:8080/comp", computer);
    }

    updateComputer(computer:Computer){
        return this.client.put<Computer>("http://localhost:8080/comp", computer);
    }

    deleteComputer(id: number){
        return this.client.delete("http://localhost:8080/comp/" + id, 
            {responseType: 'text'});
    }

    getOneComputer(id: number){
        return this.client.get<Computer>("http://localhost:8080/comp/" + id);
    }

    getAllComputers(){
        return this.client.get<Computer[]>("http://localhost:8080/comp");
    }

    getComputersByModel(model: string){
        return this.client.get<Computer[]>("http://localhost:8080/comp/model/" + model);
    }
}

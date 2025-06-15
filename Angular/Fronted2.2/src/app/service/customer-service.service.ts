import { HttpClient } from '@angular/common/http';
import { inject, Injectable, OnInit } from '@angular/core';
import { Customer } from '../Model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  url:string="http://localhost:8080/api/customer";
  private http=inject(HttpClient);

  list(){
    return this.http.get<Customer[]>(this.url);
  }

  getByID(id:string){
    return this.http.get<Customer>(this.url+"/"+id);
  }

  create(customer:Customer){
    return this.http.post<Customer>(this.url,customer)
  }

  update(id:number,customer:Customer){
    return this.http.put<Customer>(this.url+"/"+id,customer)
  }

  delete(id:number){
    return this.http.delete(this.url+"/"+id)
  }



}

import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Customer } from '../Model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  private url:string="http://localhost:8080/api/customer";
  private http=inject(HttpClient);

  list(){
    return this.http.get<Customer[]>(this.url);    
  }
  get(id:number){
    return this.http.get<Customer>(this.url+"/"+id)
  }
  post(customer:Customer){
    return this.http.post<Customer>(this.url,customer)
  }
  put(id:number,customer:Customer){
    return this.http.put<Customer>(this.url+"/"+id,customer)
  }
  delete(id:number){
    return this.http.delete(this.url+"/"+id)
  }


}

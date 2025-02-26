import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';
import { CustomerSinID } from '../model/customer-sin-id';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  
  private api:string="http://localhost:8080/api/Customer";

  constructor(private http:HttpClient) {}

  getCustomerList():Observable<Customer[]>  {
    return this.http.get<Customer[]>(this.api);
  }

  createCustomer(newCustomer:CustomerSinID):Observable<CustomerSinID>{
    return this.http.post<CustomerSinID>(this.api,newCustomer);
  }

}

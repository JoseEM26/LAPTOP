import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Contact } from '../Model/contact';

@Injectable({
  providedIn: 'root'
})
export class ServiceCUstomerService {

  private url:string="http://localhost:8080/api/contact";

  private http=inject(HttpClient)

  list(){
   return this.http.get<Contact[]>(this.url)
  }

  get(id:number){
    return this.http.get<Contact>(this.url+"/"+id)
  }

  create(contact:Contact){
    return  this.http.post<Contact>(this.url,contact);
  }
  
  update(id:number,contact:Contact){
    return  this.http.put<Contact>(this.url+"/"+id,contact);
  }

  delete(id:number){
    return  this.http.delete(this.url+"/"+id)
  }



}

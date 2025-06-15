import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MensajeService {

  constructor() { }
  
  messaje:string[]=['a','b','c','d'];

  add (mensaje:string){
    this.messaje.push(mensaje);
  }


}

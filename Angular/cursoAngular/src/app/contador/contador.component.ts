import { Component } from '@angular/core';

@Component({
  selector: 'app-contador',
  templateUrl: './contador.component.html',
  styleUrl: './contador.component.css'
})
export class ContadorComponent {

  numero=1;

  decrementar(){
    this.numero--;
  }
  incrementar(){
    this.numero++;
  }  
}

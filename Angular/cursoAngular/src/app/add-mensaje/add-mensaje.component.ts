import { Component } from '@angular/core';
import { MensajeService } from '../mensaje.service';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-mensaje',
  imports: [FormsModule,ReactiveFormsModule], 
  templateUrl: './add-mensaje.component.html',
  styleUrl: './add-mensaje.component.css',
})
export class AddMensajeComponent {
  constructor(public MensajeService: MensajeService) {}
  mensaje:string ='';

  enviar(){
    this.MensajeService.add(this.mensaje);
  }
}

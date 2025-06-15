import { Component } from '@angular/core';
import { MensajeService } from '../mensaje.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-list-mensaje',
  imports: [CommonModule],
  templateUrl: './list-mensaje.component.html',
  styleUrl: './list-mensaje.component.css'
})
export class ListMensajeComponent {
 constructor(public service:MensajeService){}


}

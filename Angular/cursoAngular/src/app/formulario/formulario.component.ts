import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-formulario',
  imports: [CommonModule],
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css'
})
export class FormularioComponent {

  OpenAlert: boolean = false

  MostrarConsola(name: string) {
    if (name != "") {
      this.OpenAlert = false
    } if (name != null && name != "") {
      this.OpenAlert = true
      console.log(name)

    }
  }
}

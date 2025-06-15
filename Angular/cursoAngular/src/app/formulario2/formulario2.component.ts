import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';




@Component({
  selector: 'app-formulario2',
  imports: [CommonModule , FormsModule,ReactiveFormsModule],
  templateUrl: './formulario2.component.html',
  styleUrl: './formulario2.component.css'
})
export class Formulario2Component {

  persona={
    nombre:"",
    edad:""
  }

  procesar(){
    console.log("la persona se llama"+ this.persona.nombre + "y su edad es :" +this.persona.edad)
  }
}

import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ContadorComponent } from "./contador/contador.component";
import { BotonesComponent } from "./botones/botones.component";
import { FormularioComponent } from "./formulario/formulario.component";
import { CommonModule } from '@angular/common';
import { BucleComponent } from "./bucle/bucle.component";
import { SwitchComponent } from "./switch/switch.component";
import { Formulario2Component } from "./formulario2/formulario2.component"; // 👈 Importamos CommonModule
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import { Formulario3Component } from "./formulario3/formulario3.component";
import { ListMensajeComponent } from "./list-mensaje/list-mensaje.component";
import { AddMensajeComponent } from "./add-mensaje/add-mensaje.component";


@Component({
  selector: 'app-root',
  imports: [ReactiveFormsModule, FormsModule, CommonModule, RouterOutlet, ContadorComponent, BotonesComponent, FormularioComponent, BucleComponent, SwitchComponent, Formulario2Component, Formulario3Component, ListMensajeComponent, AddMensajeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'cursoAngular';
}

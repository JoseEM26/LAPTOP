import { Component } from '@angular/core';
import { Persona } from '../Interfazes/Persona';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-bucle',
  imports: [CommonModule],
  templateUrl: './bucle.component.html',
  styleUrl: './bucle.component.css'
})
export class BucleComponent {
  persona:Persona[] =[
    {nombre:"Jose" , edad:20},
    {nombre:"Ariadna" , edad:21},
    {nombre:"naydelin" , edad:22},
    {nombre:"Lira" , edad:23}
  ]
}

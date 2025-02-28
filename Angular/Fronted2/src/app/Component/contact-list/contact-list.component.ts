import { Component, inject, OnInit } from '@angular/core';
import { ServiceCUstomerService } from '../../Service/service-customer.service';
import { CommonModule, DatePipe } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Contact } from '../../Model/contact';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-contact-list',
  imports: [CommonModule,DatePipe,RouterModule],
  templateUrl: './contact-list.component.html',
  styleUrl: './contact-list.component.css'
})
export class ContactListComponent implements OnInit{
   
    private service=inject(ServiceCUstomerService);

    contact:Contact[]=[];

    ngOnInit(): void {
      this.loadALl();
     }  

     loadALl(){
      this.service.list().subscribe((x)=>
        this.contact=x 
    )
     }


    deleteContact(id:number){
      this.service.delete(id).subscribe(()=>{
        console.log("Se Elimino el Contact N° "+id)
        this.loadALl()
        Swal.fire({
                      title: "Se Elimino exitoso!",
                      text: "El contacto ha sido Eliminado correctamente.",
                      icon: "error"
                    });
      })
    }



}

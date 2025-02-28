import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { ReactiveFormsModule, FormBuilder, FormGroup, EmailValidator, Validators } from '@angular/forms';
import { ServiceCUstomerService } from '../../../Service/service-customer.service';
import Swal from 'sweetalert2';
import { Contact } from '../../../Model/contact';


@Component({
  selector: 'app-form',
  imports: [RouterModule,ReactiveFormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent implements OnInit {
  

    private fb=inject(FormBuilder);
    private service=inject(ServiceCUstomerService);
    private idParameter=inject(ActivatedRoute);

    form?:FormGroup;
    contact?:Contact;

    ngOnInit(): void {
       const id=this.idParameter.snapshot.paramMap.get("id");
      console.log(id)

      if(id != null){
        this.service.get(parseInt(id)).subscribe(x=>{
          console.log(x)

          this.contact=x;

          this.form =this.fb.group({
            name:[x.name,Validators.required],
            email:[x.email,[Validators.required,Validators.email]],
          })
        })
      }else{
        this.form =this.fb.group({
          name:["",Validators.required],
          email:["",[Validators.required,Validators.email]],
        })
      }

    }


   

    create() {
      const contactForm = this.form!.value;
      
      if(this.form?.invalid){
        return
      }

      if(this.contact){
        this.service.update(this.contact.id,contactForm).subscribe({
          next: () => {
            Swal.fire({
              title: "Se actualizo exitoso!",
              text: "El contacto ha sido Actualizado correctamente.",
              icon: "success"
            });
          },
          error: (err) => {
            Swal.fire({
              title: "¡Error!",
              text: "No se pudo actualizar el contacto. Intenta nuevamente.",
              icon: "error"
            });
            console.error("Error al actualizar contacto:", err);
          }
        });
      }else{
        this.service.create(contactForm).subscribe({
          next: () => {
            Swal.fire({
              title: "¡Registro exitoso!",
              text: "El contacto ha sido registrado correctamente.",
              icon: "success"
            });
          },
          error: (err) => {
            Swal.fire({
              title: "¡Error!",
              text: "No se pudo registrar el contacto. Intenta nuevamente.",
              icon: "error"
            });
            console.error("Error al crear contacto:", err);
          }
        });
      }


     

}}

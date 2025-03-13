import { Component, inject, OnInit } from '@angular/core';
import { CustomerServiceService } from '../../Service/customer-service.service';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms"
import Swal from 'sweetalert2';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Customer } from '../../Model/customer';

@Component({
  selector: 'app-form',
  imports: [ReactiveFormsModule,FormsModule,RouterLink],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent implements OnInit{

  private service=inject(CustomerServiceService);
  private fb=inject(FormBuilder);
  private url=inject(ActivatedRoute);

  form!:FormGroup;
  contact?:Customer;

  ngOnInit(): void {

    const id=this.url.snapshot.paramMap.get("id");
    console.log(id);

    if(id){
      this.service.get(parseInt(id)).subscribe((x)=>{
        this.contact=x
        console.log(x)

        this.form= this.fb.group({
          nombre:[x.nombre,Validators.required],
          apellido:[x.apellido,Validators.required],
          email:[x.email,[Validators.required, Validators.email]]
        })
      })

      
    }else{
      this.form= this.fb.group({
        nombre:["",Validators.required],
        apellido:["",Validators.required],
        email:["",[Validators.required, Validators.email]]
      })
    }

   
  }

  create(){

    if(this.form.invalid){
       Swal.fire({
          title: "Error!",
          text: "Debe completar todos los datos correctamente!",
          icon: "error"
        });
      return;
    }

    const FormGroup=this.form.value;

    if(!this.contact){

      this.service.post(this.form.value).subscribe({
        next: ()=>{
          Swal.fire({
            title: "Good job!",
            text: "You clicked the button!",
            icon: "success"
          });
          this.form= this.fb.group({
            nombre:["",Validators.required],
            apellido:["",Validators.required],
            email:["",Validators.required]
          })
        },
        error: (err)=>{
          Swal.fire({
            title: "Ocurrio un error!",
            text: "Vuelve a intentarlo!",
            icon: "error"
          });
        }
      
      } );

    }else{
       this.service.put(this.contact.id,FormGroup).subscribe({
          next: ()=>{
            Swal.fire({
              title: "Actualizacion exitosa!",
              text: "Gracias por actualizar!",
              icon: "success"
            });
          },error: (err)=>{
            console.log(FormGroup)
            console.log(this.contact?.id+"sad")
            Swal.fire({
              title: "Ocurrio un error!",
              text: "Vuelve a intentarlo!",
              icon: "error"
            });
            console.log(err);
          }

       })
    }

  }

  

}

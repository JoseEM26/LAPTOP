import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CustomerServiceService } from '../../service/customer-service.service';
import Swal from "sweetalert2";
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Customer } from '../../Model/customer';

@Component({
  selector: 'app-form',
  imports: [ReactiveFormsModule,RouterModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent implements OnInit {

  private fb=inject(FormBuilder);
  private service=inject(CustomerServiceService);
  private idPut=inject(ActivatedRoute)

  form!:FormGroup;
  customer?:Customer;

  ngOnInit(): void {

    const id=this.idPut.snapshot.paramMap.get("id");
    console.log(id);

    if(id){

      this.service.getByID(id).subscribe((x)=>{
        this.customer=x
        this.form=this.fb.group({
          nombre:[x.nombre,Validators.required],
          apellido:[x.apellido,Validators.required],
          email:[x.email,Validators.required],
        })
      });
    }else{
      this.form=this.fb.group({
        nombre:["",Validators.required],
        apellido:["",Validators.required],
        email:["",Validators.required],
      })
    }
  }

  create(){

    if(this.form.invalid){
      console.log("Ocurrio un error");
      Swal.fire({
        title: "Error!",
        text: "Debe completar todos los campos requeridos!",
        icon: "error"
      });
      return;
    }

    if(this.customer){

      this.service.update(this.customer.id,this.form.value).subscribe({
        next:(x)=>{
          console.log(x)
          Swal.fire({
            title: "Good job!",
            text: "You clicked the button!",
            icon: "success"
          });

          this.form=this.fb.group({
            nombre:["",Validators.required],
            apellido:["",Validators.required],
            email:["",Validators.required],
          })

        },error:()=>{
          Swal.fire({
            title: "Error!",
            text: "Ocurrio un error!",
            icon: "error"
          });
        }
      })


    }else{   
    this.service.create(this.form.value).subscribe({
      next:(x)=>{
        console.log(x)
        Swal.fire({
          title: "Good job!",
          text: "You clicked the button!",
          icon: "success"
        });
      },error:()=>{
        Swal.fire({
          title: "Error!",
          text: "Ocurrio un error!",
          icon: "error"
        });
      }
    })
    }

  }
}

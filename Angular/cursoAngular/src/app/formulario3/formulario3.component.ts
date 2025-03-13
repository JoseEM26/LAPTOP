import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';


@Component({
  selector: 'app-formulario3',
  imports: [ReactiveFormsModule,FormsModule,CommonModule],
  templateUrl: './formulario3.component.html',
  styleUrl: './formulario3.component.css'
})
export class Formulario3Component {

  formUser = new FormGroup({
  
    "name" : new FormControl('',Validators.required),
    "email": new FormControl('',[Validators.required,Validators.email])

   
  });
  
  get getName(){
    return this.formUser.get('name') as FormControl;
  }
  get getEmail(){ 
    return this.formUser.get('email') as FormControl;
  }

  procesar(){
    console.log(this.formUser.value) 
  }
    // name =new FormControl('',Validators.required);
    // email=new FormControl('',[Validators.required,Validators.email]);

}

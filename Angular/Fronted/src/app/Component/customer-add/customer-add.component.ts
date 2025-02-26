import Swal from 'sweetalert2';
import { Component, OnInit } from '@angular/core';
import { Customer } from '../../model/customer';
import { CustomerService } from '../../service/customer.service';
import { HttpClient } from '@angular/common/http';
import { CustomerSinID } from '../../model/customer-sin-id';
import { error } from 'console';

@Component({
  selector: 'app-customer-add',
  standalone: false,
  templateUrl: './customer-add.component.html',
  styleUrl: './customer-add.component.css'
})
export class CustomerAddComponent implements OnInit {
  
  firstName:string="";
  lastName:string="";
  email:string="";

  ngOnInit(): void {}

  constructor(private customerService:CustomerService){}

  addCustomer() {
    let customer = new CustomerSinID(this.firstName, this.lastName, this.email);
    console.log(customer);
  
    this.customerService.createCustomer(customer).subscribe(response => {
      console.log(response);
      // SweetAlert de éxito
      Swal.fire({
        title: "¡Cliente agregado!",
        text: "El cliente se ha registrado exitosamente.",
        icon: "success",
        confirmButtonText: "OK"
      });
    }, error => {
      // SweetAlert de error
      Swal.fire({
        title: "Error",
        text: "Hubo un problema al registrar el cliente.",
        icon: "error",
        confirmButtonText: "Cerrar"
      });
    });
  }
  


}

import { Component, OnInit } from '@angular/core';
import { Customer } from '../../model/customer';
import { CustomerService } from '../../service/customer.service';
import Swal from 'sweetalert2';
import { error } from 'console';

@Component({
  selector: 'app-customer-list',
  standalone: false,
  templateUrl: './customer-list.component.html',
  styleUrl: './customer-list.component.css'
})
export class CustomerListComponent implements OnInit{

  customers:Customer[]=[];
  isUpdate:boolean=true;

  constructor(private customerService :CustomerService){}

  ngOnInit(): void {
    this.listCustomer();
  }

  listCustomer(){
    this.customerService.getCustomerList().subscribe(data=>{
      this.customers=data;
      console.log(this.customers)
    })
  }

  deleteCustomer(id:number){
    this.customerService.DeleteCustomer(id).subscribe(()=>{
      console.log(id)
      this.listCustomer()
      
      Swal.fire({
              title: "¡Cliente Eliminado!",
              text: "El cliente se ha Eliminado exitosamente.",
              icon: "success",
              confirmButtonText: "Deleted"
            });

    },error=>{
      Swal.fire({
        title: "Error",
        text: "Hubo un problema al ELiminar el cliente.",
        icon: "error",
        confirmButtonText: "Cerrar"
            });
    }
  
  )
  }

  public changeUpdate(){
    this.isUpdate=true;
  }
  public changeADD(){
    this.isUpdate=false;
  }


}

import { Component, inject, OnInit } from '@angular/core';
import { CustomerServiceService } from '../../service/customer-service.service';
import { Customer } from '../../Model/customer';
import { CommonModule, DatePipe } from '@angular/common';
import { RouterModule } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list',
  imports: [CommonModule,RouterModule],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent implements OnInit {

  private service=inject(CustomerServiceService);

  customers:Customer[]=[];

  ngOnInit(): void {
    this.loadAll();
  
  }

  
  loadAll(){
    this.service.list().subscribe((x)=>{
      console.log(x)

      this.customers=x
    })
  }
  Delete(id:number){
    this.service.delete(id).subscribe({
       next:(x)=>{
              console.log(x)
              Swal.fire({
                title: "Good job!",
                text: "You clicked the button!",
                icon: "success"
              });
              this.loadAll();
            },error:()=>{
              Swal.fire({
                title: "Error!",
                text: "Ocurrio un error!",
                icon: "error"
              });}
    })
   
  }
}

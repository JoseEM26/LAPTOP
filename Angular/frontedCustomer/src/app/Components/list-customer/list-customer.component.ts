import { Component, inject, OnInit } from '@angular/core';
import { CustomerServiceService } from '../../Service/customer-service.service';
import { Customer } from '../../Model/customer';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { DatePipe } from '@angular/common';
import Swal from 'sweetalert2';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
  FormControlName,
} from '@angular/forms';
@Component({
  selector: 'app-list-customer',
  imports: [CommonModule, RouterModule, ReactiveFormsModule],
  templateUrl: './list-customer.component.html',
  styleUrl: './list-customer.component.css',
})
export class ListCustomerComponent implements OnInit {
  private service = inject(CustomerServiceService);
  private fb = inject(FormBuilder);

  customers: Customer[] = [];
  filtro!: FormGroup;

  ngOnInit(): void {
    this.filtro = this.fb.group({
      nombreFiltro: ['', Validators.required],
    });
    this.loadAll();
  }

  loadAll() {
    this.service.list().subscribe((arg) => {
      console.log(arg);
      this.customers = arg;
    });
  }

  fetchBYID() {
    const id=this.filtro.get("nombreFiltro")?.value;
    if(id==null || isNaN(id)){
     this.loadAll();
     console.log("recargaaa")
      
    }
    else{
      this.service.get(parseInt(id)).subscribe({
        next:(x)=>{
          console.log(x);
        this.customers=x?[x]:[];
        },error:(e)=>{
          console.log(e);
          Swal.fire("Error", "No se encontró el cliente", "error");
        }
      })
    }
  
    
  }

  delete(id: number) {
    this.service.delete(id).subscribe(() => {
      console.log('Se elimino ' + id);
      this.loadAll();

      Swal.fire({
        title: 'Eliminado',
        text: 'Se elimino Correctamente el id:!' + id,
        icon: 'success',
      });
    });
  }
}

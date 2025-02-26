import { Component, OnInit } from '@angular/core';
import { Customer } from '../../model/customer';
import { CustomerService } from '../../service/customer.service';

@Component({
  selector: 'app-customer-list',
  standalone: false,
  templateUrl: './customer-list.component.html',
  styleUrl: './customer-list.component.css'
})
export class CustomerListComponent implements OnInit{

  customers:Customer[]=[];
  ok:boolean=false

  constructor(private customerService :CustomerService){}

  ngOnInit(): void {
    this.listCustomer();
  }

  listCustomer(){
    this.customerService.getCustomerList().subscribe(data=>{
      this.customers=data;
      this.ok=true;
      console.log(this.customers)
    })
  }

}

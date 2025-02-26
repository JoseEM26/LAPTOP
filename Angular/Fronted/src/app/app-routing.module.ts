import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerListComponent } from './Component/customer-list/customer-list.component';
import { CustomerAddComponent } from './Component/customer-add/customer-add.component';

const routes: Routes = [
  {path:"",component:CustomerListComponent},
  {path:"customer/list",component:CustomerListComponent},
  {path:"customer/add",component:CustomerAddComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

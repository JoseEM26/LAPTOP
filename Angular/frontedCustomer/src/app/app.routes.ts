import { Routes } from '@angular/router';
import { ListCustomerComponent } from './Components/list-customer/list-customer.component';
import { FormComponent } from './Components/form/form.component';

export const routes: Routes = [
    {path:"list" , component:ListCustomerComponent},
    {path:"list/form" , component:FormComponent},
    {path:"list/form/:id" , component:FormComponent},
    {path:"" , redirectTo:"list" , pathMatch:'full'}
];

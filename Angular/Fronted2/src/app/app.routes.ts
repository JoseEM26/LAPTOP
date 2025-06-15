import { Routes } from '@angular/router';
import { ContactListComponent } from './Component/contact-list/contact-list.component';
import { FormComponent } from './Component/contact/form/form.component';

export const routes: Routes = [
    {path:"list" , component:ContactListComponent},
    {path:"form" , component:FormComponent},
    {path:"list/:id/edit" , component:FormComponent},
    {path:"" , redirectTo : "list" ,pathMatch:"full"},
];

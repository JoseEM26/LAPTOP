import { Routes } from '@angular/router';
import { ListComponent } from './Component/list/list.component';
import { FormComponent } from './Component/form/form.component';

export const routes: Routes = [
  {path:"list",component:ListComponent},
  {path:"list/form",component:FormComponent},
  {path:"list/put/:id",component:FormComponent},
  {path:"",redirectTo:"list",pathMatch:"full"},
];

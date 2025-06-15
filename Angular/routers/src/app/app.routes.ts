import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { RouterModule } from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CoursesComponent } from './courses/courses.component';
import { CoursesDetailsComponent } from './courses-details/courses-details.component';
import { ContactInfoComponent } from './contact-info/contact-info.component';
import { ContactDetailsComponent } from './contact-details/contact-details.component';

export const routes: Routes = [
    {
        path:'home',
        component:HomeComponent, 
    },
    {
        path:'contact',
        component:ContactComponent, 
        children :[
            {
                path :'contact/info', 
                component :ContactInfoComponent
            }
            ,
            {
                path:'contact/details',
                component:ContactDetailsComponent
            }
        ]
    },
    {
        path:'Course',
        component:CoursesComponent, 
    },
    {
        path:'contact/:course',
        component:CoursesDetailsComponent, 
    },
    {
        path:'about',
        component:AboutComponent, 
    },
    {
        path:'**',
        component:PageNotFoundComponent, 
    },{
        path:'',
        redirectTo:'/home',
        pathMatch:'full'
    }
];

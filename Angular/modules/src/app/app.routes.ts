import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadChildren: () =>
      import('./welcome/welcome.module').then((x) => x.WelcomeModule),
  },
  {
    path: 'course',
    loadChildren: () =>
      import('./course/course.module').then((x) => x.CourseModule),
  },
  {
    path: 'blogs',
    loadChildren: () =>
      import('./blog/blog.module').then((x) => x.BlogModule),
  }
];

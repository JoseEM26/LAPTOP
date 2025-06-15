import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter, RouterOutlet } from '@angular/router';

import { routes } from './app.routes';
import { CommonModule } from '@angular/common';
import { provideHttpClient } from '@angular/common/http';


export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({ eventCoalescing: true }), 
    provideRouter(routes),
    CommonModule,
    RouterOutlet    ,
    provideHttpClient()
  ]
};

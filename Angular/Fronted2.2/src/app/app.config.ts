import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter, RouterOutlet } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    RouterOutlet,
    provideHttpClient(),
    ReactiveFormsModule
  
  ]
};

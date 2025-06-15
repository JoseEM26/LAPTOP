import { TestBed } from '@angular/core/testing';

import { ServiceCUstomerService } from './service-customer.service';

describe('ServiceCUstomerService', () => {
  let service: ServiceCUstomerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceCUstomerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

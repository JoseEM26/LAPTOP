import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BucleComponent } from './bucle.component';

describe('BucleComponent', () => {
  let component: BucleComponent;
  let fixture: ComponentFixture<BucleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BucleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BucleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

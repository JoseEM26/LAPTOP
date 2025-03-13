import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMensajeComponent } from './add-mensaje.component';

describe('AddMensajeComponent', () => {
  let component: AddMensajeComponent;
  let fixture: ComponentFixture<AddMensajeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddMensajeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddMensajeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

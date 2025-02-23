import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMensajeComponent } from './list-mensaje.component';

describe('ListMensajeComponent', () => {
  let component: ListMensajeComponent;
  let fixture: ComponentFixture<ListMensajeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListMensajeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListMensajeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

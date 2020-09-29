import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalquestionsenterComponent } from './totalquestionsenter.component';

describe('TotalquestionsenterComponent', () => {
  let component: TotalquestionsenterComponent;
  let fixture: ComponentFixture<TotalquestionsenterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TotalquestionsenterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TotalquestionsenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

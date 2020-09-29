import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayalltestforuserComponent } from './displayalltestforuser.component';

describe('DisplayalltestforuserComponent', () => {
  let component: DisplayalltestforuserComponent;
  let fixture: ComponentFixture<DisplayalltestforuserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayalltestforuserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayalltestforuserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplaytestforuserfromtestidComponent } from './displaytestforuserfromtestid.component';

describe('DisplaytestforuserfromtestidComponent', () => {
  let component: DisplaytestforuserfromtestidComponent;
  let fixture: ComponentFixture<DisplaytestforuserfromtestidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplaytestforuserfromtestidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplaytestforuserfromtestidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

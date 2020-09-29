import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursefortestsetComponent } from './coursefortestset.component';

describe('CoursefortestsetComponent', () => {
  let component: CoursefortestsetComponent;
  let fixture: ComponentFixture<CoursefortestsetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoursefortestsetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursefortestsetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

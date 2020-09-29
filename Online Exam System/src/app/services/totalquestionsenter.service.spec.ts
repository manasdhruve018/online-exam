import { TestBed } from '@angular/core/testing';

import { TotalquestionsenterService } from './totalquestionsenter.service';

describe('TotalquestionsenterService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TotalquestionsenterService = TestBed.get(TotalquestionsenterService);
    expect(service).toBeTruthy();
  });
});

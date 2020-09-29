import { TestBed } from '@angular/core/testing';

import { TestentryService } from './testentry.service';

describe('TestentryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TestentryService = TestBed.get(TestentryService);
    expect(service).toBeTruthy();
  });
});

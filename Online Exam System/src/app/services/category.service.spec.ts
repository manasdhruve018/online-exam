import { TestBed } from '@angular/core/testing';

import { CategoryService } from '../services/category.service';

describe('UserinfoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CategoryService = TestBed.get(CategoryService);
    expect(service).toBeTruthy();
  });
});

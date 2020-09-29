import { TestBed } from '@angular/core/testing';

import { UserInfoService } from '../services/userinfo.service';

describe('UserinfoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserInfoService = TestBed.get(UserInfoService);
    expect(service).toBeTruthy();
  });
});

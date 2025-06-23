import { TestBed } from '@angular/core/testing';

import { StageIngService } from './stage-ing.service';

describe('StageIngService', () => {
  let service: StageIngService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StageIngService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

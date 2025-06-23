import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StageIngComponent } from './stage-ing.component';

describe('StageIngComponent', () => {
  let component: StageIngComponent;
  let fixture: ComponentFixture<StageIngComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StageIngComponent]
    });
    fixture = TestBed.createComponent(StageIngComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

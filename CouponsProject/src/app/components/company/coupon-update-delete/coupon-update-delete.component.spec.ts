import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CouponUpdateDeleteComponent } from './coupon-update-delete.component';

describe('CouponUpdateDeleteComponent', () => {
  let component: CouponUpdateDeleteComponent;
  let fixture: ComponentFixture<CouponUpdateDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CouponUpdateDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CouponUpdateDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

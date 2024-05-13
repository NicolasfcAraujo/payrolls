import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PayrollArticleComponent } from './payroll-article.component';

describe('PayrollArticleComponent', () => {
  let component: PayrollArticleComponent;
  let fixture: ComponentFixture<PayrollArticleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PayrollArticleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PayrollArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

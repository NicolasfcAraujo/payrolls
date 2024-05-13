import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeArticleComponent } from './employee-article.component';

describe('EmployeeArticleComponent', () => {
  let component: EmployeeArticleComponent;
  let fixture: ComponentFixture<EmployeeArticleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmployeeArticleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EmployeeArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

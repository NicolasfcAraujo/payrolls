import { Component } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { HeaderComponent } from '../../components/header/header.component';
import { PayrollArticleComponent } from '../../components/payroll-article/payroll-article.component';
import { PayrollListDTO } from '../../interfaces/payroll-list-dto';
import { PayrollService } from '../../services/payroll.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-employee-page',
  standalone: true,
  imports: [CommonModule, HeaderComponent, PayrollArticleComponent],
  templateUrl: './employee-page.component.html',
  styleUrl: './employee-page.component.css'
})
export class EmployeePageComponent {

  name: string = ""
  email: string = ""
  role: string = ""
  department: string = ""
  salary: number = 0
  phone: string = "0000000000000"
  hireDate: Date = new Date()
  payrolls: PayrollListDTO[] = []

  constructor(private employeeService: EmployeeService, private payrollService: PayrollService, private route: ActivatedRoute) {
    route.paramMap.subscribe((params: ParamMap) => {
      employeeService.findById(params.get("id")!).subscribe(value => {
        this.name = value.name
        this.email = value.email
        this.role = value.role
        this.department = value.department
        this.salary = value.salary
        this.phone = value.phone
        this.hireDate = value.hireDate
      })
      payrollService.findByEmployeeId(params.get("id")!).subscribe(values => {
        this.payrolls = values.map(value => {
          return {
            ...value,
            total: (value.salary + value.bonus) * (1 - value.taxes / 100)
          }
        })
      })
    })
  }
}

import { Component } from '@angular/core';
import { HeaderComponent } from '../../components/header/header.component';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { EmployeeService } from '../../services/employee.service';
import { switchMap, throttleTime } from 'rxjs';
import { PayrollService } from '../../services/payroll.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payroll',
  standalone: true,
  imports: [HeaderComponent, ReactiveFormsModule],
  templateUrl: './payroll.component.html',
  styleUrl: './payroll.component.css'
})
export class PayrollComponent {

  memberId: number = 0
  payrollForm = new FormGroup({
    memberEmail: new FormControl(""),
    salary: new FormControl(0),
    bonus: new FormControl(0),
    taxes: new FormControl(0)
  })

  constructor(
    private employeeService: EmployeeService, 
    private payrollService: PayrollService,
    private router: Router
  ){
    this.payrollForm.valueChanges.pipe(
      throttleTime(100),
      switchMap(value => {
        console.log(value)
        return employeeService.findByEmail(value.memberEmail!)
      })
    ).subscribe(value => {
      console.log(value)
      if (value != null) {
        this.payrollForm.controls["salary"].setValue(value.salary)
        this.memberId = value.id
      }
    })
  }

  create() {
    this.payrollService.create({
      salary: this.payrollForm.value.salary!,
      bonus: this.payrollForm.value.bonus!,
      paymentDate: new Date(),
      taxes: this.payrollForm.value.taxes!,
      employeeId: this.memberId
    }).subscribe(() => {
      this.router.navigateByUrl(`/team/${this.memberId}`)
    })
  }
}

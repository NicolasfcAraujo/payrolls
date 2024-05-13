import { Component } from '@angular/core';
import { HeaderComponent } from '../../components/header/header.component';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { EmployeeService } from '../../services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-member',
  standalone: true,
  imports: [HeaderComponent, ReactiveFormsModule],
  templateUrl: './add-member.component.html',
  styleUrl: './add-member.component.css'
})
export class AddMemberComponent {

  employeeForm = new FormGroup({
    name: new FormControl(""),
    email: new FormControl(""),
    role: new FormControl(""),
    department: new FormControl(""),
    salary: new FormControl(0),
    phone: new FormControl("")
  })

  constructor(private employeeService: EmployeeService, private router: Router){}

  create(){
    this.employeeService.create({
      name: this.employeeForm.value.name!,
      email: this.employeeForm.value.email!,
      role: this.employeeForm.value.role!,
      department: this.employeeForm.value.department!,
      salary: this.employeeForm.value.salary!,
      phone: this.employeeForm.value.phone!,
      hireDate: new Date()
    }).subscribe(value => {
      this.router.navigateByUrl("/team")
    })
  }
}

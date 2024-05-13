import { Component } from '@angular/core';
import { HeaderComponent } from '../../components/header/header.component';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Employee } from '../../interfaces/employee';
import { EmployeeService } from '../../services/employee.service';
import { switchMap } from 'rxjs';
import { EmployeeArticleComponent } from '../../components/employee-article/employee-article.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-team',
  standalone: true,
  imports: [CommonModule, HeaderComponent, ReactiveFormsModule, EmployeeArticleComponent],
  templateUrl: './team.component.html',
  styleUrl: './team.component.css'
})
export class TeamComponent {
  
  teamForm = new FormGroup({
    name: new FormControl(""),
    role: new FormControl(""),
    department: new FormControl(""),
    from: new FormControl(new Date(1970, 0, 1).toISOString()),
    to: new FormControl(new Date().toISOString())
  })
  employees: Employee[] = []

  constructor(private employeeService: EmployeeService){
    employeeService.findAll().subscribe(value => {
      this.employees = value
    })

    this.teamForm.valueChanges
    .pipe(
      switchMap(value => {
        return employeeService.filter({
          name: value.name!,
          role: value.role!,
          department: value.department!,
          from: value.from!,
          to: value.to!
        })
      })
    )
    .subscribe(value => {
      this.employees = value
    })
  }
}

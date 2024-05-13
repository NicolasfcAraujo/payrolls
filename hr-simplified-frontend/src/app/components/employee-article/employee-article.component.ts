import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-article',
  standalone: true,
  imports: [],
  templateUrl: './employee-article.component.html',
  styleUrl: './employee-article.component.css'
})
export class EmployeeArticleComponent {
  @Input() name: String = "Name"
  @Input() role: String = "Role"
  @Input() department: String = "Department"
  @Input() id: number = 0

  constructor(private router: Router){}

  navigate(){
    this.router.navigateByUrl(`/team/${this.id}`)
  }
}

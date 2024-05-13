import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { EmployeePageComponent } from './pages/employee-page/employee-page.component';
import { TeamComponent } from './pages/team/team.component';
import { LoginComponent } from './pages/login/login.component';
import { PayrollComponent } from './pages/payroll/payroll.component';
import { authGuard } from './guards/auth.guard';
import { AddMemberComponent } from './pages/add-member/add-member.component';

export const routes: Routes = [
  { path: "", component: HomeComponent, title: "Payrolls | Home", canActivate: [ authGuard ] },
  { path: "team", component: TeamComponent, title: "Payrolls | Team", canActivate: [ authGuard ] },
  { path: "team/:id", component: EmployeePageComponent, title: "Payrolls | Member" },
  { path: "payroll", component: PayrollComponent, title: "Payrolls | Create", canActivate: [ authGuard ] },
  { path: "add-member", component: AddMemberComponent, title: "Payrolls | Add Member", canActivate: [ authGuard ] },
  { path: "login", component: LoginComponent, title: "Payrolls | Login" }
];

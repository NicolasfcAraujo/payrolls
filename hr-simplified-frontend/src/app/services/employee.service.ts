import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../interfaces/employee';
import { environment } from '../../environments/environment';
import { EmployeeDTO } from '../interfaces/employee-dto';
import { FilterDTO } from '../interfaces/filter-dto';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  findAll(){
    return this.http.get<Employee[]>(`${environment.api}/employee`)
  }

  findById(id: string){
    return this.http.get<Employee>(`${environment.api}/employee/${id}`)
  }

  findByEmail(email: string){
    return this.http.get<Employee>(`${environment.api}/employee/email/${email}`)
  }

  filter(args: FilterDTO) {
    return this.http.post<Employee[]>(`${environment.api}/employee/filter`, args)
  }

  create(args: EmployeeDTO) {
    return this.http.post<Employee>(`${environment.api}/employee`, {
      name: args.name,
      email: args.email,
      role: args.role,
      department: args.department,
      salary: args.salary,
      phone: args.phone,
      hireDate: args.hireDate
    })
  }

  update(args: EmployeeDTO, id: string) {
    return this.http.patch<Employee>(`${environment.api}/employee/${id}`, {
      name: args.name,
      email: args.email,
      role: args.role,
      department: args.department,
      salary: args.salary,
      phone: args.phone,
      hireDate: args.hireDate
    })
  }

  delete(id: string) {
    return this.http.delete<string>(`${environment.api}/employee/${id}`)
  }
}

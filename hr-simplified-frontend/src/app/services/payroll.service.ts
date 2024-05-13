import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Payroll } from '../interfaces/payroll';
import { environment } from '../../environments/environment';
import { PayrollDTO } from '../interfaces/payroll-dto';

@Injectable({
  providedIn: 'root'
})
export class PayrollService {

  constructor(private http: HttpClient) { }

  findAll(){
    return this.http.get<Payroll[]>(`${environment.api}/payroll`)
  }

  findById(id: string){
    return this.http.get<Payroll>(`${environment.api}/payroll/${id}`)
  }

  findByEmployeeId(id: string) {
    return this.http.get<Payroll[]>(`${environment.api}/payroll/employee/${id}`)
  }

  create(args: PayrollDTO) {
    return this.http.post<Payroll>(`${environment.api}/payroll`, {
      salary: args.salary,
      bonus: args.bonus,
      taxes: args.taxes,
      paymentDate: args.paymentDate,
      employeeId: args.employeeId
    })
  }

  update(args: PayrollDTO, id: string) {
    return this.http.patch<Payroll>(`${environment.api}/payroll/${id}`, {
      salary: args.salary,
      bonus: args.bonus,
      taxes: args.taxes,
      paymentDate: args.paymentDate
    })
  }

  delete(id: string) {
    return this.http.delete<string>(`${environment.api}/payroll/${id}`)
  }
}

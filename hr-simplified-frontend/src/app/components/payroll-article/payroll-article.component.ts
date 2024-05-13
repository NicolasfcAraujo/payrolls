import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import jsPDF from 'jspdf';

@Component({
  selector: 'app-payroll-article',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './payroll-article.component.html',
  styleUrl: './payroll-article.component.css'
})
export class PayrollArticleComponent {

  @Input() employeeName: string = ""
  @Input() paymentDate: Date = new Date()
  @Input() salary: number = 0
  @Input() bonus: number = 0
  @Input() taxes: number = 0
  @Input() total: number = 0
  isOpen: boolean = false

  toggle(){
    this.isOpen = !this.isOpen
  }

  downloadPDF() {
    const doc = new jsPDF();
    const data = {
      employeeName: this.employeeName,
      paymentDate: this.paymentDate,
      total: this.total,
      salary: this.salary,
      bonus: this.bonus,
      taxes: this.taxes
    };
    const content = `
      Issuer: Payrolls
      Employee: ${data.employeeName}
      -------------------------------
      Payment: ${data.paymentDate}
      Total: $${data.total}

      Detalhes:
      - Salary: $${data.salary}
      - Bonus: $${data.bonus}
      - Tax: ${data.taxes}%
    `;
    doc.text(content, 10, 10);
    doc.save(`payroll_${this.employeeName.split(" ")[0]}_${this.employeeName.split(" ")[this.employeeName.split(" ").length - 1]}.pdf`);
  }
}

import { Component, OnInit } from '@angular/core';
import { BankService } from '../bank.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-account-records',
  templateUrl: './account-records.component.html',
  styleUrls: ['./account-records.component.css']
})
export class AccountRecordsComponent implements OnInit {

  record = [];

  constructor(private bankService: BankService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.getRecords();
  }

  getRecords(): void {
    this.bankService.getRecords(2).subscribe(data => this.record = data);
  }

  onNewRecord() {
    this.router.navigate(['new'], {relativeTo: this.route});
  }
}

import { Component, OnInit } from '@angular/core';
import { BankService } from '../bank.service';

@Component({
  selector: 'app-account-information',
  templateUrl: './account-information.component.html',
  styleUrls: ['./account-information.component.css']
})
export class AccountInformationComponent implements OnInit {

  account: Account;

  constructor(private bankService: BankService) {}

  ngOnInit() {
    this.getAccount();
  }

  getAccount(): void {
    this.bankService.getAccount(2).subscribe(data => this.account = data);
  }

}

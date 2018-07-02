import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { BankService } from '../../bank.service';
import { Record } from '../../record';

@Component({
  selector: 'app-new-record',
  templateUrl: './new-record.component.html',
  styleUrls: ['./new-record.component.css']
})
export class NewRecordComponent implements OnInit {
  types = ['DEPOSIT', 'WITHDRAWAL'];
  record = new Record(0, '');
  submitted = false;

  constructor(private bankService: BankService, private location: Location) { }


  onSubmit() {
    this.submitted = true;
    this.bankService.addRecordToAccount(2, this.record).subscribe();
    console.log(this.record);
  }

  reset() { this.record = new Record(0, ''); }

  goBack(): void {
    this.location.back();
  }

  ngOnInit() {
  }


}

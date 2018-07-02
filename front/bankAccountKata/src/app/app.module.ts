import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { BankService } from './bank.service';
import { AccountInformationComponent } from './account-information/account-information.component';
import { AccountRecordsComponent } from './account-records/account-records.component';
import { AppRoutingModule } from './app-routing.module';
import { HeaderComponent } from './header/header.component';
import { NewRecordComponent } from './account-records/new-record/new-record.component';
import { FormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    AccountInformationComponent,
    AccountRecordsComponent,
    HeaderComponent,
    NewRecordComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [BankService],
  bootstrap: [AppComponent]
})
export class AppModule { }

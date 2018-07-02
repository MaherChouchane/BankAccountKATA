import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AccountInformationComponent } from './account-information/account-information.component';
import { AccountRecordsComponent } from './account-records/account-records.component';
import { NewRecordComponent } from './account-records/new-record/new-record.component';

const routes: Routes = [
  { path: '', redirectTo: '/account', pathMatch: 'full' },
  { path: 'account', component: AccountInformationComponent },
  { path: 'account/records', component: AccountRecordsComponent },
  { path: 'account/records/new', component: NewRecordComponent }
];
@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class AppRoutingModule { }

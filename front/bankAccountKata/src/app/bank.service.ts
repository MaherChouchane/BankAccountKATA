import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Record } from './record';
import { catchError, map, tap } from 'rxjs/operators';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class BankService {
  private bankUrl = 'http://localhost:8080/bankAccount';

  constructor(private http: HttpClient) { }

  getAccount(id: number): Observable<any> {
    const url = `${this.bankUrl}/${id}`;
    return this.http.get<any>(url);
  }

  getRecords(id: number): Observable<any> {
    const url = `${this.bankUrl}/${id}/records`;
    return this.http.get<any>(url);
  }

  addRecordToAccount(id: number, record: Record): Observable<any> {
    const url = `${this.bankUrl}/${id}/record/add`;
    return this.http.post<any>(url, record, httpOptions);
  }

}

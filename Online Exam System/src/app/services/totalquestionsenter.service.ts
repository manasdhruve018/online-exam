import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import{TotalQuestions} from '../models/totalQuestions';
@Injectable({
  providedIn: 'root'
})
export class TotalquestionsenterService {

  totalQuestions:TotalQuestions;
  url= 'http://localhost:9097/allquestions/save';
  constructor(private http: HttpClient) { }

  addQuestions (totalQuestions : TotalQuestions): Observable<TotalQuestions> {
    return this.http.post<TotalQuestions>(this.url, totalQuestions);
  }
  
}
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { TestInfo} from '../models/TestInfo';
@Injectable()
export class QuizService {

  constructor(private http: HttpClient) { }
  url="http://localhost:9097/allquestions/fetchbytest";
  urlSave='http://localhost:9097/testinfo/save';
  urlUpdate='http://localhost:9097/testinfo/updatemarks';
  get(url: string) {
    return this.http.get(url);
  }

  getAll() {
    return [
      { id: 'data/aspnet.json', name: 'Asp.Net' },
      { id: 'data/csharp.json', name: 'C Sharp' },
      { id: 'data/designPatterns.json', name: 'Design Patterns' }
    ];
  }

  getAllTest(testID:number):Observable<any>{
    return this.http.get(`${this.url}/${testID}`);
  }

  addTestInfo (test : TestInfo):any {
    return this.http.post< TestInfo>(this.urlSave, test);
  }

  updateTestMarks(marks:number, answer:string,queid:number,any) :any{
    return this.http.put(`${this.urlUpdate}/${marks}/${answer}/${queid}`,any );
  }

}
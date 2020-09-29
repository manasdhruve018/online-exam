import { Injectable } from '@angular/core';
import {Test} from '../models/Test';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TestentryService {
  test:Test;
  urlSave= 'http://localhost:9097/test/save';
  urlTestID= 'http://localhost:9097/test/id';
  urlGet='http://localhost:9097/test/get';
  urlTestAll='http://localhost:9097/test/get';
  urlFindTestById='http://localhost:9097/test/findallbytestid';
  constructor(private http: HttpClient) { }

  addTests(test:Test) : Observable<Test>{
    return this.http.post<Test>(this.urlSave, test);
  }

  getTestID(categoryID: number, userID: string): Observable<any>{
    console.log(this.http.get(`${this.urlTestID}/${categoryID}/${userID}`));
    return this.http.get(`${this.urlTestID}/${categoryID}/${userID}`);
  }

  getTestIDTwo(categoryID: number): Observable<any>{
    return this.http.get(`${this.urlTestID}/${categoryID}`);
  }
  
  getTests(): Observable <any>{
    return this.http.get(this.urlGet);
  }

  setSessionCategoryId(id:string):void{
    sessionStorage.setItem('categoryId',id);
  }

  setSessionForTotalQue(questions:string){
    sessionStorage.setItem('totque',questions);
  }

  setSessionForTopicName(topic:string){
    sessionStorage.setItem('topic',topic);
  }

  setSessionForCategory(cat:string){
    sessionStorage.setItem('cat',cat);
  }

  setSessionForSubCategory(subcat:string){
    sessionStorage.setItem('subcat',subcat);
  }

  setSessionForDuration(duration:string){
    sessionStorage.setItem('duration',duration);
  }

  getSessionCategoryId(){
    return sessionStorage.getItem('categoryId');
  }

  getSessionForTotalQue(){
    return sessionStorage.getItem('totque');
  }
  getSessionForDuration(){
    return sessionStorage.getItem('duration');
  }

  getSessionForTopicName(){
    return sessionStorage.getItem('topic');
  }

  getSessionForCategory(){
    return sessionStorage.getItem('cat');
  }

  getSessionForSubCategory(){
    return sessionStorage.getItem('subcat');
  }

  getAllTests():Observable<any>{
    return this.http.get(this.urlTestAll);
  }

  findTestByTestId(testId:number):Observable<any>{
    return this.http.get(`${this.urlFindTestById}/${testId}`);
  }
}
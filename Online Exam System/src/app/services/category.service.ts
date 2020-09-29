import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../models/Category';


@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  category : Category;
  data : any = {};
  urlSave= 'http://localhost:9097/category/save';
  urlGet= 'http://localhost:9097/category/get';
  urlTopic='http://localhost:9097/category/topics/topic_name';
  urlCategory='http://localhost:9097/category/course';
  urlSubCategory='http://localhost:9097/category/subcategory';
  urlID = 'http://localhost:9097/category/id';
    constructor(private http: HttpClient) { }
  
    getCategory(): any{
      return this.http.get(this.urlGet);
    }

    addCategory (category : Category): Observable<Category> {
      return this.http.post<Category>(this.urlSave, category);
    }

    getTopicName():Observable<any>{
      return this.http.get(this.urlTopic);
    }

    getCategoryFromTopic(topic:string) : Observable<any>{
      return this.http.get(`${this.urlCategory}/${topic}`);
    }

    getSubtopicFromCategory(category:string): Observable<any>{
      return this.http.get(`${this.urlSubCategory}/${category}`);
    }

    getCategoryID(category:string,subcategory:string):Observable<any>{
      return this.http.get(`${this.urlID}/${category}/${subcategory}`);
    }
    /**/

    setSessionTestId(id:any):void{
      sessionStorage.setItem('testId',id);
    }

    getSessionTestId(){
      return sessionStorage.getItem('testId');
    }

    setDuration(duration:any):void{
      sessionStorage.setItem('duration',duration);
    }

    getDuration(){
      return sessionStorage.getItem('duration');
    }
  }
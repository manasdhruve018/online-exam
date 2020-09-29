import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserInfo } from '../models/UserInfo';

@Injectable({
  providedIn: 'root'
})
export class UserInfoService {
  user : UserInfo;
  data : any = {};
  data2=UserInfo;
  urlSave= 'http://localhost:9097/userinfo/save';
  urlGet= 'http://localhost:9097/userinfo/get';
  urlUser='http://localhost:9097/userinfo/uniqueuser';
  urlLogin = 'http://localhost:9097/userinfo/userloggedin';

    constructor(private http: HttpClient) { }
  
    getUser(): Observable <any>{
      return this.http.get(this.urlGet);
    }

    addUser (user : UserInfo): Observable<UserInfo> {
      return this.http.post<UserInfo>(this.urlSave, user);
    }

    isUniqueUser(username:string):Observable<any>{
      return this.http.get(`${this.urlUser}/${username}`);
    }

    isAuthenticatedUser(username: string, password: string, usertype: string): Observable<any>{
      return this.http.get(`${this.urlLogin}/${username}/${password}/${usertype}`)
    }

    setSession(name:string):void{
      sessionStorage.setItem('name',name);
    }
    getSession():string{
      return sessionStorage.getItem('name');
    }
    
  }
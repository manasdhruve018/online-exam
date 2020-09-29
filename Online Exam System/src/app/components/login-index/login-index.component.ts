import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserInfo } from '../../models/UserInfo';
import { UserInfoService} from '../../services/userinfo.service';

@Component({
  selector: 'app-login-index',
  templateUrl: './login-index.component.html',
  styleUrls: ['./login-index.component.css']
})
export class LoginIndexComponent implements OnInit {
  temp: Boolean;
  user: UserInfo=new UserInfo();
  userinfo : Array<any>;
  loginForm: FormGroup;
  constructor(private router: Router,private http: UserInfoService) { }
  register(){
    this.router.navigate(['/formdemo']);

  }
  admindashboard(){
    this.router.navigate(['/admindashboard']);
  }
  userdashboard(){
    this.router.navigate(['/userdashboard']);
  }
  ngOnInit() {
    this.loginForm = new FormGroup({
      userType:new FormControl(null, Validators.required),
      userName:new FormControl(null, Validators.required),
      password: new FormControl(null, [Validators.required, Validators.maxLength(8)]),
    });
  }

  loginUser(){
    this.user.userType=this.loginForm.value.userType;
    this.user.userName=this.loginForm.value.userName;
    this.user.password=this.loginForm.value.password;

    this.http.isAuthenticatedUser(this.user.userName,this.user.password,this.user.userType).subscribe(data2 => console.log(data2), error => console.log(error));
    this.http.isAuthenticatedUser(this.user.userName,this.user.password,this.user.userType).subscribe(data2 => this.temp=data2);
    
    if(this.temp==true && this.user.userType=="admin"){
      this.http.setSession(this.user.userName);
      this.admindashboard();
    }

    else if(this.temp==true && this.user.userType=="user"){
      this.http.setSession(this.user.userName);
      this.userdashboard();
    }
    
  }
}

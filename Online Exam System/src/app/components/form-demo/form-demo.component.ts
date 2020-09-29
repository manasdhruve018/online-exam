import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserInfo } from '../../models/UserInfo';
import { UserInfoService} from '../../services/userinfo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-demo',
  templateUrl: './form-demo.component.html',
  styleUrls: ['./form-demo.component.css']
})
export class FormDemoComponent implements OnInit {
  user: UserInfo=new UserInfo();
  user2: UserInfo=new UserInfo();
  loginForm: FormGroup;
  userinfo : Array<any>;
  userselected:Boolean=false;
  status1:any;
  email:string;
  register:Boolean;
  submitted = false;
  constructor(private http: UserInfoService, private router: Router){}
  ngOnInit() {
    this.loginForm = new FormGroup({
      fName: new FormControl(null,[Validators.required, Validators.minLength(3),Validators.pattern('[a-zA-Z ]*')]),
      lName : new FormControl(null, Validators.required),
      contactNo: new FormControl(null, [Validators.required,Validators.maxLength(10)]),
      email: new FormControl(null, Validators.required),
      gender: new FormControl(null, Validators.required),
      dob: new FormControl(null, Validators.required),
      country:new FormControl(null, Validators.required),
      userType:new FormControl(null, Validators.required),
      userName:new FormControl(null, Validators.required),
      password: new FormControl(null, [Validators.required, Validators.maxLength(8)]),
      cpassword: new FormControl(null, [Validators.required, Validators.maxLength(8)])
    });
   /* this.http.getUser().subscribe(data => this.userinfo=data, error => console.log(error));*/
  }
  newUserInfo(): void {
    this.submitted = false;
    this.user2 = new UserInfo();
  }
  loginUser() {  
   
    
    this.http.isUniqueUser(this.user.userName).subscribe(data3 => this.status1=data3, error => console.log(error));;
    console.log(this.status1);
    this.loginUser2();
   
   /*else{
     console.log(this.user);
    console.log(this.email);
     this.submitted = true;
      console.log(this.status1);
      this.http.addUser(this.user).subscribe(data => console.log(data), error => console.log(error));
      console.log(this.loginForm.status);
      console.log(this.loginForm.value);
    }*/
    
  }

  loginUser2() {
    if(this.status1==true){
      this.userselected=true;
      this.register=true;

    }  
    if(this.status1==false){
      this.register=false;
    }
    console.log(this.userselected);
    this.loginUser3();
    
  }


  loginUser3(){
    if(this.userselected==false && this.register==false){

      console.log("fname " + this.user.fName);
      console.log("lname " +this.user.lName);
      console.log("email " +this.user.email);
      console.log("gender " +this.user.gender);
      console.log("gender " + this.user.dob);
      console.log("country " + this.user.country);
      console.log("contact " +this.user.contactNo);
      console.log("password " +this.user.password);
      console.log("username " +this.user.userName);
      console.log("usertype " +this.user.userType);
      this.user2.userType=this.user.userType;
      this.user2.fName=this.user.fName;
      this.user2.lName=this.user.lName;
      this.user2.gender=this.user.gender;
      this.user2.email=this.user.email;
      this.user2.country=this.user.country;
      this.user2.contactNo=this.user.contactNo;
      this.user2.dob=this.user.dob;
      this.user2.userName=this.user.userName;
      this.user2.password=this.user.password;

      this.submitted = true;
      console.log(this.status1);
      this.http.addUser(this.user2).subscribe(data2 => console.log(data2), error => console.log(error));
      this.user2=new UserInfo();
      
      if(this.user2.userType=="admin"){
        this.router.navigate(['/admindashboard']);
      }
      else if(this.user2.userType="user"){
        this.router.navigate(['/userdashboard']);
      }
      
      console.log(this.loginForm.status);
      console.log(this.loginForm.value);
 
    }
  }
}

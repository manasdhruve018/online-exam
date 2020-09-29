import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserInfoService} from '../../services/userinfo.service';
@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {

  constructor(private router: Router,private http: UserInfoService) { }
  session:string=this.http.getSession();
  try:string;
  ngOnInit() {
    this.try=this.session;
    if(this.session==null){
      this.router.navigate(['/']);
    }
    console.log(this.try);
  }

  register(){
    this.router.navigate(['/formdemo']);

  }
  questions(){
    this.router.navigate(['/selectcourse']);
  }

  category(){
    this.router.navigate(['/category']);
  }

  result(){
    this.router.navigate(['/result']);
  }

  logout(){
    sessionStorage.clear();
    this.router.navigate(['/']);
  }

}

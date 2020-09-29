import { Component, OnInit } from '@angular/core';
import { UserInfoService} from '../../services/userinfo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {

  constructor(private http: UserInfoService, private router: Router) { }
  session:string=this.http.getSession();
  try:string;
  ngOnInit() {
    this.try=this.session;
    console.log(this.try);
    if(this.session==null){
      this.router.navigate(['/']);
    }
  }

  logout(){
    sessionStorage.clear();
    this.router.navigate(['/']);
  }

  category(){
    this.router.navigate(['/category']);
  }

  test(){
    this.router.navigate(['/displkayalltestforuser']);
  }
}

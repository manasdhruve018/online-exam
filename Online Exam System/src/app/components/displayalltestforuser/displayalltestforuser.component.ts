import { Component, OnInit } from '@angular/core';
import {TestentryService} from '../../services/testentry.service';
import {Test} from '../../models/Test';
import {CategoryService } from '../../services/category.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-displayalltestforuser',
  templateUrl: './displayalltestforuser.component.html',
  styleUrls: ['./displayalltestforuser.component.css']
})
export class DisplayalltestforuserComponent implements OnInit {
  tests:Test;
  constructor(private router: Router,private http3: CategoryService,private http:TestentryService,private http2: TestentryService) { }

  ngOnInit() {
    this.http.getAllTests().subscribe(data =>this.tests =data, error => console.log(error));
  }

  startTest(testid:number,duration:number){
    this.http3.setSessionTestId(testid);
    this.http3.setDuration(duration);
    if(this.http3.getSessionTestId==null){
      this.http3.setSessionTestId(testid);
      this.http3.setDuration(duration);
    }
    else{
      this.router.navigate(['/quiz2']);
    }
  }
}

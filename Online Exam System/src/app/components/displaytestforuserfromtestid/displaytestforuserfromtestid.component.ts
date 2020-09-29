import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Test} from '../../models/Test';
import {CategoryService } from '../../services/category.service';
import {TestentryService} from '../../services/testentry.service';
@Component({
  selector: 'app-displaytestforuserfromtestid',
  templateUrl: './displaytestforuserfromtestid.component.html',
  styleUrls: ['./displaytestforuserfromtestid.component.css']
})
export class DisplaytestforuserfromtestidComponent implements OnInit {
  tests:Test=new Test();
  test2:any;
  testid:any;
  constructor(private router: Router,private http3: CategoryService,private http:TestentryService) { }

  ngOnInit() {
    this.testid=this.http3.getSessionTestId();
    console.log(this.testid);
    this.http.findTestByTestId(1).subscribe(data =>this.tests =data, error => console.log(error));
   console.log(this.tests.testID);
  }

}

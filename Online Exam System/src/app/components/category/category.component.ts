import { Component, OnInit } from '@angular/core';
import {CategoryService } from '../../services/category.service';
import {TestentryService } from '../../services/testentry.service';
import { Category } from 'src/app/models/Category';
import { Test } from 'src/app/models/Test';
import { Router } from '@angular/router';
import { UserInfoService } from 'src/app/services/userinfo.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  category: Category= new Category();
  category2:Category;
  test: Test= new Test();
  test2: Test = new Test();
  cat : Array<any>;
  testid:number;
  constructor(private http: CategoryService, private http2: TestentryService, private router: Router, private userSession: UserInfoService) { }

  ngOnInit() {

    this.http.getCategory().subscribe(data => this.category2=data, error => console.log(error));
    
    
  }

  takeTest(categoryId:number){
    this.category.categoryID=categoryId;
    console.log(this.category.categoryID);
    this.http2.getTestIDTwo(this.category.categoryID).subscribe(data2 => this.testid=data2, error => console.log(error));
    /*
    this.router.navigate(['/quiz2']);*/
    this.test2.testID=this.testid;
    this.fetchId();
   
  }

  fetchId(){
    console.log(this.test2.testID);
    if(this.test2.testID==null || this.test2.testID==undefined){
      this.http2.getTestIDTwo(this.category.categoryID).subscribe(data2 => this.testid=data2, error => console.log(error));
       this.test2.testID=this.testid;
       console.log(this.test2.testID);
    }
    else{
      this.http.setSessionTestId(this.test2.testID);
      this.router.navigate(['/displaytestforuserfromtestid']);
    }
  }
}

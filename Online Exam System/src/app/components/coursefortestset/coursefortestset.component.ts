import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/models/Category';
import {CategoryService } from '../../services/category.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import {Test} from '../../models/Test';
import {TestentryService} from '../../services/testentry.service';
import { UserInfoService} from '../../services/userinfo.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-coursefortestset',
  templateUrl: './coursefortestset.component.html',
  styleUrls: ['./coursefortestset.component.css']
})
export class CoursefortestsetComponent implements OnInit {

  check:number;
  category: Category = new Category();
  catSave: Category = new Category();
  test:Test=new Test();
  category2:Category;
  topicselected:string;
  courseselected1:string;
  category3: Category[];
  category4:Category[];
  cat : Array<any>;
  topic:string;
  id: number;
  loginForm: FormGroup;
  constructor(private http: CategoryService,private http2:TestentryService,private http3: UserInfoService,private router: Router) { }

  ngOnInit() {
    
    /*this.http.getCategory().subscribe(data => this.category=data, error => console.log(error));*/
    this.http.getTopicName().subscribe(data2 =>this.category2=data2 , error => console.log(error));
   //this.topic="technical";
   
  }

  loadSubCourse(value)
  {
    this.topicselected=value;
    this.http.getCategoryFromTopic(this.topicselected).subscribe(data3 => this.category3=data3, error => console.log(error));
    console.log(this.topicselected);
  }

  loadSubCategory(value){
    this.courseselected1=value;
    this.http.getSubtopicFromCategory(this.courseselected1).subscribe(data4 => this.category4=data4 ,error => console.log(error));
    console.log(this.courseselected1);
  }

  
  // submitQuestionDetails(){
  //   this.catSave.topicName=this.category.topicName;
  //   this.catSave.categoryName=this.category.categoryName;
  //   this.catSave.sub_catName=this.category.sub_catName;
    
  //   /*this.http.addCategory(this.catSave).subscribe();*/
  //   this.http.getCategoryID(this.catSave.categoryName,this.catSave.sub_catName).subscribe(data => this.id=data ,error => console.log(error));
  //   this.test.categoryID=this.id;
  //   console.log(this.test.categoryID);
  //   this.test.userID=this.http3.getSession();
  //   this.http2.addTests(this.test).subscribe(data2 => console.log(data2), error => console.log(error));
  //   console.log(this.id);
  //   this.http2.setSessionCategoryId(this.id.toString());
  //   this.http2.setSessionForDuration(this.test.duration.toString());
  //   this.http2.setSessionForTotalQue(this.test.totalQuestions.toString());
  //   this.router.navigate(['/questionenter']);
  // }


  submitQuestionDetails(){
    this.catSave.topicName=this.category.topicName;
    this.catSave.categoryName=this.category.categoryName;
    this.catSave.sub_catName=this.category.sub_catName;
    
    /*this.http.addCategory(this.catSave).subscribe();*/
    this.http.getCategoryID(this.catSave.categoryName,this.catSave.sub_catName).subscribe(data => this.id=data ,error => console.log(error));
    this.test.categoryID=this.id;
    this.test.userID=this.http3.getSession();
    this.QuestionsDetails();
    
  }

  QuestionsDetails(){
    if(this.test.categoryID.toString()=="undefined"){
      this.http.getCategoryID(this.catSave.categoryName,this.catSave.sub_catName).subscribe(data => this.id=data ,error => console.log(error));
      this.test.categoryID=this.id; 
      console.log("FIRST if");
    }
    if(this.test.categoryID!=0){
      this.http2.addTests(this.test).subscribe(data2 => console.log(data2), error => console.log(error));
      console.log(this.test.categoryID);
      this.http2.setSessionCategoryId(this.id.toString());
      this.http2.setSessionForDuration(this.test.duration.toString());
      this.http2.setSessionForTotalQue(this.test.totalQuestions.toString());
      console.log("SECOND if");
      this.router.navigate(['/questionenter']);
    }
  }
}
import { Component, OnInit } from '@angular/core';
import { TotalQuestions} from '../../models/totalQuestions';
import { QuizService } from '../../services/quiz.service';
import{TestInfo} from '../../models/TestInfo';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import {UserInfoService} from 'src/app/services/userinfo.service';
@Component({
  selector: 'app-quiz2',
  templateUrl: './quiz2.component.html',
  styleUrls: ['./quiz2.component.css']
})
export class Quiz2Component implements OnInit {
  testID: any;
  testinfo:TestInfo=new TestInfo();
  allquestions:any [];
  allquestion2:any[];
  mode = 'quiz';
  timer: any = null;
  startTime: Date;
  endTime: Date;
  ellapsedTime = '00:00';
  duration = '';
  configduration:any ;
  answerselected:string;
  actualanswer:string;
  finalmarks:number=0;
  totalmarks:number=0;
  markprint:string;
  allmarkedquestions:any=[];
  currentquestionid:number;
 markobtained:number;
 firstclick:boolean=false;
 markofarray:any;




  constructor(private http: QuizService, private router:Router, private cat: CategoryService,private userinfo:UserInfoService) {
    this.configduration=this.cat.getDuration();
    this.startTime = new Date();
      this.timer = setInterval(() => { this.tick(); }, 1000);
      this.duration = this.parseTime(this.configduration*60);
    
  }
  ngOnInit() {
    this.testID=this.cat.getSessionTestId();
    console.log(this.testID);
    this.http.getAllTest(this.testID).subscribe(data => this.allquestions=data, error => console.log(error));
    this.allmarkedquestions.push(0);
  }
  tick() {
    const now = new Date();
    const diff = (now.getTime() - this.startTime.getTime()) / 1000;
    if (diff >= this.configduration*60) {
      this.submit();
    }
    this.ellapsedTime = this.parseTime(diff);
  }

  parseTime(totalSeconds: number) {
    let mins: string | number = Math.floor(totalSeconds / 60);
    let secs: string | number = Math.round(totalSeconds % 60);
    mins = (mins < 10 ? '0' : '') + mins;
    secs = (secs < 10 ? '0' : '') + secs;
    return `${mins}:${secs}`;
  }
 
  select(value:string,mark:number,answer:string,id:number){
    this.currentquestionid=id;
    console.log("how many time printed " + this.currentquestionid);
    
    console.log("how many time printed array " + this.allmarkedquestions);
    console.log(id in this.allmarkedquestions || id==this.allmarkedquestions[0]);
    if(this.currentquestionid in this.allmarkedquestions && value==answer ){
      this.answerselected=value;
      this.markobtained=mark;
      this.http.updateTestMarks(this.markobtained,this.answerselected,this.currentquestionid,null).subscribe(data2 => console.log(data2), error => console.log(error));

    }
    else if(this.currentquestionid in this.allmarkedquestions && value!=answer ){
      this.answerselected=value;
      this.markobtained=0;
      this.http.updateTestMarks(this.markobtained,this.answerselected,this.currentquestionid,null).subscribe(data2 => console.log(data2), error => console.log(error));

    }
    else {
      
      this.firstclick=true;
      this.allmarkedquestions.push(this.currentquestionid);
      if(value==answer){
        this.answerselected=value;
        console.log(answer);
       
        console.log("if of only else"+ this.firstclick +"array" + this.allmarkedquestions);
        this.testinfo.questionId=id;
        this.testinfo.marks=mark;
        this.testinfo.answer=this.answerselected;
        this.testinfo.testId=this.testID;
        this.testinfo.userName=this.userinfo.getSession();
        console.log(this.testinfo.userName + this.testinfo.testInfoId);
        this.http.addTestInfo(this.testinfo).subscribe(data =>console.log(data), error => console.log(error));
        
      }
      else {
        this.answerselected=value;
        console.log("else of only else"+ this.firstclick +"array" + this.allmarkedquestions);
        this.testinfo.questionId=id;
        this.testinfo.marks=0;       
        this.testinfo.answer=this.answerselected;
        this.testinfo.userName=this.userinfo.getSession();
        this.testinfo.testId=this.testID;
        console.log(this.testinfo.userName + this.testinfo.testInfoId);
        this.http.addTestInfo(this.testinfo).subscribe(data =>console.log(data), error => console.log(error));
      }
      
    }
    
    
    
   
  }

  submit(){
   
    this.router.navigate(['/userdashboard']);
  }
}
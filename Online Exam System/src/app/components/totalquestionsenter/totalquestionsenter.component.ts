import { Component, OnInit } from '@angular/core';
import { TestentryService } from 'src/app/services/testentry.service';
import { UserInfoService } from '../../services/userinfo.service';
import { Router } from '@angular/router';
import { TotalQuestions } from 'src/app/models/totalQuestions';
import { TotalquestionsenterService } from 'src/app/services/totalquestionsenter.service';
@Component({
  selector: 'app-totalquestionsenter',
  templateUrl: './totalquestionsenter.component.html',
  styleUrls: ['./totalquestionsenter.component.css']
})
export class TotalquestionsenterComponent implements OnInit {
  counter: number;
  totalQuestions : TotalQuestions = new TotalQuestions();
  tQuesTwo : TotalQuestions = new TotalQuestions();
  constructor(private testSession: TestentryService, private userSession: UserInfoService,private http: TotalquestionsenterService, private router: Router) {

   }
   

  ngOnInit() {
    console.log(this.testSession.getSessionCategoryId());
    console.log(this.testSession.getSessionForDuration());
    console.log(this.testSession.getSessionForTotalQue());
    console.log(this.userSession.getSession());
    this.testSession.getTestID(Number(this.testSession.getSessionCategoryId()),this.userSession.getSession()).subscribe(data2 => this.tQuesTwo.testID=data2, error => console.log(error));
    console.log(this.tQuesTwo.testID);
  }

  saveAndNext(){
     this.router.navigate(['/questionenter']);
      this.tQuesTwo.question=this.totalQuestions.question;
      this.tQuesTwo.optionOne=this.totalQuestions.optionOne;
      this.tQuesTwo.optionTwo=this.totalQuestions.optionTwo;
      this.tQuesTwo.optionThree=this.totalQuestions.optionThree;
      this.tQuesTwo.optionFour=this.totalQuestions.optionFour;
      this.tQuesTwo.correctAnswer=this.totalQuestions.correctAnswer;
      this.tQuesTwo.marks=this.totalQuestions.marks;
      this.tQuesTwo.diffLevel=this.totalQuestions.diffLevel;

      if(this.http.addQuestions(this.tQuesTwo).subscribe(data2 => console.log(data2), error => console.log(error))){
        this.router.navigate(['/questionenter']);
      }
  }

  finalSubmit(){
    this.router.navigate(['/admindashboard']);
  }
}

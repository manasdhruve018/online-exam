import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TotalquestionsenterComponent } from './components/totalquestionsenter/totalquestionsenter.component';
import { FormDemoComponent } from './components/form-demo/form-demo.component';
import { UserInfoService } from './services/userinfo.service';
import { TotalquestionsenterService } from './services/totalquestionsenter.service';

import { CategoryService } from './services/category.service';
import { CategoryComponent } from './components/category/category.component';
import { CoursefortestsetComponent} from './components/coursefortestset/coursefortestset.component';

import { LoginIndexComponent } from './components/login-index/login-index.component';
import { AdmindashboardComponent } from './components/admindashboard/admindashboard.component';
import { UserdashboardComponent } from './components/userdashboard/userdashboard.component';
import { TestentryService } from './services/testentry.service';
import { ResultComponent } from './components/result/result.component';
import { Quiz2Component } from './components/quiz2/quiz2.component';
import { QuizService } from './services/quiz.service';
import { DisplayalltestforuserComponent } from './components/displayalltestforuser/displayalltestforuser.component';
import { DisplaytestforuserfromtestidComponent } from './components/displaytestforuserfromtestid/displaytestforuserfromtestid.component';

@NgModule({
  declarations: [
    AppComponent,
    TotalquestionsenterComponent,
    FormDemoComponent,
    CategoryComponent,
    CoursefortestsetComponent,
    LoginIndexComponent,
    AdmindashboardComponent,
    UserdashboardComponent,
    ResultComponent,
    Quiz2Component,
    DisplayalltestforuserComponent,
    DisplaytestforuserfromtestidComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [ UserInfoService , TotalquestionsenterService, CategoryService, TestentryService, QuizService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FormDemoComponent} from './components/form-demo/form-demo.component';
import {TotalquestionsenterComponent} from './components/totalquestionsenter/totalquestionsenter.component'
import { CategoryComponent } from './components/category/category.component';
import {CoursefortestsetComponent} from './components/coursefortestset/coursefortestset.component'
import { LoginIndexComponent } from './components/login-index/login-index.component';
import { AdmindashboardComponent } from './components/admindashboard/admindashboard.component';
import { UserdashboardComponent } from './components/userdashboard/userdashboard.component';
import { ResultComponent } from './components/result/result.component';
import { Quiz2Component } from './components/quiz2/quiz2.component';
import {DisplayalltestforuserComponent} from './components/displayalltestforuser/displayalltestforuser.component';
import{DisplaytestforuserfromtestidComponent}  from './components/displaytestforuserfromtestid/displaytestforuserfromtestid.component';
const routes: Routes = [
  { path: '', component: LoginIndexComponent},
  { path: 'formdemo', component: FormDemoComponent },
  { path: 'questionenter', component: TotalquestionsenterComponent },
  { path: 'category', component: CategoryComponent},
  { path: 'result', component: ResultComponent},
  { path:'selectcourse' , component:CoursefortestsetComponent},
  { path:'admindashboard', component:AdmindashboardComponent},
  { path:'userdashboard', component:UserdashboardComponent},
  { path:'quiz2', component:Quiz2Component},
  {path:'displkayalltestforuser',component:DisplayalltestforuserComponent},
  {path:'displaytestforuserfromtestid',component:DisplaytestforuserfromtestidComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

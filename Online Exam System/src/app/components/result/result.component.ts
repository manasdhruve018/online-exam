import { Component, OnInit } from '@angular/core';
import {CategoryService } from '../../services/category.service';
import { Category } from 'src/app/models/Category';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  category: Category;
  cat : Array<any>;
  constructor(private http: CategoryService) { }

  ngOnInit() {
    this.http.getCategory().subscribe(data => this.category=data, error => console.log(error));
  }

}

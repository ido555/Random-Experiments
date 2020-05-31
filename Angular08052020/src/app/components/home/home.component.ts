import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  /*private - hence need to use public getter*/ today: Date;
  names: string[];
  productPrice: number;
  isDay: boolean;
  imgWidth: number;
  articles: string[]
  students: Object[]
  constructor() { }

  ngOnInit(): void {
    this.today = new Date() // show on page load
    setInterval(() => {this.today = new Date()}, 1000) // update every 1 second
    this.productPrice = 199
    this.names = ['one', 'two', 'three', 'four', 'five']
    this.articles = ['interesting article 1', 'interesting article 2', 'interesting article 3', 'interesting article 4', 'interesting article 5',]
    this.imgWidth = 150
    this.students = [
      { 'name': 'jeff', 'grade': '80' },
      { 'name': 'madison', 'grade': '89' },
      { 'name': 'chad', 'grade': '70' },
      { 'name': 'jennifer', 'grade': '67' }]
  }
  ngOnDestroy(): void{

  }

  getToday(): Date {
    return this.today
  }
  randomSize(): void {
    this.imgWidth = ((Math.random()) * 300) + 200
  }
  changeSize(change: boolean): void {
    if (change) {
      this.imgWidth += 20;
    } else {
      this.imgWidth -= 20;
    }
  }
  randomPrice(): void {
    this.productPrice = ((Math.random()) * 180) + 5
  }
  randomArticle(): string {
    return this.articles[Math.round(Math.random() * (this.articles.length - 1))]
  }
}

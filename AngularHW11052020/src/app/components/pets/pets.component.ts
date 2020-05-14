import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pets',
  templateUrl: './pets.component.html',
  styleUrls: ['./pets.component.css']
})
export class PetsComponent implements OnInit {

  constructor() { }

  pets: Object[]
  imgWidth: number;

  ngOnInit(): void {
    this.imgWidth = 290
    this.pets = [
      { imageSrc: "../../../assets/img1.jpg" },
      { imageSrc: "../../../assets/img2.jpg" },
      { imageSrc: "../../../assets/img3.jpg" },
      { imageSrc: "../../../assets/img4.jpg" },
      { imageSrc: "../../../assets/img5.jpg" },
      { imageSrc: "../../../assets/img6.jpg" }
    ]

  }
}

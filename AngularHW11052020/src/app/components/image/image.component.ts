import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css']
})
export class ImageComponent implements OnInit {

  @Input()
  imageSrc: string;
  @Input()
  imageTitle: string;
  @Input()
  imgWidth: number;

  constructor() { }

  ngOnInit(): void {

  }

}

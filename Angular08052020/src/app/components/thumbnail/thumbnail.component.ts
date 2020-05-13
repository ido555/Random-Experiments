import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-thumbnail',
  templateUrl: './thumbnail.component.html',
  styleUrls: ['./thumbnail.component.css']
})
export class ThumbnailComponent implements OnInit {

  constructor() { }

  // input() - variable comes from outside this component
  @Input()
  imageSrc:string

  ngOnInit(): void {
  }

}

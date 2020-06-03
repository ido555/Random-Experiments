import { Component, OnInit } from '@angular/core';
import { DialogComponent } from './../dialog/dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-angular-material',
  templateUrl: './angular-material.component.html',
  styleUrls: ['./angular-material.component.css']
})
export class AngularMaterialComponent implements OnInit {
  options = [
    { title: 'Audi R8', color: 'red' },
    { title: 'Jaguar F-Type', color: 'black' },
    { title: 'Nissan GTR', color: 'silver' }]
  autocomplete: FormControl = new FormControl();
  optionSelect: FormControl = new FormControl();
  constructor(private snackBar: MatSnackBar, private dialog: MatDialog) { }
  showSnack() {
    let snackRef = this.snackBar.open("hello world!", "undo", { duration: 2500 });
    snackRef.onAction().subscribe(() => alert("undo sucessful"))
  }
  showDialog() {
    this.dialog.open(DialogComponent, { minHeight: 200, minWidth: 200, disableClose: true });
  }
  ngOnInit(): void {
  }

}

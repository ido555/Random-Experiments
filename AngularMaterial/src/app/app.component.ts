import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog';
import { FormControl } from '@angular/forms';
import { Component } from '@angular/core';
import { OurDialogComponent } from './components/our-dialog/our-dialog.component';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    options = [
        { title: 'Audi R8', color: 'red' },
        { title: 'Jaguar F-Type', color: 'black' },
        { title: 'Nissan GTR', color: 'silver' }]
    autocomplete: FormControl = new FormControl();
    //   title = 'AngularMaterial';
    optionSelect: FormControl = new FormControl();
    constructor(private snackBar: MatSnackBar, private dialog: MatDialog) { }
    showSnack() {
        let snackRef = this.snackBar.open("hello world!", "undo", { duration: 2500 });
        snackRef.onAction().subscribe(() => alert("undo sucessful"))
    }
    showDialog() {
        this.dialog.open(OurDialogComponent, {minHeight: 200, minWidth: 200,disableClose: true});

    }
}
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { ReactiveFormsModule } from '@angular/forms';
import { MatCheckboxModule, } from '@angular/material/checkbox';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatButtonModule } from "@angular/material/button";
import { MatIconModule } from "@angular/material/icon";
import { MatBadgeModule } from "@angular/material/badge";
import { MatSelectModule } from "@angular/material/select";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatInputModule } from "@angular/material/input";
import { MatTooltipModule } from "@angular/material/tooltip";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { MatDialogModule } from "@angular/material/dialog";
import { OurDialogComponent } from './components/our-dialog/our-dialog.component';


@NgModule({
    declarations: [
        AppComponent,
        OurDialogComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatSliderModule,
        ReactiveFormsModule,
        MatCheckboxModule,
        MatSlideToggleModule,
        MatButtonModule,
        MatIconModule,
        MatBadgeModule,
        MatSelectModule,
        MatFormFieldModule,
        MatAutocompleteModule,
        MatInputModule,
        MatTooltipModule,
        MatSnackBarModule,
        MatDialogModule

    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }

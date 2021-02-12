import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddComputerComponent } from './components/add-computer/add-computer.component';
import { UpdateComputerComponent } from './components/update-computer/update-computer.component';
import { AllComputersComponent } from './components/all-computers/all-computers.component';
import { OneComputerComponent } from './components/one-computer/one-computer.component';
import { HttpClientModule } from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    AddComputerComponent,
    UpdateComputerComponent,
    AllComputersComponent,
    OneComputerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

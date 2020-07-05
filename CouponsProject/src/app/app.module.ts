import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { MatToolbarModule } from "@angular/material/toolbar";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginBoxComponent } from './components/login-box/login-box.component';
import { NavbarModule, WavesModule, ButtonsModule } from 'angular-bootstrap-md'
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { CustomerControlsComponent } from './components/admin/customer-controls/customer-controls.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginBoxComponent,
    NotFoundComponent,
    CustomerControlsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MDBBootstrapModule.forRoot(),
    NavbarModule,
    WavesModule,
    ButtonsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

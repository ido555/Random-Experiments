import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HttpParams } from '@angular/common/http';
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
import { MatDialogModule } from "@angular/material/dialog";
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { TableComponent } from './components/table/table.component';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginBoxComponent,
    NotFoundComponent,
    CustomerControlsComponent,
    TableComponent
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
    ButtonsModule,
    MatDialogModule,
    ReactiveFormsModule,
    FormsModule,
    NgxDatatableModule,
    BrowserModule
  ],
  providers: [HttpClientModule, TableComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }

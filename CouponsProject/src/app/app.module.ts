import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {ComponentFactoryResolver, NgModule, ViewChild, ViewContainerRef} from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavbarComponent} from './components/navbar/navbar.component';
import {HomeComponent} from './components/home/home.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LoginBoxComponent} from './components/login-box/login-box.component';
import {ButtonsModule, MDBBootstrapModule, NavbarModule, WavesModule} from 'angular-bootstrap-md';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {CustomerControlsComponent} from './components/admin/customer-controls/customer-controls.component';
import {MatDialogModule} from '@angular/material/dialog';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {TableComponent} from './components/table/table.component';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import {ErrorBoxComponent} from './components/error-box/error-box.component';
import {ClientInfoPopupComponent} from './components/client-info-popup/client-info-popup.component';
import {ParticlesModule} from 'ngx-particle';
import {ParticlesComponent} from './components/particles/particles.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginBoxComponent,
    NotFoundComponent,
    CustomerControlsComponent,
    TableComponent,
    ErrorBoxComponent,
    ClientInfoPopupComponent,
    ParticlesComponent
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
    BrowserModule,
    ParticlesModule

  ],
  providers: [HttpClientModule, TableComponent],
  bootstrap: [AppComponent]
})
export class AppModule {
  @ViewChild('alertContainer', {read: ViewContainerRef}) container;

  constructor(private resolver: ComponentFactoryResolver) {
  }


}

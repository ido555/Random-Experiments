import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutComponent } from './components/layout/layout.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MainComponent } from './components/main/main.component';
import { ContactusComponent } from './components/contactus/contactus.component';
import { PetsComponent } from './components/pets/pets.component';
import { ImageComponent } from './components/image/image.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    NavbarComponent,
    MainComponent,
    ContactusComponent,
    PetsComponent,
    ImageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

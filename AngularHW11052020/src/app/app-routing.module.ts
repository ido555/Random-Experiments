import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './components/main/main.component';
import { PetsComponent } from './components/pets/pets.component';
import { ContactusComponent } from './components/contactus/contactus.component';


const routes: Routes = [
  {path: "main", component: MainComponent},
  {path: "pets", component: PetsComponent},
  {path: "contactus", component: ContactusComponent},
  {path: "main", component: MainComponent},
  {path: "", redirectTo: "main", pathMatch: "full"},
  {path: "**", redirectTo: "main"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

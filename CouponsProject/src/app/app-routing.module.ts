import { CustomerControlsComponent } from './components/admin/customer-controls/customer-controls.component';
import { HomeComponent } from './components/home/home.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

//
const routes: Routes = [
  {path: "", redirectTo: "home", pathMatch: "full"},
  {path : "home", component: HomeComponent},
  {path : "customerControls", component: CustomerControlsComponent},
  {path: "**", component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { NewUserComponent } from './components/new-user/new-user.component';
import { InfoComponent } from './components/info/info.component';


const routes: Routes = [
  {path:"login", component: LoginComponent},
  {path:"new", component: NewUserComponent},
  {path:"info", component: InfoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

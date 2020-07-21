import {AdminControlPanel} from './components/admin/admin-control-panel/admin-control-panel.component';
import {HomeComponent} from './components/home/home.component';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CompanyPageComponent} from './components/company/company-page/company-page.component';
import {CustomerPageComponent} from './components/customer/customer-page/customer-page.component';

//
const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'adminControlPanel', component: AdminControlPanel},
  {path: 'companyControlPanel', component: CompanyPageComponent},
  {path: 'customerPage', component: CustomerPageComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

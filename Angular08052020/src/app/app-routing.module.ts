import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ProductsComponent } from './components/products/products.component';
import { NewProductComponent } from './components/new-product/new-product.component';
import { GalleryComponent } from './components/gallery/gallery.component';
import { NotFoundComponent } from './components/not-found/not-found.component';


const routes: Routes = [
  {path: "home" , component: HomeComponent},
  {path: "products" , component: ProductsComponent},
  {path: "new" , component: NewProductComponent},
  {path: "gallery" , component: GalleryComponent},
  // {path: "" , component: HomeComponent} redirect changes url to the appropiate one 
  // while component will allow localhost:4200/asdasd to appear to be a valid url
  {path: "", redirectTo: "home", pathMatch: "full"},
  // "**" - everything else
  {path: "**", component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

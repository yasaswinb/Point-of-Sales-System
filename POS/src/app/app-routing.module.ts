import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/auth/login/login.component';
import { AddUserComponent } from './components/auth/add-user/add-user.component';
import { AddItemComponent } from './components/item/add-item/add-item.component';
import { CreateItemTypeComponent } from './components/item/create-item-type/create-item-type.component';
import { ItemListComponent } from './components/item/item-list/item-list.component';
import { EditItemComponent } from './components/item/edit-item/edit-item.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { HomeComponent } from './components/home/home.component';
import { CartComponent } from './components/cart/cart.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: AddUserComponent },
  { path: 'itemList', component: ItemListComponent },
  { path: 'addItem', component: AddItemComponent },
  { path: 'createItemType', component: CreateItemTypeComponent },
  { path: 'editItem/:id', component: EditItemComponent },
  { path: 'navbar', component: NavBarComponent },
  { path: 'cart', component: CartComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

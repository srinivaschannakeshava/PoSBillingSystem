import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';

const routes: Routes = [{ path: 'all-items', component: AppComponent },
{ path: 'food-items', component: AppComponent },
{ path: 'beverage-items', component: AppComponent },
{ path: 'snack-items', component: AppComponent },
{ path: '**', redirectTo: 'all-items' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

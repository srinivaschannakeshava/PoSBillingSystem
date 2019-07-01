import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MaterialModule } from './shared/material.module';
import { AppNavbarComponent } from './app-navbar/app-navbar.component';
import { AppSidebarComponent } from './app-sidebar/app-sidebar.component';
import { AppCartComponent } from './app-cart/app-cart.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppFootComponent } from './app-foot/app-foot.component';
import { SidenavContentComponent } from './sidenav-content/sidenav-content.component';
import { SidenavMainContentComponent } from './sidenav-main-content/sidenav-main-content.component';
import { HttpClientModule } from '@angular/common/http';
import { AddItemComponent } from './add-item/add-item.component';
import { MatFormFieldModule } from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FilterItemsPipe } from './pipes/filter-items.pipe';


@NgModule({
  declarations: [
    AppComponent,
    AppNavbarComponent,
    AppSidebarComponent,
    AppCartComponent,
    AppFootComponent,
    SidenavContentComponent,
    SidenavMainContentComponent,
    AddItemComponent,
    FilterItemsPipe
  ],
  entryComponents: [
    AddItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

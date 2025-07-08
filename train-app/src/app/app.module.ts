import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TrainListComponent } from './train-list/train-list.component';
import { StationListComponent } from './station-list/station-list.component';
import { SearchTrainsComponent } from './search-trains/search-trains.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TrainScheduleComponent } from './train-schedule/train-schedule.component';
import { NavbarComponent } from './navbar/navbar.component';
import { StationScheduleComponent } from './station-schedule/station-schedule.component';

@NgModule({
  declarations: [
    AppComponent,
    TrainListComponent,
    StationListComponent,
    SearchTrainsComponent,
    TrainScheduleComponent,
    NavbarComponent,
    StationScheduleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

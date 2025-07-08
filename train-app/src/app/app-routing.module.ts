import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TrainListComponent } from './train-list/train-list.component';
import { StationListComponent } from './station-list/station-list.component';
import { SearchTrainsComponent } from './search-trains/search-trains.component';
import { TrainScheduleComponent } from './train-schedule/train-schedule.component';
import { StationScheduleComponent } from './station-schedule/station-schedule.component';

const routes: Routes = [
  { path: '', redirectTo: 'trains', pathMatch: 'full' },
  { path: 'trains', component: TrainListComponent },
  { path: 'trains/:id', component: TrainScheduleComponent },
  { path: 'stations', component: StationListComponent },
  { path: 'stations/:stationName', component: StationScheduleComponent },
  { path: 'search', component: SearchTrainsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

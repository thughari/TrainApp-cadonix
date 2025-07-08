import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-station-list',
  templateUrl: './station-list.component.html',
  styleUrl: './station-list.component.css'
})
export class StationListComponent implements OnInit {
  stations: string[] = [];
  selectedStation: any = null;
  trainEntries: any[] | undefined;

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.api.getAllStations().subscribe(data => this.stations = data);
  }

  viewSchedule(stationName: string): void {
    this.api.getStationSchedule(stationName).subscribe((data: any) => {
  this.trainEntries = Object.entries(data.trains).map(([trainId, details]: any) => ({
    trainId,
    ...details
  }));
});

  }
}
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-station-schedule',
  templateUrl: './station-schedule.component.html',
  styleUrls: ['./station-schedule.component.css']
})
export class StationScheduleComponent implements OnInit {
  stationName: string = '';
  trainEntries: any[] = [];

  constructor(private route: ActivatedRoute, private api: ApiService) {}

  ngOnInit(): void {
    this.stationName = this.route.snapshot.paramMap.get('stationName') || '';

    this.api.getStationSchedule(this.stationName).subscribe((data: any) => {
      this.trainEntries = Object.entries(data.trains).map(([trainId, details]: any) => ({
        trainId,
        ...details
      }));
    });
  }
}

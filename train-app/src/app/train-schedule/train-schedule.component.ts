import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-train-schedule',
  templateUrl: './train-schedule.component.html'
})
export class TrainScheduleComponent implements OnInit {
  trainId: string = '';
  stationEntries: any[] = [];

  constructor(private route: ActivatedRoute, private api: ApiService) {}

  ngOnInit(): void {
    this.trainId = this.route.snapshot.paramMap.get('id') || '';

    this.api.getTrainSchedule(this.trainId).subscribe((data: any) => {
      this.stationEntries = Object.entries(data.stations).map(([station, details]: any) => ({
        station,
        ...details
      }));
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-train-list',
  templateUrl: './train-list.component.html',
  styleUrl: './train-list.component.css'
})
export class TrainListComponent implements OnInit {
  trainIds: string[] = [];

  constructor(private api: ApiService) {}

  ngOnInit(): void {
    this.api.getAllTrains().subscribe((ids: string[]) => {
      this.trainIds = ids.filter(id => id && id.trim() !== '');
    });
  }
}

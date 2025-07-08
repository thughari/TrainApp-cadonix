import { Component } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-search-trains',
  templateUrl: './search-trains.component.html',
  styleUrls: ['./search-trains.component.css']
})
export class SearchTrainsComponent {
  from: string = '';
  to: string = '';
  trains: any[] = [];

  constructor(private api: ApiService) {}

  search(): void {
    if (!this.from || !this.to) return;

    this.api.searchTrains(this.from, this.to).subscribe((data: any) => {
      this.trains = data;
    });
  }
}

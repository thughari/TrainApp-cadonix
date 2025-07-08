import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ApiService {
  private baseUrl = 'http://localhost:8080'; // change as needed

  constructor(private http: HttpClient) {}

  getAllTrains(): Observable<any> {
    return this.http.get(`${this.baseUrl}/trains`);
  }

  getTrainSchedule(id: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/trains/${id}`);
  }

  getAllStations(): Observable<any> {
    return this.http.get(`${this.baseUrl}/stations`);
  }

  getStationSchedule(stationName: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/stations/${stationName}`);
  }


  searchTrains(from: string, to: string) {
    return this.http.get(`http://localhost:8080/search?from=${from}&to=${to}`);
  }

}

import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private reservationData: any;
  private checkinData: any;

  private url = 'http://localhost:8080/flightreservation/reservations/';

  constructor(private _http: HttpClient) {
  }

  public getReservation(id: number): Observable<any> {
    return this._http.get(this.url + id)
      .pipe(map((response) => {
        return response;
      }, error => {
        console.error(error);
      }));
  }

  public checkin(checkInRequest): Observable<any> {
    return this._http.post(this.url, checkInRequest)
      .pipe(map(response => {
          this.checkinData = response;
          return this.checkinData;
        },
        error => {
          console.log(error);
        }));
  }

}

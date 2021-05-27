import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {DataService} from '../../services/data.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-checkin',
  templateUrl: './checkin.component.html',
  styleUrls: ['./checkin.component.scss']
})
export class CheckinComponent implements OnInit, OnDestroy {
  private dataSub: Subscription = new Subscription();
  private checkInSub: Subscription = new Subscription();

  public data: any;
  public checkInResponse: any;
  public noOfBags: any;

  constructor(private router: Router, private route: ActivatedRoute, private service: DataService) {
  }

  ngOnInit(): void {
    const id = Number.parseInt(this.route.snapshot.paramMap.get('id'), 10);
    this.dataSub = this.service.getReservation(id).subscribe((response) => {
      this.data = response;
    });
  }

  checkin(noOfBags: number): void {
    const checkInRequest: any = new Object();
    checkInRequest.id = this.data.id;
    checkInRequest.checkedIn = true;
    checkInRequest.numberOfBags = noOfBags;

    this.checkInSub = this.service.checkin(checkInRequest).subscribe(reservation => {
      this.checkInResponse = reservation;
    });

    this.router.navigate(['/confirm']).then(() => {
      console.log('error');
    });
  }

  ngOnDestroy(): void {
    if (this.dataSub) {
      this.dataSub.unsubscribe();
    }

    if (this.checkInSub) {
      this.checkInSub.unsubscribe();
    }
  }

}

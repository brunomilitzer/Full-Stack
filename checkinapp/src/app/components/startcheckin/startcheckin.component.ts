import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-startcheckin',
  templateUrl: './startcheckin.component.html',
  styleUrls: ['./startcheckin.component.scss']
})
export class StartcheckinComponent implements OnInit {

  public reservationId: any;

  constructor(private router: Router) {
  }

  ngOnInit(): void {
  }

  onSelect(id: number): void {
    this.router.navigate(['/checkin', id]).then(() => {
      console.log('error');
    });
  }

}

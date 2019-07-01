import { Component, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'pos-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnChanges {

  title = 'PoSBillingUI';
  sidenavFlag = false;
  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes);

  }


}

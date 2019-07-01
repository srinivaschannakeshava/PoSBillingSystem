import { Injectable } from '@angular/core';
import { RestService } from '../shared/rest.service';

@Injectable({
  providedIn: 'root'
})
export class BillingService {

  constructor(private restClient: RestService) { }

  getBillList() {
    this.restClient.get('/api/billing', 'Get bill list', []).subscribe(data => {
      console.log(data);

    });
  }



}

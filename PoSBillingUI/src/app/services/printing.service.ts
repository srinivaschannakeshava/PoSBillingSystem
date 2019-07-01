import { Injectable } from '@angular/core';
import { RestService } from '../shared/rest.service';
import { Bill } from '../app-models/bill';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PrintingService {

  printerList = new BehaviorSubject<string[]>([]);
  constructor(private restClient: RestService) { }


  getPrinterList() {
    this.restClient.get('api/printer/all', 'Get printer list', []).subscribe((data) => {
      this.printerList.next(data);
    });
  }

  setPrinter(printerName: string) {
    this.restClient.post(`api/printer/${printerName}`, {}, 'set printer', {}).subscribe(resp => {
      console.log(resp);

    });
  }

  printBill(billDetail: Bill) {
    this.restClient.post(`api/printer/print/bill`, billDetail, 'print the bill', {}).subscribe(resp => {
      console.log(resp);
    });
  }
}

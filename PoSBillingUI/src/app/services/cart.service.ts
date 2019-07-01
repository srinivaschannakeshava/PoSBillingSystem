import { Injectable, EventEmitter } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartItemList = new BehaviorSubject<any>({});
  clearCartEvent = new EventEmitter();
  constructor() { }

  getBillingItems() {

  }


}

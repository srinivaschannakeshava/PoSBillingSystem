import { Injectable } from '@angular/core';
import { RestService } from '../shared/rest.service';
import { BehaviorSubject } from 'rxjs';
import { Inventory } from '../app-models/inventory';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  inventoryList = new BehaviorSubject<Inventory[]>([]);
  constructor(private restClient: RestService) { }

  getInventoryList() {
    this.restClient.get('api/inventory', 'Get inventory list', []).subscribe((data) => {
      this.inventoryList.next(data);
    });
  }

  addToInventory(invItem: Inventory) {
    this.restClient.post('api/inventory/add', invItem, 'adding to inventory', {}).subscribe(resp => {
      console.log(resp);
      this.getInventoryList();
    });
  }
}

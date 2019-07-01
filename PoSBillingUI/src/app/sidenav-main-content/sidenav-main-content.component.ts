import { Component, OnInit } from '@angular/core';
import { InventoryService } from '../services/inventory.service';
import { Inventory } from '../app-models/inventory';
import { Items } from '../app-models/items';
import { CartService } from '../services/cart.service';
import { ItemfilterService } from '../services/itemfilter.service';

@Component({
  selector: 'pos-sidenav-main-content',
  templateUrl: './sidenav-main-content.component.html',
  styleUrls: ['./sidenav-main-content.component.scss']
})
export class SidenavMainContentComponent implements OnInit {
  inventoryList: Inventory[];
  mainInventoryList: Inventory[];
  cartList: any = {};
  constructor(private inventoryServ: InventoryService, private cartService: CartService, private filterServ: ItemfilterService) { }

  ngOnInit() {
    this.inventoryServ.getInventoryList();
    this.inventoryServ.inventoryList.subscribe(invList => {
      this.inventoryList = invList;
      this.mainInventoryList = invList;
    });
    this.cartService.clearCartEvent.subscribe(e => {
      this.cartList = {};
    });
    this.filterServ.filterValue.subscribe(fValue => {
      this.inventoryList = this.mainInventoryList.filter((inv) => {
        return inv.name.toUpperCase().includes(fValue.toUpperCase());
      });
      console.log(this.inventoryList);

    });
  }


  addToCart(inv: Inventory) {
    if (!(inv.name in this.cartList)) {
      const cartItem = Object.assign({}, inv) as Items;
      cartItem.quantity = 1;
      this.cartList[cartItem.name] = cartItem;
    } else {
      this.cartList[inv.name].quantity = this.cartList[inv.name].quantity + 1;
    }
    this.cartService.cartItemList.next(this.cartList);
  }

}

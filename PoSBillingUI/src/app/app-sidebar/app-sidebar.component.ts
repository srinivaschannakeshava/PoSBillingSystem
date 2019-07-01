import { Component, OnInit } from '@angular/core';
import { CartService } from '../services/cart.service';
import { Items } from '../app-models/items';
import { Bill } from '../app-models/bill';
import { PrintingService } from '../services/printing.service';

@Component({
  selector: 'pos-app-sidebar',
  templateUrl: './app-sidebar.component.html',
  styleUrls: ['./app-sidebar.component.scss']
})
export class AppSidebarComponent implements OnInit {

  cartItems: Items[] = [];
  displayedColumns: string[] = ['name', 'quantity', 'price', 'delete'];
  totalPrice = 0;


  constructor(private cartService: CartService, private printServ: PrintingService) { }

  ngOnInit() {
    this.cartService.cartItemList.subscribe(data => {
      this.cartItems = Object.values(data);
      this.calculateTotalPrice();
    });
  }

  increaseQuantity(element: Items) {
    const cartItemList = this.cartService.cartItemList.getValue();
    cartItemList[element.name].quantity = element.quantity + 1;
    this.cartService.cartItemList.next(cartItemList);
  }
  decreaseQuantity(element: Items) {
    if (element.quantity > 1) {
      const cartItemList = this.cartService.cartItemList.getValue();
      cartItemList[element.name].quantity = element.quantity - 1;
      this.cartService.cartItemList.next(cartItemList);
    } else {
      this.removeFromCart(element);
    }
  }
  removeFromCart(element: Items) {
    const cartItemList = this.cartService.cartItemList.getValue();
    delete cartItemList[element.name];
    this.cartService.cartItemList.next(cartItemList);

  }

  calculateTotalPrice() {
    this.totalPrice = 0;
    this.cartItems.forEach(item => {
      this.totalPrice = this.totalPrice + (item.price * item.quantity);
    });
  }

  printBill() {
    const newBill: Bill = { items: this.cartItems, totalPrice: this.totalPrice };
    this.printServ.printBill(newBill);
    this.clearBill();
  }
  clearBill() {
    this.cartService.clearCartEvent.emit();
    this.cartService.cartItemList.next({});
  }


}

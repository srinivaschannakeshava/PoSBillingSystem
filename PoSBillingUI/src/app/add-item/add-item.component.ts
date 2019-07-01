import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormGroup } from '@angular/forms';
import { InventoryService } from '../services/inventory.service';
import { MatDialogRef } from '@angular/material';

@Component({
  selector: 'pos-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.scss']
})
export class AddItemComponent implements OnInit {

  categories = ['FOOD', 'BEVERAGES', 'SNACKS'];
  newItem = new FormGroup({
    name: new FormControl('', [Validators.required]),
    price: new FormControl('', [Validators.required]),
    category: new FormControl('', [Validators.required])
  });

  constructor(private inventServ: InventoryService, public dialogRef: MatDialogRef<AddItemComponent>) { }

  ngOnInit() {
    console.log(this.newItem);
  }

  addItemToInven(item) {
    this.inventServ.addToInventory(item);
    this.dialogRef.close();
  }

}

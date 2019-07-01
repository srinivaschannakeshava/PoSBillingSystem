import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material';
import { AddItemComponent } from '../add-item/add-item.component';

@Component({
  selector: 'pos-sidenav-content',
  templateUrl: './sidenav-content.component.html',
  styleUrls: ['./sidenav-content.component.scss']
})
export class SidenavContentComponent implements OnInit {

  constructor(private router: Router, public dialog: MatDialog) { }

  ngOnInit() {
  }

  onNavSelection() {
    console.log(this.router.url);
  }

  openAddItem() {
    this.dialog.open(AddItemComponent, {
      width: '400px',
      height: '400px'
    });
  }

}

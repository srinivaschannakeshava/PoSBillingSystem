import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { PrintingService } from '../services/printing.service';
import { Observable } from 'rxjs';
import { FormControl } from '@angular/forms';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
import { ItemfilterService } from '../services/itemfilter.service';

@Component({
  selector: 'pos-app-navbar',
  templateUrl: './app-navbar.component.html',
  styleUrls: ['./app-navbar.component.scss']
})
export class AppNavbarComponent implements OnInit {
  @Output() sidenavBtnEvent = new EventEmitter();
  printerList: string[];
  private searchControl: FormControl;
  private debounce = 400;

  constructor(private printServ: PrintingService, private filterServ: ItemfilterService) { }

  ngOnInit() {
    this.printServ.getPrinterList();
    this.printServ.printerList.subscribe(data => {
      this.printerList = data;
    });

    this.searchControl = new FormControl('');
    this.searchControl.valueChanges
      .pipe(debounceTime(this.debounce), distinctUntilChanged())
      .subscribe(query => {
        console.log(query);
        this.filterServ.filterValue.next(query);
      });
  }

  emitSidenavBtnEvent() {
    console.log('emiting sidenavevent');

    this.sidenavBtnEvent.emit();
  }

  onPrinterSelection(printer: string) {
    console.log(printer);
    this.printServ.setPrinter(printer);

  }

}

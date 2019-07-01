import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemfilterService {

  public filterValue = new BehaviorSubject<string>('');

  constructor() { }
}

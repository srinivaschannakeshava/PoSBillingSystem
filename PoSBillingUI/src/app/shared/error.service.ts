import { Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ErrorService {

  constructor() { }

  public handleError<T>(tag: string, optionalResult: T) {
    return (error) => {
      console.error(tag, error);
      return of(optionalResult as T);
    };
  }
}

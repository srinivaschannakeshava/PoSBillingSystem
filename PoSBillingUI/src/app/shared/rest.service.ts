import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { ErrorService } from './error.service';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private client: HttpClient, private error: ErrorService) { }

  get<T>(url: string, tag: string, fallbackResult?: T, options?: HttpOptions): Observable<T> {
    return this.client.get(url, options).pipe(catchError(this.error.handleError(tag, fallbackResult))) as Observable<T>;
  }

  post<T>(url: string, body: T, tag: string, fallbackResult?: T, options?: HttpOptions) {
    return this.client.post(url, body, options).pipe(catchError(this.error.handleError(tag, fallbackResult))) as Observable<T>;
  }
}
class HttpOptions {
  headers?: HttpHeaders | {
    [header: string]: string | string[];
  };
  observe: 'events';
  params?: HttpParams | {
    [param: string]: string | string[];
  };
  reportProgress?: boolean;
  responseType?: 'json';
  withCredentials?: boolean;
}

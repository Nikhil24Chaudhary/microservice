import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse,
} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CandidateServiceService {
  apiUrl: string = 'enter-your-api-url';
  CREATE_API : string ="";
  GET_API : string ="";
  
  headers = new HttpHeaders().set('Content-Type', 'application/json');

  constructor(private http: HttpClient) {}

  GetData() {
    return this.http.get(this.GET_API);
  }

  createTask(data: any): Observable<any> {
    let API_URL = this.CREATE_API;
    return this.http.post(API_URL, data).pipe(catchError(this.error));
  }
  error(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }
}

import { Chore } from './../models/chore';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ChoreService {

  private url = environment.baseUrl + 'api/chores';

  constructor(
    private http: HttpClient
  ) {

   }

   index(): Observable<Chore[]> {
    return this.http.get<Chore[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('ChoreService.index(): error retrieving chore: ' + err)
        );
      })
    );
  }

  //TODO: UPDATE METHODS BELOW WITH CORRECT VARIABLES FOR CHORES
  show(tid: number = 1): Observable<Chore> {
    return this.http.get<Chore>(this.url + '/' + tid).pipe(
      // return this.http.put<Chore>(`${this.url}/${chore.id}`, chore).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('ChoreService.show(): error retrieving chore: ' + err)
        );
      })
    );
  }

  create(chore: Chore): Observable<Chore> {
    return this.http.post<Chore>(this.url, chore).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('ChoreService.create(): error retrieving chore: ' + err)
        );
      })
    );
  }

  update(chore: Chore): Observable<Chore> {
    return this.http.put<Chore>(this.url + '/' + chore.id, chore).pipe(
      // return this.http.put<Chore>(`${this.url}/${chore.id}`, chore).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('ChoreService.update(): error retrieving chore: ' + err)
        );
      })
    );
  }

  destroy(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('ChoreService.destroy(): error deleting chorechore: ' + err)
        );
      })
    );
  }


}

import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BookDetail} from './model/book-detail';
import config from '../config';
import {BookShort} from './model/book-short';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  public retrieveBookList(): Observable<BookShort[]> {
    return this.http.get<BookShort[]>(`${config.apiUrl}/book/`);
  }

  public retrieveBookByIsbn(isbn: string): Observable<BookDetail> {
    return this.http.get<BookDetail>(`${config.apiUrl}/book/${isbn}`);
  }
}

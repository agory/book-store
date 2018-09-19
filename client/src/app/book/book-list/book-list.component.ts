import {Component, EventEmitter, Input, Output} from '@angular/core';
import {BookShort} from '../model/book-short';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent {

  @Input()
  public books: BookShort[];

  @Output()
  public onSelected = new EventEmitter<string>();

  constructor() { }

  onSelectedItem(book: BookShort) {
    this.onSelected.emit(book.isbn);
  }
}

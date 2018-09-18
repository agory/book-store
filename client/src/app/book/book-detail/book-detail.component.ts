import {Component, Input} from '@angular/core';
import {BookDetail} from '../model/book-detail';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.scss']
})
export class BookDetailComponent {

  @Input()
  public book: BookDetail;

  constructor() { }
}

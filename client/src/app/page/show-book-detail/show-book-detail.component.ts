import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {BookService} from '../../book/book.service';
import {BookDetail} from '../../book/model/book-detail';

@Component({
  selector: 'app-show-book-detail',
  templateUrl: './show-book-detail.component.html',
  styleUrls: ['./show-book-detail.component.scss']
})
export class ShowBookDetailComponent implements OnInit {
  public book: BookDetail;

  constructor(
    private route: ActivatedRoute,
    private bookService: BookService
  ) {
  }

  ngOnInit() {
    this.getBook();
  }

  getBook(): void {
    const isbn = this.route.snapshot.paramMap.get('isbn');
    this.bookService.retrieveBookByIsbn(isbn).subscribe(
      value => this.book = value,
      console.error
    );
  }
}

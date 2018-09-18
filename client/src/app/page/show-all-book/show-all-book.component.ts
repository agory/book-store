import {Component, OnInit} from '@angular/core';
import {BookShort} from '../../book/model/book-short';
import {Router} from '@angular/router';
import {BookService} from '../../book/book.service';

@Component({
  selector: 'app-show-all-book',
  templateUrl: './show-all-book.component.html',
  styleUrls: ['./show-all-book.component.scss']
})
export class ShowAllBookComponent implements OnInit {

  public books: BookShort[];

  constructor(private router: Router, private bookService: BookService) {
  }

  onSelected(isbn: string) {
    this.router.navigate(['/book', isbn]);
  }

  ngOnInit() {
    this.getAllBooks();
  }

  getAllBooks() {
    this.bookService.retrieveBookList().subscribe(
      value => this.books = value,
      console.error
    );
  }
}

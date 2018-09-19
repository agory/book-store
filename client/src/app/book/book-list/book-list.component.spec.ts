import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {BookListComponent} from './book-list.component';
import {BookShort} from '../model/book-short';
import {By} from '@angular/platform-browser';

describe('BookListComponent', () => {
  let component: BookListComponent;
  let fixture: ComponentFixture<BookListComponent>;
  let books: BookShort[];
  let callback;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [BookListComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookListComponent);
    component = fixture.componentInstance;
    books = [
      {isbn: 'isbn1', title: 'book1', image: 'http://image.com'},
      {isbn: 'isbn2', title: 'book2', image: 'http://image.com'},
      {isbn: 'isbn3', title: 'book3', image: 'http://image.com'}
    ];
    callback = {
      onSelected: () => {
      },
    };
    spyOn(callback, 'onSelected');
    component.books = books;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render 3 element', () => {
    const items = fixture.debugElement.query(By.css('ul')).children;
    expect(items.length).toEqual(books.length);
  });

  it('should render the title and isbn for each item', () => {
    const items = fixture.debugElement.query(By.css('ul')).children;
    items.forEach((item, index) => {
      const book = books[index];
      expect(item.nativeElement.textContent).toContain(book.isbn);
      expect(item.nativeElement.textContent).toContain(book.title);
    });
  });

  it('should trigger event onSelected with book isbn', done => {
    const item = fixture.debugElement.query(By.css('li'));

    component.onSelected.subscribe(isbn => {
      expect(isbn).toEqual(books[0].isbn);
      done();
    });

    item.triggerEventHandler('click', null);
  });
});

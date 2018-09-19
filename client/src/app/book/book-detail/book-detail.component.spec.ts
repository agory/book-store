import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {BookDetailComponent} from './book-detail.component';
import {By} from '@angular/platform-browser';

describe('BookDetailComponent', () => {
  let component: BookDetailComponent;
  let fixture: ComponentFixture<BookDetailComponent>;
  let book;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [BookDetailComponent]
    })
           .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookDetailComponent);
    component = fixture.componentInstance;
    book = {
      isbn: 'isbn',
      title: 'isbn',
      description: 'isbn',
      authors: 'isbn',
      publisher: 'isbn',
      publishDate: new Date(),
      image: 'http://image.url'
    };
    component.book = book;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render a h2 with the book title', () => {
    const title = fixture.debugElement.query(By.css('h2')).nativeElement;
    expect(title.textContent).toEqual(book.title);
  });

  it('should render all attribut in a list', () => {
    const ul = fixture.debugElement.query(By.css('ul')).nativeElement;
    expect(ul.textContent).toContain(book.authors);
    expect(ul.textContent).toContain(book.description);
    expect(ul.textContent).toContain(book.publisher);
    expect(ul.textContent).toContain(book.isbn);
    expect(ul.textContent).toContain(book.image);
    expect(ul.textContent).toContain(book.publishDate);
  });
});

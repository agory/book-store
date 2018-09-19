import {TestBed} from '@angular/core/testing';

import {BookService} from './book.service';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import {BookShort} from './model/book-short';
import {BookDetail} from './model/book-detail';
import config from '../config';

describe('BookService', () => {
  let service: BookService;
  let httpMock: HttpTestingController;

  let books: BookShort[];
  let book: BookDetail;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    service = TestBed.get(BookService);
    httpMock = TestBed.get(HttpTestingController);
    books = [
      { isbn:"isbn1", image:"https://image.com", title: "Cultivation Chat Group"},
      { isbn:"isbn2", image:"https://image2.com", title: "King of god"},
      { isbn:"isbn3", image:"https://image3.com", title: "Godly Model Creator"},
    ];

    book = {
      title: "Hello Green World",
      isbn: "zeniBook1",
      image: "https://hello-green-world.lol",
      authors: "Justine",
      publisher: "Zenicanard",
      publishDate: new Date(),
      description: "Save the world"
    }
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return a list of user', function () {

    service.retrieveBookList()
           .subscribe(fetchedBooks =>
      expect(fetchedBooks).toEqual(books)
    );

    const req = httpMock.expectOne(`${config.apiUrl}/book/`);
    expect(req.request.method).toBe("GET");
    req.flush(books);
  });

  it('should return a user', function () {

    service.retrieveBookByIsbn('zeniBook1')
           .subscribe(fetchedBook =>
      expect(fetchedBook).toEqual(book)
    );

    const req = httpMock.expectOne(`${config.apiUrl}/book/zeniBook1`);
    expect(req.request.method).toBe("GET");
    req.flush(book);
  });
});

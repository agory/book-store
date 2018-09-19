import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ShowBookDetailComponent} from './show-book-detail.component';
import {BookService} from '../../book/book.service';
import {ActivatedRoute} from '@angular/router';
import {of} from 'rxjs';
import {BookDetailComponent} from '../../book/book-detail/book-detail.component';

describe('ShowBookDetailComponent', () => {
  let component: ShowBookDetailComponent;
  let fixture: ComponentFixture<ShowBookDetailComponent>;
  let bookServiceSpy: jasmine.SpyObj<BookService>;
  let activatedRouteSpy;
  let isbn: string;

  beforeEach(async(() => {
    const spyBookService = jasmine.createSpyObj('BookService', [
      'retrieveBookByIsbn'
    ]);

    activatedRouteSpy = {
      snapshot: {
        paramMap: {
          get: () => isbn,
        }
      }
    };

    TestBed.configureTestingModule({
      declarations: [ShowBookDetailComponent, BookDetailComponent],
      providers: [
        {provide: BookService, useValue: spyBookService},
        {provide: ActivatedRoute, useValue: activatedRouteSpy}
      ]
    }).compileComponents();

    isbn = 'isbn';
    bookServiceSpy = TestBed.get(BookService);
    bookServiceSpy.retrieveBookByIsbn.and.returnValue(of({}));
    activatedRouteSpy = TestBed.get(ActivatedRoute);
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowBookDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

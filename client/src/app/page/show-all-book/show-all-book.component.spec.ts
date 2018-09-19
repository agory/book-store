import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ShowAllBookComponent} from './show-all-book.component';
import {BookService} from '../../book/book.service';
import {Router} from '@angular/router';
import {BookListComponent} from '../../book/book-list/book-list.component';
import {of} from 'rxjs';

describe('ShowAllBookComponent', () => {
  let component: ShowAllBookComponent;
  let fixture: ComponentFixture<ShowAllBookComponent>;
  let bookServiceSpy: jasmine.SpyObj<BookService>;

  beforeEach(async(() => {
    const spyBookService = jasmine.createSpyObj('BookService', [
      'retrieveBookList'
    ]);
    const spyRouter = jasmine.createSpyObj('Router', [
      'navigate'
    ]);

    TestBed.configureTestingModule({
      declarations: [ShowAllBookComponent, BookListComponent],
      providers: [
        {provide: BookService, useValue: spyBookService},
        {provide: Router, useValue: spyRouter}
      ]
    })
    .compileComponents();
    bookServiceSpy = TestBed.get(BookService);
    bookServiceSpy.retrieveBookList.and.returnValue(of([]));
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAllBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BookListComponent} from './book-list/book-list.component';
import {BookDetailComponent} from './book-detail/book-detail.component';

const exportComponent = [BookListComponent, BookDetailComponent];

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [...exportComponent],
  exports: exportComponent
})
export class BookModule { }

import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {ShowAllBookComponent} from './page/show-all-book/show-all-book.component';
import {BookModule} from './book/book.module';
import { ShowBookDetailComponent } from './page/show-book-detail/show-book-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    ShowAllBookComponent,
    ShowBookDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BookModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ShowAllBookComponent} from './page/show-all-book/show-all-book.component';
import {ShowBookDetailComponent} from './page/show-book-detail/show-book-detail.component';

const routes: Routes = [
  {path: 'book', component: ShowAllBookComponent},
  {path: 'book/:isbn', component: ShowBookDetailComponent},
  {path: '**', redirectTo: '/book'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

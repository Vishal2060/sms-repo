import {Component, OnInit} from '@angular/core';
import {setTheme} from 'ngx-bootstrap/utils';
import {HttpClient} from '@angular/common/http';
import {Data} from './data';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  dataUrl = 'http://localhost:8000/data';

  page: number;
  count: number;
  pages = 100;
  maxSize = 10;

  httpParam: {} = {page: '1'};

  data: any;

  fromStartDate: any;
  toStartDate: any;
  fromEndDate: any;
  toEndDate: any;

  searchString: any;

  constructor(private http: HttpClient) {
    setTheme('bs4');
  }

  ngOnInit(): void {
    this.getData();
  }

  getData(): void {
    this.http.get(this.dataUrl, {params: this.httpParam})
      .subscribe((response: Data) => {
          this.data = response.data;
          this.page = response.page;
          this.count = response.count;
        }
      );
  }

  pageChanged(e: any): void {
    this.page = e.page;
    // @ts-ignore
    this.httpParam.page = e.page.toString();
    this.getData();
  }

  sort(column: string): void {
    // @ts-ignore
    this.httpParam.sort = column;
    // @ts-ignore
    this.httpParam.page = '1';
    this.getData();
  }

  dateChanged(dateField: string, date: string): void {
    this.httpParam[dateField] = date;
    // @ts-ignore
    this.httpParam.page = '1';
    this.getData();
  }

  search(searchString: string): void {
    // @ts-ignore
    this.httpParam.search = searchString;
    // @ts-ignore
    this.httpParam.page = '1';
    this.getData();
  }

  clearFilters(): void {
    this.httpParam = {page: '1'};

    this.fromStartDate = null;
    this.toStartDate = null;
    this.fromEndDate = null;
    this.toEndDate = null;

    this.searchString = null;

    // @ts-ignore
    this.httpParam.page = '1';

    this.getData();
  }

}

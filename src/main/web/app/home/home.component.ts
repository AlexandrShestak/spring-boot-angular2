import { Component, Input, OnInit } from '@angular/core';
import {Http, Headers, HTTP_PROVIDERS} from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Component({
    selector: 'home',
    templateUrl : 'app/home/home.component.html',
    viewProviders: [HTTP_PROVIDERS]
})

export class HomeComponent {
    email: string;
  
    constructor(private http : Http) {
    }
    
}
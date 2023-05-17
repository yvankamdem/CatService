import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit{

  public produits:any;
  constructor(private httpClient:HttpClient) {}
  ngOnInit(){
  }

  onGetProducts() {
    this.httpClient.get("http://localhost:8080/produits")
      .pipe(
        tap(data => {
            this.produits = data;
          },
          error => {
            console.log(error);
          })
      )
      .subscribe();
  }
}

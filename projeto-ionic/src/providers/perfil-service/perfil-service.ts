import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions } from '@angular/http';
import { Utils } from '../../model/utils';

import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';

/*
  Generated class for the PerfilServiceProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class PerfilServiceProvider {

  private perfilUrl: string;
  public handleError: any;

  constructor(
    public http: Http,
    public requestOptions: RequestOptions
  ) {
    this.perfilUrl = Utils.getUrlBackend() + "perfil/";
  }

  public getPerfis(){
    return this.http.get(this.perfilUrl)
    .map(res => res.json());
  }

}

import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { PerfilServiceProvider } from '../../providers/perfil-service/perfil-service';

/**
 * Generated class for the PerfilPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
  selector: 'page-perfil',
  templateUrl: 'perfil.html',
  providers: [PerfilServiceProvider]
})
export class PerfilPage {

  public perfis: any;

  constructor(
    public navCtrl: NavController,
     public navParams: NavParams,
     public perfilService: PerfilServiceProvider
  ) {
    this.perfilService.getPerfis().subscribe(
      response => this.perfis = response
    );
    }

}

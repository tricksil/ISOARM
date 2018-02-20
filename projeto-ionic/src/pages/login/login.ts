import { Component } from '@angular/core';
import { CookieService } from 'angular2-cookie/core';
import { FormBuilder } from '@angular/forms';
import { IonicPage, NavController, NavParams } from 'ionic-angular';


import { LoginServiceProvider } from '../../providers/login-service/login-service';
import { RequestOptions } from '@angular/http';
import { TabsPage } from '../tabs/tabs';


/**
 * Generated class for the LoginPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

  public loginForm;
  loading: any;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public formBuilder: FormBuilder,
    public nav: NavController,
    private loginService: LoginServiceProvider,
    private cookieService: CookieService,
    private requestOptions: RequestOptions

  ) {
      this.loginForm = formBuilder.group({
        email: [''],
        senha: ['']
      });
  }

  loginUser(): void{
      if(this.loginForm.valid){
        this.loginService.login(this.loginForm.value).subscribe(
          res => this.loginSuccess(res)
        );
      }else {
        this.loading.present();
      }
  }

  loginSuccess(res: any){
      this.cookieService.removeAll();
      this.cookieService.put("accessToken", res.access_token);
      this.requestOptions.headers.set('Authorization', "Bearer " + res.access_token);
      this.loginService.getUsuarioAtual(res.access_token).subscribe(
          res => this.redirectPage(res)
      );
  }

  redirectPage(res: any){
      this.cookieService.putObject("usuarioAtual",res);
      this.navCtrl.setRoot(TabsPage);
  }

  redirectUser(response){
    this.cookieService.removeAll();
    this.cookieService.put("accessToken", response.access_token);
    this.requestOptions.headers.set('Authorization', "Bearer " + response.access_token);
  }



}

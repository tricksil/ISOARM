import { Component } from '@angular/core';
import { CookieService } from 'angular2-cookie/core';
import { FormBuilder } from '@angular/forms';
import { IonicPage, NavController, NavParams } from 'ionic-angular';


import { LoginServiceProvider } from '../../providers/login-service/login-service';
import { RequestOptions } from '@angular/http';


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
          response => console.log(response)
        );
      }else {
        this.loading.present();
      }
  }


}

import { Component, OnInit } from '@angular/core';
import {Credencial} from "../../models/Credencial";
import {FormControl, Validators} from "@angular/forms";
import {Toast, ToastrService} from "ngx-toastr";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  cred: Credencial = {
    email:'',
    senha:''
  }

  email = new FormControl(null, Validators.email);
  senha = new FormControl(null, Validators.minLength(3));

  constructor(private toast:ToastrService,
              private service: AuthService,
              private router: Router) { }

  ngOnInit(): void {
  }

  logar(){
    this.service.authenticate(this.cred).subscribe(resposta => {
      this.service.successFullLogin(resposta.headers.get('Authorization').substring(7))
      this.router.navigate([''])
      this.toast.info('Login realizado com sucesso!')

    }, () => {
      this.toast.error("Usuário e/ou senha inválidos!")
    })
  }
  validaCampos(): boolean {
    return this.email.valid && this.senha.valid;
  }

}

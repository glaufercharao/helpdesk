import { Component, OnInit } from '@angular/core';
import {Credencial} from "../../models/Credencial";
import {FormControl, Validators} from "@angular/forms";
import {Toast, ToastrService} from "ngx-toastr";

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

  constructor(private toast:ToastrService) { }

  ngOnInit(): void {
  }

  logar(){
    this.toast.error('Usuario ou senha errados','Teste de mensagem')
    this.cred.senha = '';
  }
  validaCampos(): boolean {
    if(this.email.valid && this.senha.valid){
      return true;
    } else {
      return false
    }
  }

}

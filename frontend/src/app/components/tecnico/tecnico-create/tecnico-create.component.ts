import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from "@angular/forms";
import {TecnicoService} from "../../../services/tecnico.service";
import {Tecnico} from "../../../models/Tecnico";
import {Toast, ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";

@Component({
  selector: 'app-tecnico-create',
  templateUrl: './tecnico-create.component.html',
  styleUrls: ['./tecnico-create.component.css']
})
export class TecnicoCreateComponent implements OnInit {

  tecnico: Tecnico = {
      id: '',
      nome: '',
      cpf: '',
      email: '',
      senha: '',
      perfis: [],
      dataCriacao: ''

  }

  nome = new FormControl(null, Validators.minLength(3));
  cpf = new FormControl(null, Validators.required);
  email = new FormControl(null, Validators.email);
  senha = new FormControl(null, Validators.minLength(3));
  constructor(private tecnicoService: TecnicoService,
              private toast: ToastrService,
              private router: Router) { }

  ngOnInit(): void {
  }

  create(): void {
    this.tecnicoService.create(this.tecnico).subscribe(resposta => {
      this.toast.success('Técnico cadastrado com sucesso!', 'Cadastro');
      this.router.navigate(['tecnicos'])  ;
    }, ex => {
      console.log(ex)
        if(ex.error.errors) {
            ex.error.errors.forEach( element => {
                this.toast.error(element.message());
            })
        } else {
            this.toast.error(ex.error.message());
        }
    })
  }

  addPerfil(perfil: any): void {

      if(this.tecnico.perfis.includes(perfil)){
          this.tecnico.perfis.slice(this.tecnico.perfis.indexOf(perfil), 1)
      } else {
          this.tecnico.perfis.push(perfil)
      }
  }

    validaCampos() {
        return this.nome.valid && this.cpf.valid
            && this.email.valid && this.senha.valid;
    }

}

import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {Tecnico} from "../../../models/Tecnico";

@Component({
  selector: 'app-tecnico-list',
  templateUrl: './tecnico-list.component.html',
  styleUrls: ['./tecnico-list.component.css']
})
export class TecnicoListComponent implements OnInit {

  private ELEMENT_DATA: Tecnico[] = [{
    id:1,
    nome: 'Glaufer',
    cpf: '807.822.480-04',
    email: 'glaufer.charao@gmail.com',
    perfis:['ADMIN','TECNICO'],
    dataCriacao: '15/06/1982',
  }];

  displayedColumns: string[] = ['id', 'nome', 'cpf', 'email','acoes'];

  dataSource = new MatTableDataSource<Tecnico>(this.ELEMENT_DATA);

  constructor() { }

  ngOnInit(): void {
  }

  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

}


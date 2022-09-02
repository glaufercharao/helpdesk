package com.gpc.helpdesk.domain;

import com.gpc.helpdesk.domain.enums.Prioridade;
import com.gpc.helpdesk.domain.enums.Status;

import java.time.LocalDate;
import java.util.Objects;

public class Chamado {

    private Long id;
    private LocalDate dataAbertura = LocalDate.now();
    private LocalDate dataFechamendo;
    private Prioridade prioridade;
    private Status status;
    private String titulo;
    private String observacoes;

    private Tecnico tecnico;
    private Cliente cliente;

    public Chamado() {
    }

    public Chamado(Long id, Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico, Cliente cliente) {
        this.id = id;
        this.prioridade = prioridade;
        this.status = status;
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamendo() {
        return dataFechamendo;
    }

    public void setDataFechamendo(LocalDate dataFechamendo) {
        this.dataFechamendo = dataFechamendo;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chamado chamado = (Chamado) o;
        return id.equals(chamado.id) && Objects.equals(dataAbertura, chamado.dataAbertura) && Objects.equals(dataFechamendo, chamado.dataFechamendo) && prioridade == chamado.prioridade && status == chamado.status && Objects.equals(titulo, chamado.titulo) && Objects.equals(observacoes, chamado.observacoes) && Objects.equals(tecnico, chamado.tecnico) && Objects.equals(cliente, chamado.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataAbertura, dataFechamendo, prioridade, status, titulo, observacoes, tecnico, cliente);
    }
}

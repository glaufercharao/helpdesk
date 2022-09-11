package com.gpc.helpdesk.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;


public class ChamadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamendo;

    @NotNull(message = "O campo PRIORIDADE é requerido")
    private Integer prioridade;

    @NotNull(message = "O campo STATUS é requerido")
    private Integer status;

    @NotNull(message = "O campo TITULO é requerido")
    private String titulo;

    @NotNull(message = "O campo OBSERVAÇÕES é requerido")
    private String observacoes;

    @NotNull(message = "O campo TECNICO é requerido")
    private Long tecnico;

    @NotNull(message = "O campo CLIENTE é requerido")
    private Long cliente;

    private String nomeTecnico;

    private String nomeCliente;

    public ChamadoDTO() {

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

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public Long getTecnico() {
        return tecnico;
    }

    public void setTecnico(Long tecnico) {
        this.tecnico = tecnico;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
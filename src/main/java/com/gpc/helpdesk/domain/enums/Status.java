package com.gpc.helpdesk.domain.enums;

public enum Status {
    ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

    private Integer codigo;
    private String descricao;

    Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public static Status toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }
        for (Status value : Status.values()) {
            if(codigo.equals(value.getCodigo()))
                return value;
        }
        throw new IllegalArgumentException("Status inválido!");
    }

    public String getDescricao() {
        return descricao;
    }
}

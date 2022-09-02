package com.gpc.helpdesk.domain.enums;

public enum Perfil {
    ADMIN(0, "ROLE_ADMIN"), TECNICO(1, "ROLE_TECNICO"), CLIENTE(2, "ROLE_CLIENTE");

    private Integer codigo;
    private String descricao;

    Perfil(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public static Perfil toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }
        for (Perfil value : Perfil.values()) {
            if(codigo.equals(value.getCodigo()))
                return value;
        }
        throw new IllegalArgumentException("Perfil inválido!");
    }

    public String getDescricao() {
        return descricao;
    }
}

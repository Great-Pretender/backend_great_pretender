package com.greatpretender.api.projetoapijaia.entity;


public enum UsuarioCargo {

    ADMIN("ROLE_ADMIN"),

    USER("ROLE_USER");

    private String cargo;

    UsuarioCargo(String cargo){
        this.cargo = cargo;
    }

    public String getCargo(){
        return cargo;
    }
}

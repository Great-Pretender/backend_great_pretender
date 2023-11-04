package com.greatpretender.api.projetoapijaia.entity;


public enum UsuarioCargo {

    ADMIN("admin"),

    USER("user");

    private String cargo;

    UsuarioCargo(String cargo){
        this.cargo = cargo;
    }

    public String getCargo(){
        return cargo;
    }
}

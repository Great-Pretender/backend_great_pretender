package com.greatpretender.api.projetoapijaia.security;

public class Login {

    //Variaveis
    private String username;
    private String password;
    private String auth;
    private String token;

    //Construtores da classe
    public Login() {}
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }


    //Get e Setters das variaveis
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

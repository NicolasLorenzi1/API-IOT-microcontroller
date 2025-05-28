package com.tcc.iot_mc_api.dto;

public class UsuarioDTO {

    private long id;
    private String email;
    private String senha;

    public UsuarioDTO() {
    }

    public UsuarioDTO(long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}

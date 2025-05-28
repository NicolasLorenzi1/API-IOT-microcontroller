package com.tcc.iot_mc_api.dto;

import com.tcc.iot_mc_api.configuration.Role;

public class UserDTO {

    private long id;
    private String email;
    private String senha;
    private Role role;

    public UserDTO() {
    }

    public UserDTO(long id, String email, String senha, Role role) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}

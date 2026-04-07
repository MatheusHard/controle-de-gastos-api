package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.security;

import com.infotrapichao.controle_de_gastos.src.domain.models.security.User;


public class SessionDTO {

    private String login;
    private String token;
    private User user;

    public SessionDTO(){}
    public SessionDTO(String login, String token, User user) {
        this.login = login;
        this.token = token;
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package com.infotrapichao.controle_de_gastos.src.application.contracts.security;


import com.infotrapichao.controle_de_gastos.src.domain.models.security.User;

import java.util.List;


public interface IUserApplication {
    User findById(Integer id);
    User findByUsername(String username);
    User createUser(User user);
    User updateUser(User user);
    List<User> findAll();

}



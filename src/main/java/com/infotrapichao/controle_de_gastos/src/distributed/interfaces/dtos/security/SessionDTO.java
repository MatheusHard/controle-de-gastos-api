package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.security;

import com.infotrapichao.controle_de_gastos.src.domain.models.security.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO {

    private String login;
    private String token;
    private User user;

    }

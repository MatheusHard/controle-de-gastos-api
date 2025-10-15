package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infotrapichao.controle_de_gastos.src.domain.models.security.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AgendaDePagamentoDTO {

    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private User user;
    private Boolean deletado;

    ///Filters
    private LocalDate dataInicial;
    private LocalDate dataFinal;
}

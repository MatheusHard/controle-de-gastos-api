package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common;

import com.infotrapichao.controle_de_gastos.src.domain.models.security.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GastoDTO {

    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime vencimento;
    private String descricao;
    private User user;
    private Boolean deletado = false;
    ///Filters
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private BigDecimal valor;

}

package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common;

import java.math.BigDecimal;

public record GastosMensaisDTO(String mes, BigDecimal total) {}
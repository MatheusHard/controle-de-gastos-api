package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common;


import lombok.Getter;

import java.math.BigDecimal;

public record GastosMensaisDTO(Integer mes, BigDecimal total, String mesAbreviado) {
    public GastosMensaisDTO(Integer mes, BigDecimal total) {
        this(mes, total, traduzMes(mes));
    }

    private static String traduzMes(Integer mes) {
        return switch (mes) {
            case 1 -> "JAN";
            case 2 -> "FEV";
            case 3 -> "MAR";
            case 4 -> "ABR";
            case 5 -> "MAI";
            case 6 -> "JUN";
            case 7 -> "JUL";
            case 8 -> "AGO";
            case 9 -> "SET";
            case 10 -> "OUT";
            case 11 -> "NOV";
            case 12 -> "DEZ";
            default -> "";
        };
    }
}
package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.enums;

import lombok.Getter;

@Getter
public enum StatusPagamentoEnum {
    NAO_PAGO(0),
    VENCIDO(1),
    PAGO(2);

    private final int codigo;

    StatusPagamentoEnum(int codigo) {
        this.codigo = codigo;
    }

    public static StatusPagamentoEnum fromCodigo(int codigo) {
        for (StatusPagamentoEnum status : StatusPagamentoEnum.values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status inválido: " + codigo);
    }
}

package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.mappers;


import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.GastoDTO;
import com.infotrapichao.controle_de_gastos.src.domain.models.common.Gasto;

import java.util.List;

public class GastoMapper {

public static GastoDTO toGastoDTO(Gasto gasto) {
    return new GastoDTO(gasto.getId(), gasto.getCreatedAt(), gasto.getUpdatedAt(),
            gasto.getVencimento(), gasto.getDescricao(), gasto.getUser(),  gasto.isDeletado(), null, null, gasto.getValor());
}

public static Gasto toGasto(GastoDTO gastoDTO) {
    return new Gasto(gastoDTO.getId(), gastoDTO.getCreatedAt(), gastoDTO.getUpdatedAt(),
            gastoDTO.getVencimento(), gastoDTO.getDescricao(), gastoDTO.getDeletado(), gastoDTO.getUser(), gastoDTO.getValor());
}

public static List<GastoDTO> toAgendamentoDTOList(List<Gasto> gastos) {
    return gastos.stream().map(a -> {
        GastoDTO dto =  GastoMapper.toGastoDTO(a);
        //Aqui pode mudar campo do objeto, caso queira
         dto.getUser().setPassword(null);
        return dto;
    }).toList();
}

public static List<Gasto> toGastoList(List<GastoDTO> gastosDtos) {
    return gastosDtos.stream().map(GastoMapper::toGasto).toList();
}
}

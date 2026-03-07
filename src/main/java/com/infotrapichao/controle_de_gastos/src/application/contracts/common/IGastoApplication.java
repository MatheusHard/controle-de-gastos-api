package com.infotrapichao.controle_de_gastos.src.application.contracts.common;

import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.GastoDTO;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.GastosMensaisDTO;
import com.infotrapichao.controle_de_gastos.src.domain.models.common.Gasto;

import java.util.List;

public interface IGastoApplication {
    Gasto findById(Integer id);
    Gasto create(Gasto gasto);
    Gasto update(Gasto gasto);
    List<Gasto> findAll();
    List<Gasto> findAllByFilter(GastoDTO filter);
    List<GastosMensaisDTO> findTotaisPorMes(GastoDTO filter);
}

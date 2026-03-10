package com.infotrapichao.controle_de_gastos.src.application.services.common;

import com.infotrapichao.controle_de_gastos.src.application.contracts.common.IGastoApplication;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.GastoDTO;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.dashboard.GastosMensaisDTO;
import com.infotrapichao.controle_de_gastos.src.domain.contracts.services.common.IGastoService;
import com.infotrapichao.controle_de_gastos.src.domain.models.common.Gasto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoApplication implements IGastoApplication {

    private final IGastoService _gastoService;

    public GastoApplication(IGastoService gastoService) {
        this._gastoService = gastoService;
    }

    @Override
    public Gasto findById(Integer id) {
        return _gastoService.findById(id);
    }

    @Override
    public Gasto create(Gasto gasto) {
        return _gastoService.create(gasto);
    }

    @Override
    public Gasto update(Gasto gasto) {
        return _gastoService.update(gasto);
    }

    @Override
    public List<Gasto> findAll() {
        return _gastoService.findAll();
    }

    @Override
    public List<Gasto> findAllByFilter(GastoDTO filter) {
        return _gastoService.findAllByFilter(filter);
    }

    @Override
    public List<GastosMensaisDTO> findTotaisPorMes(GastoDTO filter) {
        return _gastoService.findTotaisPorMes(filter);
    }
}

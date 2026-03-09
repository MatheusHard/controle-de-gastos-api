package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.controllers.common;

import com.infotrapichao.controle_de_gastos.src.application.contracts.common.IGastoApplication;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.GastoDTO;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.dashboard.GastosMensaisDTO;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.dashboard.TotaisMensaisResponse;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("dashboard")
public class DashBoardController {
    private final IGastoApplication _gastoApplication;

    public DashBoardController(IGastoApplication gastoApplication) {
        this._gastoApplication = gastoApplication;
    }

    @PostMapping("/totais-mensais")
    public TotaisMensaisResponse getTotaisMensais(@RequestBody GastoDTO filter) {
        var lista = _gastoApplication.findTotaisPorMes(filter);
        BigDecimal somaTotal = lista.stream()
                .map(GastosMensaisDTO::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new TotaisMensaisResponse(lista, somaTotal);

    }


}



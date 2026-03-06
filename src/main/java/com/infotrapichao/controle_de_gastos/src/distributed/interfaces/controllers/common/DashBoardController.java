package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.controllers.common;

import com.infotrapichao.controle_de_gastos.src.application.contracts.common.IGastoApplication;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.GastosMensaisDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dashboard")
public class DashBoardController {
    private final IGastoApplication _gastoApplication;

    public DashBoardController(IGastoApplication gastoApplication) {
        this._gastoApplication = gastoApplication;
    }

    @GetMapping("/totais-mensais")
    public List<GastosMensaisDTO> getTotaisMensais() {
        return _gastoApplication.findTotaisPorMes();
    }


}



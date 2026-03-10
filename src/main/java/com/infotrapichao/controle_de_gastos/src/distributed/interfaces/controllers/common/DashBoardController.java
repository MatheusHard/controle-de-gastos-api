package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.controllers.common;

import com.infotrapichao.controle_de_gastos.src.application.contracts.common.IGastoApplication;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.core.utils.Utils;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.GastoDTO;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.dashboard.GastosMensaisDTO;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.mappers.GastoMapper;
import com.infotrapichao.controle_de_gastos.src.domain.models.common.Gasto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("dashboard")
public class DashBoardController {

    private final IGastoApplication _gastoApplication;

    public DashBoardController(IGastoApplication gastoApplication) {
        this._gastoApplication = gastoApplication;
    }

    @PostMapping("/totais-mensais")
    public ResponseEntity<List<GastosMensaisDTO>> buscar(@RequestBody GastoDTO filter) {
        var gastos = _gastoApplication.findTotaisPorMes(filter);
        return ResponseEntity.ok(gastos);
    }

}



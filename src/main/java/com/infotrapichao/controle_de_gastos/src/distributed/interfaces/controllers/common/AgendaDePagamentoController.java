package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.controllers.common;

import com.infotrapichao.controle_de_gastos.src.application.contracts.common.IAgendaDePagamentoApplication;
import com.infotrapichao.controle_de_gastos.src.application.contracts.common.IGastoApplication;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.AgendaDePagamentoDTO;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.GastoDTO;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.mappers.AgendaDePagamentoMapper;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.mappers.GastoMapper;
import com.infotrapichao.controle_de_gastos.src.domain.models.common.AgendaDePagamento;
import com.infotrapichao.controle_de_gastos.src.domain.models.common.Gasto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("agendasdepagamento")
public class AgendaDePagamentoController {
    private final IAgendaDePagamentoApplication _agendaDePagamentoApplication;

    public AgendaDePagamentoController(IAgendaDePagamentoApplication agendaDePagamentoApplication) {
        this._agendaDePagamentoApplication = agendaDePagamentoApplication;
    }

    @PostMapping
    public ResponseEntity<AgendaDePagamento> create(@Validated @RequestBody AgendaDePagamentoDTO agendaDePagamentoDTO){

        AgendaDePagamento agendaDePagamento = AgendaDePagamentoMapper.toAgendaDePagamento(agendaDePagamentoDTO);
        var agendamentoCreated = _agendaDePagamentoApplication.create(agendaDePagamento );
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(agendamentoCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(agendamentoCreated);
    }

    @PutMapping()
    public ResponseEntity<AgendaDePagamento> put(@RequestBody AgendaDePagamentoDTO agendaDePagamentoDTO){

        AgendaDePagamento agendaDePagamento = AgendaDePagamentoMapper.toAgendaDePagamento(agendaDePagamentoDTO);
        var agendaDePagamentoUpdated = _agendaDePagamentoApplication.update(agendaDePagamento);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(agendaDePagamentoUpdated.getId())
                .toUri();
        return ResponseEntity.created(location).body(agendaDePagamentoUpdated);
    }

    @GetMapping()
    public ResponseEntity<List<AgendaDePagamentoDTO>> findAll(){
        var lista = AgendaDePagamentoMapper.toAgendamentoDTOList(_agendaDePagamentoApplication.findAll());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaDePagamento> findById(@PathVariable("id") Integer id){
        var agendaDePagamento = _agendaDePagamentoApplication.findById(id);
        return ResponseEntity.ok(agendaDePagamento);
    }
    @PostMapping("/filtrar")
    public ResponseEntity<List<AgendaDePagamentoDTO>> filtrar(@RequestBody AgendaDePagamentoDTO filter) {
        var agendasDePagamento = _agendaDePagamentoApplication.findAllByFilter(filter);
        var lista = AgendaDePagamentoMapper.toAgendamentoDTOList(agendasDePagamento);
        return ResponseEntity.ok(lista);
    }

}

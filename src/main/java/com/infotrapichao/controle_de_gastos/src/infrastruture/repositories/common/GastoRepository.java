package com.infotrapichao.controle_de_gastos.src.infrastruture.repositories.common;

import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.GastosMensaisDTO;
import com.infotrapichao.controle_de_gastos.src.domain.models.common.Gasto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GastoRepository  extends JpaRepository<Gasto, Integer> {
    List<Gasto> findAll(Specification<Gasto> agendamentoSpecification);


    @Query("SELECT new com.infotrapichao.controle_de_gastos.src.dto.GastosMensaisDTO(" +
            "FUNCTION('MONTHNAME', g.createdAt), SUM(g.valor)) " +
            "FROM Gasto g " +
            "WHERE g.deletado = false " +
            "GROUP BY FUNCTION('MONTH', g.createdAt) " +
            "ORDER BY FUNCTION('MONTH', g.createdAt)")
    List<GastosMensaisDTO> findTotaisPorMes();

    }
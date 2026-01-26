package com.infotrapichao.controle_de_gastos.src.infrastruture.repositories.specification;

import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.AgendaDePagamentoDTO;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.GastoDTO;
import com.infotrapichao.controle_de_gastos.src.domain.models.common.AgendaDePagamento;
import com.infotrapichao.controle_de_gastos.src.domain.models.common.Gasto;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AgendaDePagamentoEspecification {
    public static Specification<AgendaDePagamento> withFiltersDTO(AgendaDePagamentoDTO filtro) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();


            ///Por Id
            if (filtro.getId() != null && filtro.getId() != 0) {
                predicates.add(cb.equal(root.get("id"), filtro.getId()));
            }
            ///por User Id:
            if (filtro.getUser().getId() != null && filtro.getUser().getId() != 0) {
                predicates.add(cb.equal(root.get("user").get("id"), filtro.getUser().getId()));
            }
            ///Data
            if (filtro.getCreatedAt() != null) {
                predicates.add(cb.equal(root.get("createdAt"), filtro.getCreatedAt()));
            }

            ///Deletado
            if (filtro.getDeletado() != null) {
                predicates.add(cb.equal(root.get("deletado"), filtro.getDeletado()));
            }
            // 🔹 Filtro por intervalo de datas (between)
            if (filtro.getDataInicial() != null && filtro.getDataFinal() != null) {
                LocalDateTime inicio = filtro.getDataInicial().atStartOfDay();
                LocalDateTime fim = filtro.getDataFinal().atTime(LocalTime.MAX); // 23:59:59.999...
                predicates.add(cb.between(root.get("updatedAt"), inicio, fim));
            } else if (filtro.getDataInicial() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("updatedAt"), filtro.getDataInicial().atStartOfDay()));
            } else if (filtro.getDataFinal() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("updatedAt"), filtro.getDataFinal().atTime(LocalTime.MAX)));
            }

            // 🔽 Ordenação por updatedAt DESC
            assert query != null;

            query.orderBy(cb.asc(root.get("updatedAt")));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}


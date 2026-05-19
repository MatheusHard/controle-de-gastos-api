package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.controllers.common;

import com.infotrapichao.controle_de_gastos.src.application.contracts.common.IGastoApplication;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.GastoDTO;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.mappers.GastoMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import static com.infotrapichao.controle_de_gastos.src.distributed.interfaces.core.utils.Utils.*;

@RestController
@RequestMapping("relatorio")
public class RelatorioController {

    private final IGastoApplication _gastoApplication;

    public RelatorioController(IGastoApplication gastoApplication) {
        this._gastoApplication = gastoApplication;
    }

    @PostMapping("/gastos")
    public ResponseEntity<byte[]> gerarExcel(@RequestBody GastoDTO filter) {

        try {

            var gastos = _gastoApplication.findAllByFilter(filter);
            List<GastoDTO> lista = GastoMapper.toAgendamentoDTOList(gastos);

            InputStream template = new ClassPathResource("templates/relatorio_gastos.xlsx").getInputStream();
            XSSFWorkbook workbook = new XSSFWorkbook(template);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int rowNum = 2;

            for (GastoDTO gasto : lista) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(gasto.getDescricao());
                row.createCell(1).setCellValue(gasto.getVencimento() != null ? getDataFormatada(gasto.getVencimento(), true) : "");
                row.createCell(2).setCellValue(convertValor(gasto.getValor()));
                row.createCell(3).setCellValue(gasto.getStatusPagamento() != null ? convertStatusPagamento(gasto.getStatusPagamento()) : "");
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            workbook.close();

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=relatorio_gastos.xlsx"
                    )
                    .contentType(
                            MediaType.parseMediaType(
                                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
                            )
                    )
                    .body(outputStream.toByteArray());

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}


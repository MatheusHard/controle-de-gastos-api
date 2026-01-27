package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.core.utils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class Utils {
    public static String decodeBase64(String input) {
        return  new String(Base64.getDecoder().decode(input), StandardCharsets.UTF_8);
    }

    public static String getDataFormatada(LocalDateTime data, boolean max){
        DateTimeFormatter formatter;
        if(!max) {
             formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        }else{
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        }
        return data.format(formatter);
    }
}

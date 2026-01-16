package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.core.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Utils {
    public static String decodeBase64(String input) {
        return  new String(Base64.getDecoder().decode(input), StandardCharsets.UTF_8);
    }
}

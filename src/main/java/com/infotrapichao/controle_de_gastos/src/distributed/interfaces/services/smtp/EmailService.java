package com.infotrapichao.controle_de_gastos.src.distributed.interfaces.services.smtp;

import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.core.utils.Utils;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.dtos.common.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(EmailDTO emailDTO) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailDTO.getDestinatario());
            message.setSubject(emailDTO.getAssunto());
            message.setText(getCorpo(emailDTO));
            message.setFrom(emailDTO.getRemetente()); // mesmo e-mail configurado no SMTP

            mailSender.send(message);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private String getCorpo(EmailDTO emailDTO){

        String nomeUser = emailDTO.getNomeUsuario();
        String descricao = emailDTO.getDescricao();
        String valor = emailDTO.getValor().toString();
        String dataVencimento = Utils.getDataFormatada(emailDTO.getVencimento(), false);

        return String.format("""
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset="UTF-8">
            </head>
            <body style="font-family: Arial, sans-serif; font-size: 16px; color: #000;">
              <p>Olá <strong>Sr.(a) %s</strong>,</p>
              <br>
              <p>Sua fatura:</p>
              <p><strong style="font-size: 18px;">%s</strong></p>
              <p>Valor: R$ %s</p>
              <p>Vence em: %s</p>
            </body>
            </html>
            """, nomeUser, descricao, valor, dataVencimento);

    }
}

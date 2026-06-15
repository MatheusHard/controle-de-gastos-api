package com.infotrapichao.controle_de_gastos.src.domain.models.common;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.infotrapichao.controle_de_gastos.src.distributed.interfaces.enums.StatusPagamentoEnum;
import com.infotrapichao.controle_de_gastos.src.domain.models.security.User;
import jakarta.persistence.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6)")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6)")
    private LocalDateTime updatedAt;

    @Column(name = "vencimento", columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6)")
    private LocalDateTime vencimento;

    @Column(length = 50, nullable = false)
    private String descricao;

    @Column(columnDefinition = "bit(1) default 0")
    private boolean deletado = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(precision = 19, scale = 2) // 19 dígitos no total, 2 após a vírgula
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "agendadepagamento_id")
    @JsonBackReference(value = "agendadepagamento-gastos")
    private AgendaDePagamento agendaDePagamento;

    @Column
    @Comment("0 = Não pago, 1 = Vencido, 2 = Pago")
    private StatusPagamentoEnum statusPagamento;

    @Column(columnDefinition = "bit(1) default 0")
    private boolean pago = false;

    private String photoName;

    private String imagemBase64;

    public Gasto() {
    }

    public Gasto(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime vencimento,
            String descricao, boolean deletado, User user, BigDecimal valor, AgendaDePagamento agendaDePagamento,
            StatusPagamentoEnum statusPagamento, boolean pago, String photoName, String imagemBase64) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.vencimento = vencimento;
        this.descricao = descricao;
        this.deletado = deletado;
        this.user = user;
        this.valor = valor;
        this.agendaDePagamento = agendaDePagamento;
        this.statusPagamento = statusPagamento;
        this.pago = pago;
        this.photoName = photoName;
        this.imagemBase64 = imagemBase64;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDateTime vencimento) {
        this.vencimento = vencimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public AgendaDePagamento getAgendaDePagamento() {
        return agendaDePagamento;
    }

    public void setAgendaDePagamento(AgendaDePagamento agendaDePagamento) {
        this.agendaDePagamento = agendaDePagamento;
    }

    public StatusPagamentoEnum getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamentoEnum statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }
}

package com.baraujo.pagamentoms.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_transferir")
public class Transferir {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_carteira_remetente")
    private Carteira remetente;

    @ManyToOne
    @JoinColumn(name = "id_carteira_receptor")
    private Carteira receptor;

    @Column(name = "valor")
    private BigDecimal valor;

    public Transferir() {
    }

    public Transferir(Carteira remetente, Carteira receptor, BigDecimal valor) {
        this.remetente = remetente;
        this.receptor = receptor;
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Carteira getRemetente() {
        return remetente;
    }

    public void setRemetente(Carteira remetente) {
        this.remetente = remetente;
    }

    public Carteira getReceptor() {
        return receptor;
    }

    public void setReceptor(Carteira receptor) {
        this.receptor = receptor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}

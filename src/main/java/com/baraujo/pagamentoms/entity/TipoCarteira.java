package com.baraujo.pagamentoms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

import java.util.Objects;

@Entity
@Table(name = "tb_tipo_carteira")
public class TipoCarteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    public TipoCarteira() {
    }

    public TipoCarteira(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoCarteira that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }

    public enum Tipo {
        CLIENTE(1L, "cliente"),
        LOJISTA(2L, "lojista");

        Tipo(Long id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        private Long id;
        private String descricao;

        public TipoCarteira get() {
            return new TipoCarteira(id, descricao);
        }
    }
}

package com.baraujo.pagamentoms.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_carteira")
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf_cnpj", unique = true)
    private String cpfCnpj;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "saldo")
    private BigDecimal saldo = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "id_tipo_carteira")
    private TipoCarteira tipoCarteira;

    public Carteira() {
    }

    public Carteira(String nome, String cpfCnpj, String email, String senha, TipoCarteira tipoCarteira) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.senha = senha;
        this.tipoCarteira = tipoCarteira;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public TipoCarteira getTipoCarteira() {
        return tipoCarteira;
    }

    public void setTipoCarteira(TipoCarteira tipoCarteira) {
        this.tipoCarteira = tipoCarteira;
    }

    public boolean isTransferirParaTipoCarteira() {
        return this.tipoCarteira.equals(TipoCarteira.Tipo.CLIENTE.get());
    }

    public boolean isSaldoDisponivel(BigDecimal valor) {
        return this.saldo.doubleValue() > valor.doubleValue();
    }

    public void debitar(BigDecimal valor) {
        this.saldo = this.saldo.subtract(valor);
    }

    public void creditar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }
}

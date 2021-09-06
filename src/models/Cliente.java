package models;

import java.util.date;

public class Cliente {

    private String nomeC;
    private String cpf;
    private Date dataNasc;
    private Endereco endereco;
    private Telefone telefone;
    private Cartao cartao;

    public Cliente(String nomeC, String cpf, Date dataDeNasc, Endereco endereco, Cartao cartao) {
        this.nomeC = nomeC;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cartao = cartao;
    }


    public String getNomeC() {
        return nomeC;
    }

    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNasc() {
        return dataDeNasc;
    }

    public void setDataDeNasc(Date dataDeNasc) {
        this.dataDeNasc = dataDeNasc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }



}

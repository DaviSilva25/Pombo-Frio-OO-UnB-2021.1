package models;

import java.util.*;

public class Cliente {

    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Endereco endereco;
    private Telefone telefone;
    private Cartao cartao;

    public Cliente(String nome, String cpf, Date dataNascimento, Endereco endereco,Telefone telefone, Cartao cartao) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return  " Cliente:" + "\n" +
                " Nome: " + nome + "\n" +
                " CPF: " + cpf + "\n" +
                " Data de Nascimento: " + dataNascimento + "\n" +
                " Endereco: " + endereco + "\n" +
                " Telefone: " + telefone + "\n" +
                " Cartao: " + cartao + "\n";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

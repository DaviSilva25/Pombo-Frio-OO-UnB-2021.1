package models;

public class Loja {
    //ATRIBUTOS PROPIOS
    private String nome;
    private String cnpj;
    private Telefone telefone;
    private Endereco endereco;
    private Estoque estoque;

    //CONSTRUTORES LOJA
    public Loja(String nome, String cnpj, Telefone telefone, Endereco endereco, Estoque estoque) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
        this.estoque = estoque;
    }

    //GETS E SETS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}

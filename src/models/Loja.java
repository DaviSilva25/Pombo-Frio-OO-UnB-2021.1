package models;

/**
 * Classe modelo Loja
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */

public class Loja {
    //ATRIBUTOS PROPIOS
    private String nome;
    private String cnpj;
    private Telefone telefone;
    private Endereco endereco;
    private Estoque estoque;
    
    /**
     * Construtor Loja
     * 
     * @param nome String que representa o nome da loja.
     * @param cnpj String que representa o cnpj da loja.
     * @param telefone Telefone que representa o telefone da loja.
     * @param endereco Endereco que representa o endereco da loja.
     * @param estoque Estoque que representa o estoque da loja.
     */
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

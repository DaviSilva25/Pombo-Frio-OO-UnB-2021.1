package models;

public class Cartao {
    //ATRIBUTOS PROPIOS
    private String nome;
    private String numero;
    private String cvv;
    private String dataVencimento;

    //CONSTRUTORES CARTAO
    public Cartao(String nome, String numero, String cvv, String dataVencimento) {
        this.nome = nome;
        this.numero = numero;
        this.cvv = cvv;
        this.dataVencimento = dataVencimento;
    }
    public Cartao(){
    }

    @Override
    public String toString() {
        return "Nome[" +nome+ "], Numero[" +numero+ "], Cvv[" + cvv + "], Data de Vencimento[" +dataVencimento+ "]";
    }

    //GETS E SETS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}

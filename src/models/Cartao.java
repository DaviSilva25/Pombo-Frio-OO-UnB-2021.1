package models;
/**
 * Classe modelo Cartao
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */
public class Cartao {
    //ATRIBUTOS PROPIOS
    private String nome;
    private String numero;
    private String cvv;
    private String dataVencimento;
    
    /**
     * Construtor de cartao
     * 
     * @param nome String que representa o nome do cartao
     * @param numero String que representa o numero do cartao
     * @param cvv String que representa o cvv do cartao
     * @param dataVencimento String que representa a data de vencimento do cartao
     */
    //CONSTRUTORES CARTAO
    public Cartao(String nome, String numero, String cvv, String dataVencimento) {
        this.nome = nome;
        this.numero = numero;
        this.cvv = cvv;
        this.dataVencimento = dataVencimento;
    }
    public Cartao(){
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

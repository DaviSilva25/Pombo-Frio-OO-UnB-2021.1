package models;
/**
 * Classe modelo Endereco
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */
public class Endereco {
    //METODOS PROPIOS
    private String uf;
    private String cidade;
    private String bairro;
    private String logradouro;
    
    /**
     * Construtor de endereco
     * 
     * @param uf String que representa uf de endereco.
     * @param cidade String que representa cidade de endereco.
     * @param bairro String que representa bairro de endereco.
     * @param logradouro String que representa logradouro de endereco.
     */
    //CONSTRUTOR ENDERECO
    public Endereco(String uf, String cidade, String bairro, String logradouro) {
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
    }
    public Endereco(){
    }

    //GETS E SETS
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}

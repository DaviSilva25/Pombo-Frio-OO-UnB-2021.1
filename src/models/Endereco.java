package models;

public class Endereco {
    //METODOS PROPIOS
    private String uf;
    private String cidade;
    private String bairro;
    private String logradouro;

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

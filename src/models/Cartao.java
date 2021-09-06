package models;

import java.util.Date;

public class Cartao {
    private String nomeCartao;
    private String numeroCartao;
    private String cvv;
    private Date data;

    public Cartao(String nomeCartao, String numeroCartao, String cvv, Date data) {
        this.nomeCartao = nomeCartao;
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
        this.data = data;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

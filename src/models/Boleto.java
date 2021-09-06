package models;
import java.util.*;
public class Boleto {

    private Venda venda[];
    private Loja dadosL;
    private Cliente dadosC;
    private Date dataVenc;
    private String codigoDeBarra;

    public Boleto(Venda[] venda, Loja dadosL, Cliente dadosC, Date dataVenc, String codigoDeBarra) {
        this.venda = venda;
        this.dadosL = dadosL;
        this.dadosC = dadosC;
        this.dataVenc = dataVenc;
        this.codigoDeBarra = codigoDeBarra;
    }

    public Venda[] getVenda() {
        return venda;
    }

    public void setVenda(Venda[] venda) {
        this.venda = venda;
    }

    public Loja getDadosL() {
        return dadosL;
    }

    public void setDadosL(Loja dadosL) {
        this.dadosL = dadosL;
    }

    public Cliente getDadosC() {
        return dadosC;
    }

    public void setDadosC(Cliente dadosC) {
        this.dadosC = dadosC;
    }

    public Date getDataVenc() {
        return dataVenc;
    }

    public void setDataVenc(Date dataVenc) {
        this.dataVenc = dataVenc;
    }

    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }
}

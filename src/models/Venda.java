package models;
import java.util.*;

public class Venda {

    private int codigoDeVenda;
    private Date dataDaVenda;
    private double valorFinal;
    private String formaDePagamento;
    private Frete frete;
    private Carrinho carrinhoV;

    public Venda(int codigoDeVenda, Date dataDaVenda, double valorFinal, String formaDePagamento, Frete frete, Carrinho carrinhoV) {
        this.codigoDeVenda = codigoDeVenda;
        this.dataDaVenda = dataDaVenda;
        this.valorFinal = valorFinal;
        this.formaDePagamento = formaDePagamento;
        this.frete = frete;
        this.carrinhoV = carrinhoV;
    }

    public int getCodigoDeVenda() {
        return codigoDeVenda;
    }

    public void setCodigoDeVenda(int codigoDeVenda) {
        this.codigoDeVenda = codigoDeVenda;
    }

    public Date getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(Date dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public Carrinho getCarrinhoV() {
        return carrinhoV;
    }

    public void setCarrinhoV(Carrinho carrinhoV) {
        this.carrinhoV = carrinhoV;
    }
}

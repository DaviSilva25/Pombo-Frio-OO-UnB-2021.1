package models;
import java.util.*;

public class Venda {

    private String codigoDeVenda;
    private Date dataDaVenda;
    private double valorFinal;
    private String formaDePagamento;
    private double frete;
    private Carrinho carrinho;

    private Boleto boleto;
    private Cartao cartao;

    public Venda(String codigoDeVenda, Date dataDaVenda, double valorFinal, String formaDePagamento, double frete, Carrinho carrinho) {
        this.codigoDeVenda = codigoDeVenda;
        this.dataDaVenda = dataDaVenda;
        this.valorFinal = valorFinal;
        this.formaDePagamento = formaDePagamento;
        this.frete = frete;
        this.carrinho = carrinho;
    }

    public String getCodigoDeVenda() {
        return codigoDeVenda;
    }

    public void setCodigoDeVenda(String codigoDeVenda) {
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

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}

package models;

public class Frete {

    private Venda enderecoC;
    private Loja enderecoLoja;
    private double valorDoFrete;

    public Frete(Venda enderecoC, Loja enderecoLoja, double valorDoFrete) {
        this.enderecoC = enderecoC;
        this.enderecoLoja = enderecoLoja;
        this.valorDoFrete = valorDoFrete;
    }

    public Venda getEnderecoC() {
        return enderecoC;
    }

    public void setEnderecoC(Venda enderecoC) {
        this.enderecoC = enderecoC;
    }

    public Loja getEnderecoLoja() {
        return enderecoLoja;
    }

    public void setEnderecoLoja(Loja enderecoLoja) {
        this.enderecoLoja = enderecoLoja;
    }

    public double getValorDoFrete() {
        return valorDoFrete;
    }

    public void setValorDoFrete(double valorDoFrete) {
        this.valorDoFrete = valorDoFrete;
    }
}

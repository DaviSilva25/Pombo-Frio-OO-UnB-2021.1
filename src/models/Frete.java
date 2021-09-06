package models;

public class Frete {

    private Cliente enderecoC;
    private Loja enderecoLoja;
    private double valorDoFrete;

    public Frete(Cliente enderecoC, Loja enderecoLoja, double valorDoFrete) {
        this.enderecoC = enderecoC;
        this.enderecoLoja = enderecoLoja;
        this.valorDoFrete = valorDoFrete;
    }

    public Cliente getEnderecoC() {
        return enderecoC;
    }

    public void setEnderecoC(Cliente enderecoC) {
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

package models;

public class Carrinho {

    private Cliente cliente;
    private Loja produto;
    private int quantItens;

    public Carrinho(Cliente cliente, Loja produto, int quantItens) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantItens = quantItens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Loja getProduto() {
        return produto;
    }

    public void setProduto(Loja produto) {
        this.produto = produto;
    }

    public int getQuantItens() {
        return quantItens;
    }

    public void setQuantItens(int quantItens) {
        this.quantItens = quantItens;
    }
}

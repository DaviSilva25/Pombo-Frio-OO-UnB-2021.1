package models;

public class Carrinho {

    private Cliente clienteC;
    private Estoque estoqueC;
    private int quantRetiradaEstoque;

    public Carrinho(Cliente clienteC, Estoque estoqueC, int quantRetiradaEstoque, int quantItensDiff) {
        this.clienteC = clienteC;
        this.estoqueC = estoqueC;
        this.quantRetiradaEstoque = quantRetiradaEstoque;
    }

    public Cliente getClienteC() {
        return clienteC;
    }

    public void setClienteC(Cliente clienteC) {
        this.clienteC = clienteC;
    }

    public Estoque getEstoqueC() {
        return estoqueC;
    }

    public void setEstoqueC(Estoque estoqueC) {
        this.estoqueC = estoqueC;
    }

    public int getQuantRetiradaEstoque() {
        return quantRetiradaEstoque;
    }

    public void setQuantRetiradaEstoque(int quantRetiradaEstoque) {
        this.quantRetiradaEstoque = quantRetiradaEstoque;
    }
}

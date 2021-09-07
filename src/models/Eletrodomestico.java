package models;

public class Eletrodomestico extends Produto {

    private double capacidade;
    private double voltagem;
    private double potencia;

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public double getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(double voltagem) {
        this.voltagem = voltagem;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public Eletrodomestico(int idProduto, String nome, String descricao, String cor, double preco, double tamanho,
                           String fabricante, int quantidade, double capacidade, double voltagem, double potencia) {
        super(idProduto, nome, descricao, cor, preco, tamanho, fabricante, quantidade);
        this.capacidade = capacidade;
        this.voltagem = voltagem;
        this.potencia = potencia;


    }
}
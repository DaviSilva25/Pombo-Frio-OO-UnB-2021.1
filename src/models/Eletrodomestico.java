package models;

public class Eletrodomestico extends Produto {

    private String capacidade;
    private String voltagem;
    private String potencia;

    public Eletrodomestico(int idProduto, String nome, String descricao, String cor, double preco, String tamanho,
                           String fabricante, int quantidade, String capacidade, String voltagem, String potencia) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.cor = cor;
        this.preco = preco;
        this.tamanho = tamanho;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.capacidade = capacidade;
        this.voltagem = voltagem;
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return  " Eletrodomestico["+idProduto+"]\n" +
                " Nome: " + nome + "\n" +
                " Descricao: " + descricao + "\n" +
                " Cor: " + cor + "\n" +
                " Preco: " + preco + "\n" +
                " Tamanho: " + tamanho + "\n" +
                " Fabricante: " + fabricante + "\n" +
                " Quantidade: " + quantidade + "\n" +
                " capacidade: " + capacidade + "\n" +
                " voltagem: " + voltagem + "\n" +
                " Potencia: " + potencia + "\n";
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public String getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(String voltagem) {
        this.voltagem = voltagem;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }
}

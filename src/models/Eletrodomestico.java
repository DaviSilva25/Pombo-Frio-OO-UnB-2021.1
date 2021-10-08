package models;

public class Eletrodomestico extends Produto implements Cloneable{
    //ATRIBUTOS PROPIOS
    private String capacidade;
    private String voltagem;
    private String potencia;

    //CONSTRUTORES ELETRODOMESTICO
    public Eletrodomestico(int idProduto, String nome, String descricao, String cor, double preco, String tamanho,
                           String fabricante, int quantidade, String capacidade, String voltagem, String potencia) {
        //ATRIBUTOS HERDADOS DE PRODUTO
        super(idProduto, nome, descricao, cor, preco, tamanho, fabricante, quantidade);
        this.capacidade = capacidade;
        this.voltagem = voltagem;
        this.potencia = potencia;
    }
    public Eletrodomestico() {
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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

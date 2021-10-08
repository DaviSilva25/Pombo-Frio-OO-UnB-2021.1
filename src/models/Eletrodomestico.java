package models;
/**
 * Classe modelo Eletrodomestico
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */
public class Eletrodomestico extends Produto implements Cloneable{
    //ATRIBUTOS PROPIOS
    private String capacidade;
    private String voltagem;
    private String potencia;
    
    /**
     * Construtor de Eletrodomestico
     * 
     * @param idProduto int que representa o id do eletrodomestico.
     * @param nome String que representa o nome do eletrodomestico.
     * @param descricao String que representa a descricao do eletrodomestico.
     * @param cor String que representa o cor do eletrodomestico.
     * @param preco double que representa o double do eletrodomestico.
     * @param tamanho String que representa o tamanho do eletrodomestico.
     * @param fabricante String que representa o fabricante do eletrodomestico.
     * @param quantidade int que representa o quantidade do eletrodomestico.
     * @param capacidade String que representa o capacidade do eletrodomestico
     * @param voltagem  String que representa o voltagem do eletrodomestico.
     * @param potencia String que representa o potencia do eletrodomestico.
     */
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

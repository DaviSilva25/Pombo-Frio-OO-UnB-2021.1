package models;
/**
 * Classe modelo Movel
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */
public class Movel extends Produto implements Cloneable {
    //ATRIBUTOS PROPIOS
    private String ambiente;
    private String material;
    
    /**
     * Contrutor do movel.
     * 
     * @param idProduto int que representa o id do movel.
     * @param nome String que representa o nome do movel.
     * @param descricao String que representa descricao id do movel.
     * @param cor String que representa o cor do movel.
     * @param preco double que representa o preco do movel.
     * @param tamanho String que representa o tamanho do movel.
     * @param fabricante String que representa o fabricante do movel.
     * @param quantidade int que representa o quantidade do movel.
     * @param ambiente String que representa o ambiente do movel.
     * @param material String que representa o material do movel.
     */
    //CONTRUTORES MOVEL
    public Movel(int idProduto, String nome, String descricao, String cor, double preco, String tamanho,
                 String fabricante, int quantidade, String ambiente, String material) {
        //ATRIBUTOS HERDADOS DA CLASSE PRODUTO
        super(idProduto, nome, descricao, cor, preco, tamanho, fabricante, quantidade);
        this.ambiente = ambiente;
        this.material = material;
    }
    public Movel() {
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //GETS E SETS
    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}

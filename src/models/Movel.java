package models;

public class Movel extends Produto implements Cloneable {
    //ATRIBUTOS PROPIOS
    private String ambiente;
    private String material;
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

    @Override//METODO DA CLASSE PRODUTO
    public String concatenador(){
        return  "ID["+this.idProduto+ "], Nome:[" +this.nome+ "], Preco:[R$ " +this.preco+ "], Fabricante:[" +this.fabricante+ "], " +
                "Quantidade: ["+this.quantidade+ "]";
    }

    @Override
    public String toString() {
        return  " Movel: " + "\n" +
                  super.toString() + "\n" +
                " ambiente: " + ambiente + "\n" +
                " material: " + material + "\n";
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

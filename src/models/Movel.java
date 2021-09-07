package models;

public class Movel extends Produto{

    private String ambiente;
    private String material;
    private boolean montagem;

    public Movel(int idProduto, String nome, String descricao, String cor, double preco, double tamanho,
                 String fabricante, int quantidade, String ambiente, String material, boolean montagem) {
        super(idProduto, nome, descricao, cor, preco, tamanho, fabricante, quantidade);
        this.ambiente = ambiente;
        this.material = material;
        this.montagem = montagem;
    }

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

    public boolean isMontagem() {
        return montagem;
    }

    public void setMontagem(boolean montagem) {
        this.montagem = montagem;
    }
}

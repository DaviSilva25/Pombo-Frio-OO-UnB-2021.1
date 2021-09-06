package models;

public class Movel extends Produto{

    private String ambiente;
    private String material;
    private boolean montagem;

    public Movel(int idProduto, String nomeP, String descricao, String cor, double preco, double tamanho, String fabricante,
                String ambiente, String material, boolean montagem) {

        super(idProduto, nomeP, descricao, cor, preco, tamanho, fabricante);
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

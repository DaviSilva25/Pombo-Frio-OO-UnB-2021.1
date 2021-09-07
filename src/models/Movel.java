package models;

public class Movel extends Produto{

    private String ambiente;
    private String material;
    private boolean montagem;

    public Movel(int idProduto, String nome, String descricao, String cor, double preco, String tamanho,
                 String fabricante, int quantidade, String ambiente, String material, boolean montagem) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.cor = cor;
        this.preco = preco;
        this.tamanho = tamanho;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.ambiente = ambiente;
        this.material = material;
        this.montagem = montagem;
    }


    @Override
    public String toString() {
        return  " Movel["+ idProduto + "]:\n" +
                " Nome: " + nome + "\n" +
                " descricao: " + descricao + "\n" +
                " cor: " + cor + "\n" +
                " preco: " + preco + "\n" +
                " tamanho: " + tamanho + "\n" +
                " fabricante: " + fabricante + "\n" +
                " quantidade: " + quantidade + "\n" +
                " ambiente: " + ambiente + "\n" +
                " material: " + material + "\n" +
                " montagem: " + montagem + "\n";
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

package models;

public abstract class Produto {
	
	private int idProduto;
	private String nomeP;
	private String descricao;
	private String cor;
	private double preco; 
	private double tamanho; 
	private String fabricante;

	public Produto(int idProduto, String nomeP, String descricao, String cor, double preco, double tamanho, String fabricante) {
		this.idProduto = idProduto;
		this.nomeP = nomeP;
		this.descricao = descricao;
		this.cor = cor;
		this.preco = preco;
		this.tamanho = tamanho;
		this.fabricante = fabricante;	
	}
	
	
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeP() {

		return nomeP;
	}
	public void setNomeP(String nomeP) {

		this.nomeP = nomeP;
	}
	public String getDescricao() {

		return descricao;
	}
	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}
	public String getCor() {

		return cor;
	}
	public void setCor(String cor) {

		this.cor = cor;
	}
	public double getPreco() {

		return preco;
	}
	public void setPreco(double preco) {

		this.preco = preco;
	}
	public double getTamanho() {

		return tamanho;
	}
	public void setTamanho(double tamanho) {

		this.tamanho = tamanho;
	}
	public String getFabricante() {

		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
}

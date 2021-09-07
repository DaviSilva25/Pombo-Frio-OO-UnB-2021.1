package models;

public abstract class Produto {
	
	private int idProduto;
	private String nome;
	private String descricao;
	private String cor;
	private double preco; 
	private double tamanho; 
	private String fabricante;
	private int quantidade;

	public Produto(int idProduto, String nome, String descricao, String cor, double preco, double tamanho, String fabricante, int quantidade) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.cor = cor;
		this.preco = preco;
		this.tamanho = tamanho;
		this.fabricante = fabricante;
		this.quantidade = quantidade;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}

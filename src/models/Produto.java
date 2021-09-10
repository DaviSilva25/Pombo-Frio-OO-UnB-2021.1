package models;

public abstract class Produto {
	//ATRIBUTOS PROPIOS
	protected int idProduto;
	protected String nome;
	protected String descricao;
	protected String cor;
	protected double preco;
	protected String tamanho;
	protected String fabricante;
	protected int quantidade;

	//CONSTRUTORES PRODUTO
	public Produto(int idProduto, String nome, String descricao, String cor, double preco, String tamanho, String fabricante, int quantidade) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.cor = cor;
		this.preco = preco;
		this.tamanho = tamanho;
		this.fabricante = fabricante;
		this.quantidade = quantidade;
	}
	public Produto(){

	}

	//METEDO ABSTRADO A SER IMPLEMENTADO NAS CLASSES FILHAS
	public abstract String concatenador();

	@Override
	public String toString() {
		return  " ID do Produto: " + idProduto + "\n" +
				" Nome: " + nome + "\n" +
				" Descricao: " + descricao + "\n" +
				" Cor: " + cor + "\n" +
				" Preco: " + preco + "\n" +
				" Tamanho: " + tamanho + "\n" +
				" Fabricante: " + fabricante + "\n" +
				" Quantidade: " + quantidade;
	}

	//GETS E SETS
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

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
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

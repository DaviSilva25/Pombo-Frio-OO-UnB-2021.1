package models;
/**
 * Classe modelo abstrata Produto
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */
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
	
	/**
	 * Construtor Produto
	 * 
	 * @param idProduto int representa o id produto. 
	 * @param nome String representa o nome produto.
	 * @param descricao String representa o descricao produto.
	 * @param cor String representa o cor produto.
	 * @param preco double representa o preco produto.
	 * @param tamanho String representa o tamanho produto.
	 * @param fabricante String representa o fabricante produto.
	 * @param quantidade int representa o quantidade produto.
	 */
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

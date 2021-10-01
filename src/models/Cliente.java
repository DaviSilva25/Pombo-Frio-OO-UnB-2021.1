package models;

public class Cliente {
    //ATRIBUTOS PROPIOS
    private String nome;
    private String cpf;
    private String dataNascimento;
    private Endereco endereco;
    private Telefone telefone;
    private Cartao cartao;

    //CONSTRUTORES CLIENTE
    public Cliente(String nome, String cpf, String dataNascimento, Endereco endereco,Telefone telefone, Cartao cartao) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cartao = cartao;
    }
    public Cliente(){
    }

    @Override
    public String toString() {
        return  " Cliente:" + "\n" +
                " Nome: " + nome + "\n" +
                " CPF: " + cpf + "\n" +
                " Data de Nascimento: " + dataNascimento + "\n" +
                " Endereco: " + endereco + "\n" +
                " Telefone: " + telefone + "\n" +
                " Cartao: " + cartao + "\n";
    }
    //METODO PARA IMPRIMIR APENAS ALGUNS ATRIBUTOS NA SAIDA
    public String imprimirCliente(){
        return  nome+" | CPF("+cpf+") | UF("+ endereco.getUf()+ ") | Telefone "+telefone;
    }

    //GETS E SETS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}

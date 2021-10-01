package models;

import java.util.*;

public class Registro {
    //ATRIBUTOS OBTIDOS A PARTIR DE OUTRAS CLASSES
    private Loja loja;
    private Telefone telefoneLoja = new Telefone("061", "940028922");
    private Endereco enderecoLoja = new Endereco("DF", "Guará", "QE40", "Lote 10");
    private Estoque estoque = new Estoque();
    private List<Cliente> cliente = new ArrayList<>();
    private List<Telefone> telefone = new ArrayList<>();
    private List<Endereco> endereco = new ArrayList<>();
    private List<Cartao> cartao = new ArrayList<>();
    private List<Movel> movel = new ArrayList<>();
    private List<Eletrodomestico> eletro = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();
    private List<Boleto> boletos = new ArrayList<>();

    public void autoCadastro() throws CloneNotSupportedException {

        //ARRAYLISTS BASES PARA SERVIR DE PREENCHIMENTO NOS ATRIBUTOS
        String[] sigla = {"DF", "MT", "GO", "MS", "SP", "RJ", "ES", "MG", "SC", "PR", "SR", "PB", "MA",
                "CE", "PI", "RN", "PE", "AL", "SE", "BA", "AM", "PA", "TO", "RO", "RR", "AC", "AP"};
        List<String> siglas = new ArrayList<>(Arrays.asList(sigla));
        String[] nome = {"Maria", "Joao", "Davi", "Karla", "Thiago", "Carlos", "Fabiana", "Jose Lisvaldo"};
        List<String>  nomes = new ArrayList<>(Arrays.asList(nome));
        Random ale = new Random();

        //PRE CADASTRO DE LOJA
        loja = new Loja("Lojas Brasileiras", "12.345.678/0001-90", telefoneLoja, enderecoLoja, estoque);

        /*LACO DE REPETICAO RESPONSAVEL PELO PRE CADASTRO DE:
         TELEFONE, ENDERECO, CARTAO, ELETRODOMESTICO, MOVEL*/

        for (int i = 0; i < 30; i++) {

            cartao.add(i, new Cartao("Generico"+(i+1), "1234.5678.1011 - "+(i+1), ""+(101+i), "0"+(i+1)+"/2"+(i+1)));
            telefone.add(i, new Telefone(""+(i+1) * 100, "98400-000"+i));
            endereco.add(i, new Endereco(""+siglas.get(ale.nextInt(26)), "Cidade"+(i+1), "Bairro"+(i+1), "Logradouro"+(i+1)));
            eletro  .add(i, new Eletrodomestico( ((2*i)+1), "Eletrodomestico"+(i+1), "Descricao"+(i+1), "Cor"+(i+1), (i+1) * 500, "Tamanho"+(i+1),
                         "Marca"+(i+1), 400, (i+1)+"", (i+1)+"", (i+1)+""));
            cliente.add(i, new Cliente(""+nomes.get(ale.nextInt(8)), "123.456.789-"+(i+10),((ale.nextInt(29)+1))+"/"+((ale.nextInt(12)+1))+"/"+((ale.nextInt(52)+1950)),
                    endereco.get(i), telefone.get(i), cartao.get(i)));
            movel   .add(i, new Movel((2 * i), "Movel"+(i+1), "Descricao"+(i+1), "Cor"+(i+1), (i+1) * 500, "Tamanho"+(i+1),
                         "Marca"+(i+1), 400, "Ambiente"+(i+1), "Material"+(i+1)));

            estoque.estocar(eletro.get(i));
            estoque.estocar(movel.get(i));
        }

        /* LACO DE REPETICAO RESPONSAVEL PELO PRE CADASTRO DE VENDA*/
        for (int i = 0; i < 7; i++) {
            int a = ale.nextInt(20);
            int b = ale.nextInt(20);
            int a1 = ale.nextInt(10);
            int b1 = ale.nextInt(10);

            String pagamento = "CARTAO";
            if (i % 2 == 0)
                pagamento = "BOLETO";

            vendas.add(i, new Venda(cliente.get(i), loja, pagamento));

            for (int j = 0; j < ale.nextInt(5)+1; j++)
                vendas.get(i).adicionar(movel.get(a1), a);
            estoque.setQuantEstoque(a);

            for (int j = 0; j < ale.nextInt(5)+1; j++)
                vendas.get(i).adicionar(eletro.get(b1), b);
            estoque.setQuantEstoque(b);

            vendas.get(i).setValorFinal();
            vendas.get(i).setCodigoDeVenda();

        }

    }

    //GETS E SETS
    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Telefone getTelefoneLoja() {
        return telefoneLoja;
    }

    public void setTelefoneLoja(Telefone telefoneLoja) {
        this.telefoneLoja = telefoneLoja;
    }

    public Endereco getEnderecoLoja() {
        return enderecoLoja;
    }

    public void setEnderecoLoja(Endereco enderecoLoja) {
        this.enderecoLoja = enderecoLoja;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public List<Cartao> getCartao() {
        return cartao;
    }

    public void setCartao(List<Cartao> cartao) {
        this.cartao = cartao;
    }

    public List<Movel> getMovel() {
        return movel;
    }

    public void setMovel(List<Movel> movel) {
        this.movel = movel;
    }

    public List<Eletrodomestico> getEletro() {
        return eletro;
    }

    public void setEletro(List<Eletrodomestico> eletro) {
        this.eletro = eletro;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }
}

package models;

import java.util.*;

public class Registro {
    //ATRIBUTOS OBTIDOS A PARTIR DE OUTRAS CLASSES
    private Loja loja;
    private final Telefone telefoneLoja = new Telefone("061", "940028922");
    private final Endereco enderecoLoja = new Endereco("DF", "Guará", "QE40", "Lote 10");
    private final Estoque estoque = new Estoque();
    private List<Cliente> cliente = new ArrayList<>();
    private final List<Telefone> telefone = new ArrayList<>();
    private final List<Endereco> endereco = new ArrayList<>();
    private final List<Cartao> cartao = new ArrayList<>();
    private final List<Movel> movel = new ArrayList<>();
    private final List<Eletrodomestico> eletro = new ArrayList<>();
    private final List<Venda> vendas = new ArrayList<>();

    public void autoCadastro() throws CloneNotSupportedException {

        //ARRAYLISTS BASES PARA SERVIR DE PREENCHIMENTO NOS ATRIBUTOS
        String[] sigla = {"DF", "MT", "GO", "MS", "SP", "RJ", "ES", "MG", "SC", "PR", "RS", "PB", "MA",
                "CE", "PI", "RN", "PE", "AL", "SE", "BA", "AM", "PA", "TO", "RO", "RR", "AC", "AP"};
        List<String> siglas = new ArrayList<>(Arrays.asList(sigla));
        String[] nome = {"Anna","Bianca", "Camila", "Davi", "Eliete", "Fabiana", "Joao", "Karla", "Laura",
                "Mendel", "Natasha", "Odete", "Paula", "Rafael", "Sonia", "Thiago", "Vitor"};
        List<String>  nomes = new ArrayList<>(Arrays.asList(nome));
        String[] sobrenome = {"Silva", "Gomes", "Lima", "Oliveira", "Feliciano","Mariath","Mendes"};
        List<String>  sobrenomes = new ArrayList<>(Arrays.asList(sobrenome));

        String[] movel1 = {"Sofa", "Guarda-Roupa", "Cama", "Mesa", "Escrivaninha","Cadeira","Painel"};
        List<String>  moveis = new ArrayList<>(Arrays.asList(movel1));
        String[] eletro1 = {"Fogao", "Microo-ondas", "Lavadora", "Geladeira", "Freezer","Forno","Lava-loucas"};
        List<String>  eletros = new ArrayList<>(Arrays.asList(eletro1));

        String[] cor = {"Vermelho", "Azul", "Verde", "Laranja", "Amarelo","Roxo","Preto", "Branco"};
        List<String>  cores = new ArrayList<>(Arrays.asList(cor));

        Random ale = new Random();

        //PRE CADASTRO DE LOJA
        loja = new Loja("POMBO FRIO", "12.345.678/0001-90", telefoneLoja, enderecoLoja, estoque);

        /*LACO DE REPETICAO RESPONSAVEL PELO PRE CADASTRO DE:
         TELEFONE, ENDERECO, CARTAO, ELETRODOMESTICO, MOVEL*/

        for (int i = 0; i < 170; i++) {
            cartao.add(i, new Cartao("Generico"+(i+1), "1234.5678.1011 - "+(i+1), ""+(101+i), "02/2030"));
            telefone.add(i, new Telefone("061", "984000"+(100+i)));
            endereco.add(i, new Endereco(""+siglas.get(ale.nextInt(26)), "Cidade"+(i+1), "Bairro"+(i+1), "Logradouro"+(i+1)));
            cliente.add(i, new Cliente(nomes.get(ale.nextInt(nomes.size()))+" "+sobrenomes.get(ale.nextInt(sobrenomes.size()))
                    , "1234567"+(i+100)
                    ,((ale.nextInt(29)+1))+"/"+((ale.nextInt(12)+1))+"/"+((ale.nextInt(52)+1950)),
                    endereco.get(i), telefone.get(i), cartao.get(i)));
        }

        for (int i = 0; i < 30; i++) {
            eletro  .add(i, new Eletrodomestico( ((2*i) + 1),   //id
                    eletros.get(ale.nextInt(eletros.size())),   //nome
                    "Descricao"+(i+1),  //descricao
                    cores.get(ale.nextInt(cores.size())),   //cor
                    (i+1) * 500,    //preco
                    ""+(i+1),    //tamanho
                    "Marca"+(i+1),  //marca
                    1000,   //quantidade
                    (i+1)+"",   //capacidade
                    (i+1)+"",   //voltagem
                    (i+1)+"")); //potencia

            movel   .add(i, new Movel((2 * (i+1)),  //id
                    moveis.get(ale.nextInt(moveis.size())), //nome
                    "Descricao"+(i+1),  //descricao
                    cores.get(ale.nextInt(cores.size())),   //cor
                    (i+1) * 500,    //preco
                    ""+(i+1),   //tamanho
                    "Marca"+(i+1),  //marca
                    1000,   //quantidade
                    "Ambiente"+(i+1),   //Ambiente
                    "Material"+(i+1))); //Material

            estoque.estocar(eletro.get(i));
            estoque.estocar(movel.get(i));
        }


        /* LACO DE REPETICAO RESPONSAVEL PELO PRE CADASTRO DE VENDA*/
        for (int i = 0; i < 100; i++) {
            int a;
            int b;
            int a1;
            int b1;

            String pagamento = "CARTAO";

            vendas.add(i, new Venda(cliente.get(ale.nextInt(170)), loja, pagamento));

            for (int j = 0; j < ale.nextInt(15)+1; j++){
                a = ale.nextInt(5)+1;
                a1 = ale.nextInt(30);
                vendas.get(i).adicionar(movel.get(a1), a);
                estoque.setQuantEstoque(a);
            }

            for (int j = 0; j < ale.nextInt(15)+1; j++){
                b = ale.nextInt(5)+1;
                b1 = ale.nextInt(30);
                vendas.get(i).adicionar(eletro.get(b1), b);
                estoque.setQuantEstoque(b);
            }

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

    public Estoque getEstoque() {
        return estoque;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public List<Cartao> getCartao() {
        return cartao;
    }

    public List<Movel> getMovel() {
        return movel;
    }

    public List<Eletrodomestico> getEletro() {
        return eletro;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

}

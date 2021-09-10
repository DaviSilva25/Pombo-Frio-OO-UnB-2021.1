package models;
import java.util.*;

public class teste {
    public static void main(String[] args) throws CloneNotSupportedException {
        //RECEBENDO OS DADOS PRE REGISTRADOS
        Registro dado = new Registro();
        dado.autoCadastro();

        int opcao;
        Scanner ler = new Scanner(System.in);

        do {
            imprimeAlgo(1);     //METODO imprimeAlgo: IMPRIME UM CONJUNTO DE STRINGS PRE DETERMINADO
            opcao = ler.nextInt();

            //VALIDANDO OPCAO
            while (opcao < 0 || opcao > 6) {
                System.out.println(" Escolha Invalida, digite novamente: ");
                opcao = ler.nextInt();
                ler.nextInt();
            }

            //REALIZANDO OS CASOS
            switch (opcao) {
                case 1 -> ESTOQUE(dado);
                case 2 -> CLIENTE(dado);

                case 3 -> LOJA(dado);

                case 4 -> VENDA(dado);

                case 5 -> System.out.println(" PROGRAMA ENCERRADO!");
            }
        } while (opcao != 5);

    }


    //METODO PARA IMPRIMIR DETERMINADA STRING APARTIR DE UM TIPO INT
    public static void imprimeAlgo(int tipo) {
        switch (tipo) {
            case 1 -> {
                System.out.println(" === MENU DE OPCOES ===");
                System.out.println(" [1] - ESTOQUE");
                System.out.println(" [2] - CLIENTE");
                System.out.println(" [3] - LOJA");
                System.out.println(" [4] - VENDA");
                System.out.println(" [5] - ENCERRAR");
                System.out.println(" Digite a opcao desejada:");
            }
            case 2 -> {
                System.out.println(" Estoque de moveis/eletredomesticos");
                System.out.println(" Escolha um dos filtros possiveis para a busca");
                System.out.println(" [1] - Nome");
                System.out.println(" [2] - Preco");
                System.out.println(" Digite o numero da opcao desejada:");
            }
            case 3 -> {
                System.out.println(" CLIENTE");
                System.out.println(" Selecione uma opção:");
                System.out.println(" [1] - Listar todos clientes");
                System.out.println(" [2] - Buscar/alterar/deletar cliente especifico");
                System.out.println(" [3] - Cadastar novo cliente");
                System.out.println(" [4] - Voltar para o menu");
                System.out.println(" Digite o numero da opcao desajada:");
            }
            case 4 -> {
                System.out.println(" Escolha um dos filtros possiveis para a busca");
                System.out.println(" [1] - Cliente");
                System.out.println(" [2] - Codigo de venda");
                System.out.println(" Digite o numero da opcao desejada");
            }
            case 5 -> {
                System.out.println(" ESTOQUE");
                System.out.println(" Selecione uma opção:");
                System.out.println(" [1] - Listar todo o estoque");
                System.out.println(" [2] - Buscar/alterar/deletar um produto especifico");
                System.out.println(" [3] - Cadastar novo produto");
                System.out.println(" [4] - Voltar para o menu");
                System.out.println(" Digite o numero da opcao desajada:");
            }
            case 6 -> {
                System.out.println(" Deseja deletar ou alterar o produto?");
                System.out.println(" [1] - Deletar");
                System.out.println(" [2] - Alterar");
                System.out.println(" Digite o numero da opcao ou digite qualquer coisa para proseguir:");
            }
            case 7 -> {
                System.out.println(" [3] - CADASTRAR NOVO PRODUTO -");
                System.out.println(" O que deseja cadastrar?");
                System.out.println(" [1] - Movel");
                System.out.println(" [2] - Eletrodomestico");
                System.out.println(" Digite o numero da opcao desejada:");
            }
            case 8 -> {
                System.out.println(" VENDA");
                System.out.println(" Selecione uma opção:");
                System.out.println(" [1] - Listar vendas realizadas");
                System.out.println(" [2] - Buscar venda(s) especifica(s)");
                System.out.println(" [3] - Cadastar nova venda");
                System.out.println(" [4] - Voltar para o menu");
                System.out.println(" Digite o numero da opcao desajada:");
            }
            case 9 -> {
                System.out.println(" Selecione uma opção:");
                System.out.println(" [1] - Listar clientes cadastrados");
                System.out.println(" [2] - Buscar/alterar/deletar cliente(s) especifico");
                System.out.println(" [3] - Cadastar novo cliente");
                System.out.println(" [4] - Voltar para o menu");
                System.out.println(" Digite o numero da opcao desajada:");
            }
            case 10 -> {
                System.out.println(" LOJA");
                System.out.println(" Selecione uma opção:");
                System.out.println(" [1] - Listar dados");
                System.out.println(" [2] - Editar dados");
                System.out.println(" [3] - Voltar para o menu");
                System.out.println(" Digite o numero da opcao desajada:");
            }
        }
    }

    //01 - METODOS DO ESTOQUE
    public static void ESTOQUE(Registro dado) {

        //VARIAVEIS "OPCOES"(USADAS NAS ESCOLHAS DO MENU)
        int opcaoI;
        String opcaoS;
        double opcaoD;
        Estoque produtosBuscados = new Estoque();
        List<String> op = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        //VARIAVEIS AUXILIARES
        int deleteM = 0;
        int deleteE = 0;

        Scanner ler = new Scanner(System.in);

        imprimeAlgo(5);
        opcaoS = ler.nextLine();

        //VALIDACAO DA ESCOLHA
        while (!op.contains(opcaoS)) {
            System.out.println(" OPCAO INVALIDA!");
            imprimeAlgo(5);
            opcaoS = ler.nextLine();
        }
        //[01] LISTAR O ESTOQUE
        if (opcaoS.equals(op.get(0))) {
            System.out.println(" [1] - LISTA DO ESTOQUE -");
            System.out.println(dado.getEstoque().toString());
        }

        //[02] BUSCAR/ALTERAR/DELETAR UM PRODUTO
        else if (opcaoS.equals(op.get(1))) {

            imprimeAlgo(2);
            opcaoS = ler.nextLine();

            //VALIDACAO DA ESCOLHA
            while (!op.subList(0, 2).contains(opcaoS)) {
                System.out.println(" OPCAO INVALIDA!");
                imprimeAlgo(2);
                opcaoS = ler.nextLine();
            }
            //OPCAO = 1 SIGNIFICA UM FILTRO POR NOME
            if (opcaoS.equals("1")) {
                do {
                    System.out.println(" [2] - BUSCAR/ALTERAR/DELETAR PRODUTO -");
                    System.out.println(" Digite o nome do produto que deseja filtrar:");
                    opcaoS = ler.nextLine();

                    //PARA CADA MOVEL COM NOME IGUAL NA LISTA DE MOVEIS CADASTRADOS
                    //produtosBuscados(Estoque) IRA ESTOCAR O MOVEL DA POSICAO:
                    for (int i = 0; i < dado.getMovel().size(); i++) {

                        if (opcaoS.equals(dado.getMovel().get(i).getNome())) {
                            produtosBuscados.estocar(dado.getMovel().get(i));
                            deleteM = i + 1;    // SALVA UM INTEIRO PARA UMA POSSIVEL DELEÇÃO
                        }

                    }

                    //PARA CADA MOVEL COM NOME IGUAL NA LISTA DE MOVEIS CADASTRADOS
                    //produtosBuscados(Estoque) IRA ESTOCAR O MOVEL DA POSICAO:
                    for (int i = 0; i < dado.getEletro().size(); i++) {

                        if (opcaoS.equals(dado.getEletro().get(i).getNome())) {
                            produtosBuscados.estocar(dado.getEletro().get(i));
                            deleteE = i + 1;    // SALVA UM INTEIRO PARA UMA POSSIVEL DELEÇÃO
                        }

                    }

                    //SE NAO HOUVER PRODUTOS COM O NOME IGUAL:
                    if (produtosBuscados.getQuantEstoque() == 0)
                        System.out.println(" Nao ha produto com nome " + opcaoS + " no sistema.");
                    // SE HOUVER:
                    else {
                        System.out.print(produtosBuscados);

                        imprimeAlgo(6);     //PERGUTA SE DESEJA ALTERAR OU DELETAR
                        opcaoS = ler.nextLine();

                        if (opcaoS.equals("1")) {   // opcaoS = 1 = DELETAR

                            if (deleteE != 0) {
                                dado.getEstoque().getQuantEletros().remove(deleteE - 1);    //REMOVE O ELETRODOMESTICO DO ARRAYLIST
                                dado.getEletro().remove(deleteE - 1);
                            }
                            if (deleteM != 0) {
                                dado.getEstoque().getQuantMoveis().remove(deleteM - 1);     //REMOVE O MOVEL DO ARRAYLIST
                                dado.getMovel().remove(deleteM - 1);
                            }
                        }

                        else if (opcaoS.equals("2")) {  // opcaoS = 2 = DELETAR
                            System.out.println(" Edicao de " + produtosBuscados.getQuantMoveis().get(0) + ":");
                            System.out.println(" Eh possivel editar o preco e a quantidade");

                            System.out.println(" Digite o novo preco:");
                            opcaoD = ler.nextDouble();
                            ler.nextLine();

                            if (deleteE != 0)   // deleteE = quantidade total de produtos iguais encontrados anteriormente
                                dado.getEstoque().getQuantEletros().get(deleteE - 1).setPreco(opcaoD);  //altera o preco do produto na posicao deleteE - 1

                            if (deleteM != 0)   // deleteM = quantidade total de produtos iguais encontrados anteriormente
                                dado.getEstoque().getQuantMoveis().get(deleteM - 1).setPreco(opcaoD);   //altera o preco do produto na posicao deleteM - 1

                            System.out.println(" Digite a nova quantidade:");
                            opcaoI = ler.nextInt();
                            ler.nextLine();
                            if (deleteE != 0)
                                dado.getEstoque().getQuantEletros().get(deleteE - 1).setQuantidade(opcaoI); //altera o preco do produto na posicao deleteE - 1
                            if (deleteM != 0)
                                dado.getEstoque().getQuantMoveis().get(deleteM - 1).setQuantidade(opcaoI);  //altera o preco do produto na posicao deleteM - 1
                        }
                    }
                    System.out.println(" Deseja buscar outro produto no sistema?");
                    System.out.println(" Digite: SIM ou NAO");
                    opcaoS = ler.nextLine();

                    //VALIDACAO DA ESCOLHA
                    while (!opcaoS.equalsIgnoreCase("nao") && !opcaoS.equalsIgnoreCase("sim")) {
                        System.out.println(" OPCAO INVALIDA!");
                        System.out.println(" Deseja buscar outro produto no sistema?");
                        System.out.println(" Digite: SIM ou NAO");
                        opcaoS = ler.nextLine();
                    }

                    //RESET DAS VARIAVEIS
                    produtosBuscados = new Estoque();
                    deleteE = 0;
                    deleteM = 0;
                } while (!opcaoS.equalsIgnoreCase("nao"));
            }
            else {
                do {
                    System.out.println(" Digite o preco maximo que os produtos podem ter:");
                    opcaoD = ler.nextDouble();
                    ler.nextLine();

                    for (int i = 0; i < dado.getMovel().size(); i++)
                        if (opcaoD > dado.getMovel().get(i).getPreco())     //COMPARA O PRECO INSERIDO COM A LISTA DE PRECO
                            produtosBuscados.estocar(dado.getMovel().get(i));   //ESTOCA OS PRODUTOS QUE TIVEREM PRECO MENOR DO QUE O PRECO INSERIDO

                    for (int i = 0; i < dado.getEletro().size(); i++)
                        if (opcaoD > dado.getEletro().get(i).getPreco())    //COMPARA O PRECO INSERIDO COM A LISTA DE PRECO
                            produtosBuscados.estocar(dado.getEletro().get(i));  //ESTOCA OS PRODUTOS QUE TIVEREM PRECO MENOR DO QUE O PRECO INSERIDO

                    if (produtosBuscados.getQuantEstoque() == 0)
                        System.out.println(" Nao ha produto com preco abaixo de R$" + opcaoD + " no sistema.");     //SE NAO TIVER PRECO ABAIXO DO PRECO INSERIDO RETONAR:
                    else
                        System.out.println(produtosBuscados);       //IMPRIME TODOS OS PRODUTOS COM PRECO ABAIXO DO PRECO INSERIDO

                    System.out.println(" Deseja buscar por outro preco no sistema?");
                    System.out.println(" Digite: SIM ou NAO");
                    opcaoS = ler.nextLine();

                    //VALIDA A ESCOLHA ACIMA
                    while (!opcaoS.equalsIgnoreCase("nao") && !opcaoS.equalsIgnoreCase("sim")) {
                        System.out.println(" OPCAO INVALIDA!");
                        System.out.println(" Deseja buscar por outro preco no sistema?");
                        System.out.println(" Digite: SIM ou NAO");
                        opcaoS = ler.nextLine();
                    }

                    produtosBuscados = new Estoque();

                } while (!opcaoS.equalsIgnoreCase("nao"));

            }


        }

        //CADASTRAR NOVO PRODUTO
        else if (opcaoS.equals(op.get(2))) {

            //VARIAVEIS DE USO MALEAVEL
            Movel newMov = new Movel();
            Eletrodomestico newEle = new Eletrodomestico();

            imprimeAlgo(7); // PERGUNTA QUAL TIPO DE PRODUTO DESEJA CADASTRAR(MOVEL OU ELETRODOMESTICO)
            opcaoS = ler.nextLine();

            //VALIDA A OPCAO ACIMA
            while (!op.subList(0, 2).contains(opcaoS)) {
                System.out.println(" OPCAO INVALIDA!");
                imprimeAlgo(7);
                opcaoS = ler.nextLine();
            }

            //OPCAO 1 CADASTRA UM MOVEL
            if (opcaoS.equals("1")) {
                int indexM = dado.getMovel().size() - 1;       //indexM PEGA O VALOR DO TAMANHO DA LISTA DOS MOVEIS CADASTRADOS
                newMov.setIdProduto(dado.getMovel().get(indexM).getIdProduto() + 2);    //USA O indexM PARA CRIAR UM NOVO MOVEL COM ID DIFERENTE DOS DEMAIS

                //ETAPAS DO CADASTRO DO MOVEL:
                System.out.println(" Digite o nome do movel:");
                opcaoS = ler.nextLine();
                newMov.setNome(opcaoS);

                System.out.println(" Digite a descricao do movel:");
                opcaoS = ler.nextLine();
                newMov.setDescricao(opcaoS);

                System.out.println(" Digite a cor do movel:");
                opcaoS = ler.nextLine();
                newMov.setCor(opcaoS);

                System.out.println(" Digite o preco do movel:");
                opcaoD = ler.nextDouble();
                ler.nextLine();
                newMov.setPreco(opcaoD);

                System.out.println(" Digite o tamanho do movel:");
                opcaoS = ler.nextLine();
                newMov.setTamanho(opcaoS);

                System.out.println(" Digite o nome do fabricante do movel:");
                opcaoS = ler.nextLine();
                newMov.setFabricante(opcaoS);

                System.out.println(" Digite a quantidade do movel:");
                opcaoI = ler.nextInt();
                ler.nextLine();
                newMov.setQuantidade(opcaoI);

                System.out.println(" Digite um ambiente para movel:");
                opcaoS = ler.nextLine();
                newMov.setAmbiente(opcaoS);

                System.out.println(" Digite o material do movel:");
                opcaoS = ler.nextLine();
                newMov.setMaterial(opcaoS);

                dado.getMovel().add(newMov);        //ADICIONA O MOVEL NA LISTA DE MOVEIS
                dado.getEstoque().estocar(dado.getMovel().get(indexM + 1));     //ESTOCA O MOVEL NO ESTOQUE

            }
            //CADASTRO DE UM ELETRODOMESTICO
            else {
                    int indexE = dado.getEletro().size() - 1;   //ARMAZENA UM INDEX AFINS DE CRIAR UM ID DIFERENTE
                    newEle.setIdProduto(dado.getEletro().get(indexE).getIdProduto() + 2);   //CRIA O ID DIFERENTE PARA O ELETRODOMESTICO

                    //ETAPAS DO CADASTRO:
                    System.out.println(" Digite o nome do eletrodomestico:");
                    opcaoS = ler.nextLine();
                    newEle.setNome(opcaoS);

                    System.out.println(" Digite a descricao do eletrodomestico:");
                    opcaoS = ler.nextLine();
                    newEle.setDescricao(opcaoS);

                    System.out.println(" Digite a cor do eletrodomestico:");
                    opcaoS = ler.nextLine();
                    newEle.setCor(opcaoS);

                    System.out.println(" Digite o preco do eletrodomestico:");
                    opcaoD = ler.nextDouble();
                    ler.nextLine();
                    newEle.setPreco(opcaoD);

                    System.out.println(" Digite o tamanho do eletrodomestico:");
                    opcaoS = ler.nextLine();
                    newEle.setTamanho(opcaoS);

                    System.out.println(" Digite o nome do fabricante do eletrodomestico:");
                    opcaoS = ler.nextLine();
                    newEle.setFabricante(opcaoS);

                    System.out.println(" Digite a quantidade do eletrodomestico:");
                    opcaoI = ler.nextInt();
                    ler.nextLine();
                    newEle.setQuantidade(opcaoI);

                    System.out.println(" Digite a capacidade do eletrodomestico:");
                    opcaoS = ler.nextLine();
                    newEle.setCapacidade(opcaoS);

                    System.out.println(" Digite a voltagem do eletrodomestico:");
                    opcaoS = ler.nextLine();
                    newEle.setVoltagem(opcaoS);

                    System.out.println(" Digite a potencia do eletrodomestico:");
                    opcaoS = ler.nextLine();
                    newEle.setPotencia(opcaoS);

                    dado.getEletro().add(newEle);   //ADICIONA O ELETRODOMESTICO NA LISTA DE ELETRODOMESTICO
                    dado.getEstoque().estocar(dado.getEletro().get(indexE + 1));    //ESTOCA O ELETRODOMESTICO NO ESTOQUE
                }
            }
        }



    //02 METODOS DO CLIENTE
    public static void CLIENTE(Registro dado){
        //VARIAVEIS DE ESCOLHAS E ARMAZENAMENTO
        int auxCli = 0;
        String opcaoS;
        Cliente cpfCliente = new Cliente();
        List<Cliente> clienteAux = new ArrayList<>();
        List<String> op = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));

        Scanner ler = new Scanner(System.in);

        imprimeAlgo(9); //IMPRIME AS OPCOES DO MENU CLIENTE
        opcaoS = ler.nextLine();

        //VALIDA A ESCOLHA ACIMA
        while (!op.contains(opcaoS)) {
            System.out.println(" OPCAO INVALIDA!");
            imprimeAlgo(9);
            opcaoS = ler.nextLine();
        }

        //LISTAR CLIENTES
        if (opcaoS.equals(op.get(0))) {
            System.out.println(" [1] - LISTA DE CLIENTES -");
            for(int i=0; i<dado.getCliente().size();i++)
                System.out.println(dado.getCliente().get(i).imprimirCliente());
        }

        //ALTERAR/DELETAR/BUSCAR UM CLIENTE
        else if(opcaoS.equals(op.get(1))){
            System.out.println(" Digite 1 para filtrar por nome(apenas consultar)");
            System.out.println(" Digite 2 para filtrar por cpf(alterar/deletar)");
            opcaoS = ler.nextLine();

            //VALIDA  A OPCAO ACIMA
            while (!op.subList(0, 2).contains(opcaoS)) {
                System.out.println(" OPCAO INVALIDA!");
                imprimeAlgo(9);
                opcaoS = ler.nextLine();
            }

            //opcaoS = 1 = FILTRAR POR NOME(APENAS BUSCAS)
            if (opcaoS.equals("1")) {
            do {
                System.out.println(" Digite o nome do cliente a ser buscado");
                opcaoS = ler.nextLine();

                for (int i = 0; i < dado.getCliente().size(); i++)
                    if (opcaoS.equalsIgnoreCase(dado.getVendas().get(i).getCliente().getNome()))    // COMPARA O NOME INSERIDO COM TODOS CONTIDOS NO SISTEMA
                        clienteAux.add(dado.getCliente().get(i));   // SE HOUVER ALGUM IGUAL O CLIENTE DA POSICAO EH ARMAZENADO NUM ARRAYLIST

                if (clienteAux.size() == 0)
                    System.out.println(" Nao ha cliente com nome de"+opcaoS+ "no sistema");     //CASO NAO HAJA CLIENTE COM O NOME INSERIDO
                else
                    for (Cliente clienteAu : clienteAux)
                        System.out.println(clienteAu.toString().replace("[", "").replace("]", ""));     //CASO HAJA SERA IMPRESSO NA SAIDA

                System.out.println(" Deseja buscar outro nome no sistema?");
                System.out.println(" Digite: SIM ou NAO");
                opcaoS = ler.nextLine();

                //VALIDA A OPCAO
                while (!opcaoS.toLowerCase().contains("nao") && !opcaoS.toLowerCase().contains("sim")) {
                    System.out.println(" OPCAO INVALIDA!");
                    System.out.println(" Deseja buscar outro nome no sistema?");
                    System.out.println(" Digite: SIM ou NAO");
                    opcaoS = ler.nextLine();
                }

                clienteAux.clear();

            } while (!opcaoS.toLowerCase().contains("nao"));
        }
            //FILTRO POR CPF(POSSIVEL DELETAR/ALTERAR/BUSCAR)
            else {
            do {
                System.out.println(" Digite o CPF do cliente que deseja buscar:");
                opcaoS = ler.nextLine();

                for (int i = 0; i < dado.getCliente().size(); i++) {
                    if (opcaoS.equals(dado.getCliente().get(i).getCpf())){      //COMPARA O CPF INSERIDO COM O DE TODOS OS CLIENTE NO SISTEMA
                        cpfCliente = dado.getCliente().get(i);      //ATRIBUI O VALOR DO CLIENTE PARA cpfCliente
                        auxCli = i;     //ATRIBUI A auxCli o valor da posicao do cliente
                    }
                }
                    if(auxCli == 0) //SE NAO ACHAR NENHUM CPF IGUAL:
                    System.out.println(" Nao ha cliente com o cpf"+opcaoS+" no sistema");
                    else {
                        System.out.println(cpfCliente.toString());
                        System.out.println(" Deseja alterar ou deletar o cliente?");
                        System.out.println(" [1] - DELETAR");
                        System.out.println(" [2] - ALTERAR");
                        System.out.println(" Digite o numero de alguma opcao ou qualquer coisa para retornar ao menu:");
                        opcaoS = ler.nextLine();

                        // opcaoS = 1 = DELETAR
                        if (opcaoS.equals("1"))
                            dado.getCliente().remove(auxCli);
                        // opcaoS = 2 = ALTERAR
                        else if(opcaoS.equals("2")){
                            System.out.println(cpfCliente);
                            System.out.println(" Informacoes do cliente, eh possivel editar Cartao, Telefone e endereco");

                            //DADOS DO CARTAO
                            System.out.println(" Digite os novos dados do Cartao");
                            System.out.println(" Nome do cartao");
                            opcaoS = ler.nextLine();
                            cpfCliente.getCartao().setNome(opcaoS);
                            System.out.println(" CVV");
                            opcaoS = ler.nextLine();
                            cpfCliente.getCartao().setCvv(opcaoS);
                            System.out.println(" Numero do cartao");
                            opcaoS = ler.nextLine();
                            cpfCliente.getCartao().setNumero(opcaoS);
                            System.out.println(" Data de vencimento");
                            opcaoS = ler.nextLine();
                            cpfCliente.getCartao().setDataVencimento(opcaoS);

                            //DADOS DO ENDERECO
                            System.out.println(" Digite os novos dados do endereco");
                            System.out.println(" UF");
                            opcaoS = ler.nextLine();
                            cpfCliente.getEndereco().setUf(opcaoS);
                            System.out.println(" cidade");
                            opcaoS = ler.nextLine();
                            cpfCliente.getEndereco().setCidade(opcaoS);
                            System.out.println(" bairro");
                            opcaoS = ler.nextLine();
                            cpfCliente.getEndereco().setBairro(opcaoS);
                            System.out.println(" logradouro");
                            opcaoS = ler.nextLine();
                            cpfCliente.getEndereco().setLogradouro(opcaoS);

                            //DADOS DO TELEFONE
                            System.out.println(" Digite os novos dados do telefone");
                            System.out.println(" DDD");
                            opcaoS = ler.nextLine();
                            cpfCliente.getTelefone().setDdd(opcaoS);
                            opcaoS = ler.nextLine();
                            System.out.println(" Numero");
                            cpfCliente.getTelefone().setNumero(opcaoS);

                        }

                    }

                System.out.println(" Deseja buscar por outro CPF no sistema?");
                System.out.println(" Digite: SIM ou NAO");
                opcaoS = ler.nextLine();

                //VALIDA A OPCAO ACIMA
                while (!opcaoS.toLowerCase().contains("nao") && !opcaoS.toLowerCase().contains("sim")) {
                    System.out.println(" OPCAO INVALIDA!");
                    System.out.println(" Deseja buscar outro CPF no sistema?");
                    System.out.println(" Digite: SIM ou NAO");
                    opcaoS = ler.nextLine();
                }
                cpfCliente = new Cliente();
            } while (!opcaoS.toLowerCase().contains("nao"));
        }
        }
        //CADASTRO DE NOVO CLIENTE
        else if(opcaoS.equals(op.get(2))){
            Cartao setCA = new Cartao();
            Endereco setEnd = new Endereco();
            Telefone setTel = new Telefone();

            System.out.println(" [3] - CADASTRO DE NOVO CLIENTE");

            System.out.println(" Digite o nome do cliente:");
            opcaoS = ler.nextLine();
            cpfCliente.setNome(opcaoS);

            System.out.println(" Digite o CPF do cliente:");
            opcaoS = ler.nextLine();
            cpfCliente.setCpf(opcaoS);

            System.out.println(" Digite a data de nascimento do cliente:");
            opcaoS = ler.nextLine();
            cpfCliente.setDataNascimento(opcaoS);

            //DADOS DO CARTAO
            System.out.println(" Digite os novos dados do Cartao");
            System.out.println(" Nome do cartao");
            opcaoS = ler.nextLine();
            setCA.setNome(opcaoS);
            System.out.println(" CVV");
            opcaoS = ler.nextLine();
            setCA.setCvv(opcaoS);
            System.out.println(" Numero do cartao");
            opcaoS = ler.nextLine();
            setCA.setNumero(opcaoS);
            System.out.println(" Data de vencimento");
            opcaoS = ler.nextLine();
            setCA.setDataVencimento(opcaoS);
            cpfCliente.setCartao(setCA);

            //DADOS DO ENDERECO
            System.out.println(" Digite os novos dados do endereco");
            System.out.println(" UF");
            opcaoS = ler.nextLine();
            setEnd.setUf(opcaoS);
            System.out.println(" cidade");
            opcaoS = ler.nextLine();
            setEnd.setCidade(opcaoS);
            System.out.println(" bairro");
            opcaoS = ler.nextLine();
            setEnd.setBairro(opcaoS);
            System.out.println(" logradouro");
            opcaoS = ler.nextLine();
            setEnd.setLogradouro(opcaoS);
            cpfCliente.setEndereco(setEnd);

            //DADOS DO TELEFONE
            System.out.println(" Digite os dados do telefone");
            System.out.println(" DDD");
            opcaoS = ler.nextLine();
            setTel.setDdd(opcaoS);
            System.out.println(" Numero");
            opcaoS = ler.nextLine();
            setTel.setNumero(opcaoS);
            cpfCliente.setTelefone(setTel);

            dado.getCliente().add(cpfCliente);
        }
    }
    //03 METODO DA LOJA
    public static void LOJA(Registro dado){
        String opcaoS;
        Scanner ler = new Scanner(System.in);
        List<String> op = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));


        imprimeAlgo(10);
        opcaoS = ler.nextLine();

        //VALIDA OPCAO ACIMA
        while (!op.contains(opcaoS)) {
            imprimeAlgo(10);
            opcaoS = ler.nextLine();
        }
        //IMPRIME DADOS DA LOJA
        if(opcaoS.equals(op.get(0)))
            System.out.println(dado.getLoja().toString());

        //ALTERA OS DADOS DA LOJA
        else if(opcaoS.equals(op.get(1))){
            System.out.println(" [2] - ALTERAR DADOS DA LOJA -");

            System.out.println(" Eh possivel alterar nome, telefone e endereco");
            System.out.println(" Digite um novo nome para a loja:");
            opcaoS = ler.nextLine();

            //LOJA ENDERECO
            dado.getLoja().setNome(opcaoS);
            System.out.println(" Digite os novos dados do endereco");
            System.out.println(" UF");
            opcaoS = ler.nextLine();
            dado.getLoja().getEndereco().setUf(opcaoS);
            System.out.println(" cidade");
            opcaoS = ler.nextLine();
            dado.getLoja().getEndereco().setCidade(opcaoS);
            System.out.println(" bairro");
            opcaoS = ler.nextLine();
            dado.getLoja().getEndereco().setBairro(opcaoS);
            System.out.println(" logradouro");
            opcaoS = ler.nextLine();
            dado.getLoja().getEndereco().setLogradouro(opcaoS);

            //LOJA TELEFONE
            System.out.println(" Digite os novos dados do telefone");
            System.out.println(" DDD");
            opcaoS = ler.nextLine();
            dado.getLoja().getTelefone().setDdd(opcaoS);
            opcaoS = ler.nextLine();
            System.out.println(" Numero");
            dado.getLoja().getTelefone().setNumero(opcaoS);
        }
    }


    //04 METODOS DA VENDA
    public static void VENDA(Registro dado) throws CloneNotSupportedException {
        int opcaoI;
        String opcaoS;

        Scanner ler = new Scanner(System.in);
        List<String> op = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        List<Venda> clienteBuscados = new ArrayList<>();
        Cliente cliVenda = new Cliente();

        imprimeAlgo(8);
        opcaoS = ler.nextLine();

        //VALIDA OPCAO ACIMA
        while (!op.contains(opcaoS)) {
            imprimeAlgo(8);
            opcaoS = ler.nextLine();
        }
        //LISTAR VENDAS
        if (opcaoS.equals(op.get(0))) {
            System.out.println(" [1] - LISTA DE VENDAS -");
            for (int i = 0; i < dado.getVendas().size(); i++) {
                System.out.println(dado.getVendas().get(i).imprimeBasico());
            }
        }
        //BUSCAR VENDA
        else if (opcaoS.equals(op.get(1))) {
            System.out.println(" [2] - BUSCAR INFORMACAO DE VENDA");
            imprimeAlgo(4);
            opcaoS = ler.nextLine();

            while (!op.contains(opcaoS)) {
                imprimeAlgo(4);
                opcaoS = ler.nextLine();
            }
            if (opcaoS.equals("1")) {
                do {
                    System.out.println(" Digite o nome do cliente a ser buscado");
                    opcaoS = ler.nextLine();

                    for (int i = 0; i < dado.getVendas().size(); i++)
                        if (opcaoS.equalsIgnoreCase(dado.getVendas().get(i).getCliente().getNome()))   //compara opcaoS com o nome dos clientes das vendas
                            clienteBuscados.add(dado.getVendas().get(i));   //adiciona o cliente da posicao na lista de clientes buscados

                    if (clienteBuscados.size() == 0)
                        System.out.println(" Nao ha venda para este cliente no sistema.");
                    else
                        for (Venda clienteBuscado : clienteBuscados)
                            System.out.println(clienteBuscado.toString().replace("[", "").replace("]", ""));

                    System.out.println(" Deseja buscar outro nome no sistema?");
                    System.out.println(" Digite: SIM ou NAO");
                    opcaoS = ler.nextLine();

                    while (!opcaoS.toLowerCase().contains("nao") && !opcaoS.toLowerCase().contains("sim")) {
                        System.out.println(" OPCAO INVALIDA!");
                        System.out.println(" Deseja buscar outro nome no sistema?");
                        System.out.println(" Digite: SIM ou NAO");
                        opcaoS = ler.nextLine();
                    }

                    clienteBuscados.clear();

                } while (!opcaoS.toLowerCase().contains("nao"));
            } else {
                do {
                    System.out.println(" Digite o codigo da venda que deseja buscar:");
                    opcaoS = ler.nextLine();
                    boolean a = true;
                    for (int i = 0; i < dado.getVendas().size(); i++) {
                        a = true;
                        if (opcaoS.equals(dado.getVendas().get(i).getCodigoDeVenda())) {
                            System.out.println(dado.getVendas().get(i).imprimeBasico());
                            break;
                        } else
                            a = false;
                    }

                    if (!a)
                        System.out.println(" Nao ha venda com o codigo " + opcaoS + " no sistema.");

                    System.out.println(" Deseja buscar por outro codigo no sistema?");
                    System.out.println(" Digite: SIM ou NAO");
                    opcaoS = ler.nextLine();

                    while (!opcaoS.toLowerCase().contains("nao") && !opcaoS.toLowerCase().contains("sim")) {
                        System.out.println(" OPCAO INVALIDA!");
                        System.out.println(" Deseja buscar outro codigo no sistema?");
                        System.out.println(" Digite: SIM ou NAO");
                        opcaoS = ler.nextLine();
                    }

                } while (!opcaoS.toLowerCase().contains("nao"));

            }
        }
        //CADASTRAR VENDA
        else if (opcaoS.equals(op.get(2))){
            Venda vendaCadastro = new Venda();
            int opcaoI2, verifica = 0;
            System.out.println(" [3] - CADASTRO DE NOVA VENDA");
            do {
                System.out.println(" Digite o cpf do cliente no qual a venda sera atribuida:");
                System.out.println(" (cpf contem a seguinte estrutura: 123.456.789-1X, X = identificador unico)");
                opcaoS = ler.nextLine();
                for (int i = 0; i < dado.getCliente().size(); i++){
                    if (opcaoS.equals(dado.getCliente().get(i).getCpf())){
                        cliVenda = dado.getCliente().get(i);
                        verifica = 1;
                    }
                }

                if (verifica == 0)
                    System.out.println(" Nao eh possivel cadastrar uma venda para um cliente inexistente");


            }while (verifica == 0);
            do{
                //SETA QUAL PRODUTO SERA ATRIBUIDO A VENDA
                System.out.println(dado.getEstoque().toString());
                System.out.println(" Digite o ID do produto que deseja cadastrar na venda");
                opcaoI = ler.nextInt();
                ler.nextLine();
                while(opcaoI < dado.getMovel().get(0).getIdProduto()
                        || opcaoI > dado.getEletro().get(dado.getEletro().size()-1).getIdProduto()){
                    System.out.println(" Digite um ID valido de produto para cadastrar na venda");
                    opcaoI = ler.nextInt();
                    ler.nextLine();
                }
                //SETA A QUANTIDADE ATRIBUIDA A VENDA
                System.out.println(" Digite a quantidade do produto que deseja cadastrar na venda");
                opcaoI2 = ler.nextInt();
                ler.nextLine();
                while(opcaoI2 < 0 || opcaoI2 > dado.getEletro().get(opcaoI /2).getQuantidade()
                      || dado.getEletro().get(opcaoI /2).getQuantidade() == 0) {

                    System.out.println(" Digite uma quantidade valida para cadastrar na venda");
                    opcaoI2 = ler.nextInt();
                    ler.nextLine();
                }
                dado.getLoja().getEstoque().setQuantEstoque(opcaoI2);
                for(int i=0; i < dado.getMovel().size(); i++){
                    if(opcaoI == dado.getMovel().get(i).getIdProduto()){    //COMPARA O ID INSERIDO COM OS IDS DOS PRODUTOS DOS MOVEIS
                        vendaCadastro.adicionar(dado.getMovel().get(i), opcaoI2);
                    }
                }
                for(int i=0; i < dado.getEletro().size(); i++){
                    if(opcaoI == dado.getEletro().get(i).getIdProduto()){   //COMPARA O ID INSERIDO COM OS IDS DOS PRODUTOS DOS ELETRODOMESTICOS
                        vendaCadastro.adicionar(dado.getEletro().get(i), opcaoI2);
                    }
                }

                System.out.println(" Deseja cadastrar outro produto?");
                System.out.println(" Digite: SIM ou NAO");
                opcaoS = ler.nextLine();

                while (!opcaoS.equalsIgnoreCase("nao") && !opcaoS.equalsIgnoreCase("sim")) {
                    System.out.println(" OPCAO INVALIDA!");
                    System.out.println(" Deseja cadastrar outro produto?");
                    System.out.println(" Digite: SIM ou NAO");
                    opcaoS = ler.nextLine();
                }

            } while (!opcaoS.equalsIgnoreCase("nao"));

            System.out.println(" A venda sera paga em boleto?");
            opcaoS = ler.nextLine();
            if(opcaoS.equals("SIM"))
                opcaoS = "BOLETO";
            else
                opcaoS = "CARTAO";
            vendaCadastro.setCliente(cliVenda);
            vendaCadastro.setLoja(dado.getLoja());
            vendaCadastro.setFormaDePagamento(opcaoS);
            vendaCadastro.setValorFinal();
            vendaCadastro.setCodigoDeVenda();
            vendaCadastro.setFrete();
            dado.getVendas().add(vendaCadastro);
        }
    }
}

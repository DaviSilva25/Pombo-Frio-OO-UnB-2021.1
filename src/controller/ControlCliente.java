package controller;
import models.*;
import java.util.*;


public class ControlCliente {

    public static String listarClientes(ControlRegisto dado){
        List<Cliente> ListCLiente = new ArrayList<>();
        String a = "";
        for(int i=0; i<dado.getDados().getCliente().size(); i++)
            a += "\n"+dado.getDados().getCliente().get(i).imprimirCliente();
        return a;
    }

}




/*
//02 METODOS DO CLIENTE
    public static void CLIENTE(Registro dado){
        //VARIAVEIS DE ESCOLHAS E ARMAZENAMENTO
        int auxCli = 0;
        String opcaoS;
        Cliente cpfCliente = new Cliente();
        List<Cliente> clienteAux = new ArrayList<>();
        List<String> op = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));



        //ALTERAR/DELETAR/BUSCAR UM CLIENTE
        else if(opcaoS.equals(op.get(1))){
            System.out.println(" Digite 1 para filtrar por nome(apenas consultar)");
            System.out.println(" Digite 2 para filtrar por cpf(alterar/deletar)");
            opcaoS = ler.nextLine();

            //VALIDA  A OPCAO ACIMA
            while (!op.subList(0, 2).contains(opcaoS)) {
                System.out.println(" OPCAO INVALIDA!");

                opcaoS = ler.nextLine();
            }

            //opcaoS = 1 = FILTRAR POR NOME(APENAS BUSCAS)
            if (opcaoS.equals("1")) {
                do {
                    System.out.println(" Digite o nome do cliente a ser buscado");
                    opcaoS = ler.nextLine();

                    for (int i = 0; i < dado.getCliente().size(); i++)
                        if (opcaoS.equalsIgnoreCase(dado.getCliente().get(i).getNome()))    // COMPARA O NOME INSERIDO COM TODOS CONTIDOS NO SISTEMA
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
    } */
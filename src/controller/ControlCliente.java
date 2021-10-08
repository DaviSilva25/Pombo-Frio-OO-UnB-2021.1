package controller;
import models.Cartao;

import models.Cliente;
import models.Endereco;
import models.Telefone;
import java.util.*;
/**
 * Classe para controle das acoes relacionadas a cliente
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */

@SuppressWarnings("static-access")
public class ControlCliente {
	
    //DECLARACAO
    private static final List<String[]> dadosCliente = new ArrayList<>();
    private static final List<String> dadosViewCliente = new ArrayList<>();
    private static String cartao;
    private static ControlRegistro dadosR;
    static {
        dadosR = new ControlRegistro();
    }
    /**
     * Metodo construtor de ControlCliente
     */
    public ControlCliente(){
    }
    
    /**
     * Metodo que percorre o laco de repeticao de tamanho da lista de clientes cadastrados no sistema e
     * em cada repeticao adiciona dados de um cliente em uma lista de String para uso posterior em uma Jtable
     * na ViewCliente.
     * Dados adicionado em cada posicao:
     * (1) Adiciona o nome do cliente.  
     * (2) Adiciona o CPF do cliente.
     * (3) Adiciona o UF do endereco do cliente.
     * (4) Adiciona o Telefone do cliente.
     * (5) Adiciona se o cliente tem cartao ou nao.
     * @param clienteD uma instancia ControlRegistro que contem os dados do sistema
     * @return a lista de strings com o dados selecionados de todos os cliente cadastrados no sistema
     */
    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA
    public static List<String[]> dadosTabela(ControlRegistro clienteD){
        dadosCliente.clear();
        //laco que compara a string recebida com o nome ou cpf dos clientes existentes
        for(int i=0;i< clienteD.getDados().getCliente().size(); i++){
            if(clienteD.getDados().getCliente().get(i).getCartao().getNome().equals(""))
                cartao = "NAO";
            else
                cartao = "SIM";

            dadosCliente.add(new String[]{clienteD.getDados().getCliente().get(i).getNome(),
                                      clienteD.getDados().getCliente().get(i).getCpf(),
                                      clienteD.getDados().getCliente().get(i).getEndereco().getUf(),
                                      clienteD.getDados().getCliente().get(i).getTelefone().toString(),
                                      cartao});
        }
    return dadosCliente;
    }
    
    
    /**
     * Metodo que percorre o laco de repeticao de tamanho da lista de clientes cadastrados no sistema e
     * em cada repeticao se o cpf ou o nome do cliente da posicao atual for igual a string recebida por parametro
     * adiciona os dados do cliente em uma lista de String para uso posterior em uma Jtable na ViewCliente.
     * Dados adicionado em cada posicao:
     * (1) Adiciona o nome do cliente.  
     * (2) Adiciona o CPF do cliente.
     * (3) Adiciona o UF do endereco do cliente.
     * (4) Adiciona o Telefone do cliente.
     * (5) Adiciona se o cliente tem cartao ou nao.
     * @param clienteD uma instancia ControlRegistro que contem os dados do sistema
     * @param dado String usada para verificar quais clientes serao adicionados na lista
     * @return a lista de strings com os dados dos clientes selecionados cadastrados no sistema
     */
    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA APOS O FILTRO
    public static List<String[]> filtrarTabela(ControlRegistro clienteD, String dado){
        dadosCliente.clear();
        //laco que compara a string recebida com o nome ou cpf dos clientes existentes
        for(int i=0;i< clienteD.getDados().getCliente().size(); i++){
            if((clienteD.getDados().getCliente().get(i).getNome().contains(dado) && !dado.equals(" "))
                    || dado.equals(clienteD.getDados().getCliente().get(i).getCpf())){
                if(clienteD.getDados().getCliente().get(i).getCartao().getNome().equals(""))
                    cartao = "NAO";
                else
                    cartao = "SIM";

                dadosCliente.add(new String[]{clienteD.getDados().getCliente().get(i).getNome(),
                        clienteD.getDados().getCliente().get(i).getCpf(),
                        clienteD.getDados().getCliente().get(i).getEndereco().getUf(),
                        clienteD.getDados().getCliente().get(i).getTelefone().toString(),
                        cartao});
            }
        }
        return dadosCliente;

    }
    
    /**
     * Metodo que recebe uma lista de String e a partir dela e cadastrado um novo cliente no sistema.
     * 
     * @param dadosCliente lista de String com dados para cadastro de cliente
     */
    //METODO PARA ADCIONAR CLIENTE
    public static void adicionarCliente(List<String> dadosCliente){

        Cliente novoCliente = new Cliente();
        Telefone novoTelefone = new Telefone();
        Endereco novoEndereco = new Endereco();
        Cartao novoCartao = new Cartao();
        
        novoCliente.setNome(dadosCliente.get(0));
        novoCliente.setCpf(dadosCliente.get(1));
        novoCliente.setDataNascimento(dadosCliente.get(2));

        novoCliente.setTelefone(novoTelefone);
        novoTelefone.setDdd(dadosCliente.get(3));
        novoTelefone.setNumero(dadosCliente.get(4));

        novoCliente.setEndereco(novoEndereco);
        novoEndereco.setUf(dadosCliente.get(5));
        novoEndereco.setCidade(dadosCliente.get(6));
        novoEndereco.setBairro(dadosCliente.get(7));
        novoEndereco.setLogradouro(dadosCliente.get(8));

        novoCliente.setCartao(novoCartao);
        novoCartao.setNome(dadosCliente.get(9));
        novoCartao.setNumero(dadosCliente.get(10));
        novoCartao.setDataVencimento(dadosCliente.get(11));
        novoCartao.setCvv(dadosCliente.get(12));

        ControlRegistro.getDados().getTelefone().add(novoTelefone);
        ControlRegistro.getDados().getEndereco().add(novoEndereco);
        ControlRegistro.getDados().getCartao().add(novoCartao);
        ControlRegistro.getDados().getCliente().add(novoCliente);
    }
    
    /**
     * Metodo que recebe o cpf e a partir disso encontra o cliente que o detem no sistema,
     * apos isso salva todos os dados do mesmo em uma lista de strings para uso posterior na ViewDetalheCliente.
     * 
     * @param clienteD uma instancia ControlRegistro que contem os dados do sistema.
     * @param cpf uma String que serve para encontrar o cliente desejado no laco de repeticao.
     * @return a lista de strings com os dados selecionados de um cliente cadastrado no sistema.
     */
    //METODO PARA ADQUIRIR OS DADOS PARA A TELA DETALHE DE UM CLIENTE
    public static List<String> pegarDadosCliente(ControlRegistro clienteD,String cpf){
        int i = 0;
        dadosViewCliente.clear();
        //laco que compara a string recebida com o cpf dos clientes existentes
        for(int index=0;index< clienteD.getDados().getCliente().size(); index++)
            if(clienteD.getDados().getCliente().get(index).getCpf().equals(cpf))
                i = index;

            dadosViewCliente.add(clienteD.getDados().getCliente().get(i).getNome());
            dadosViewCliente.add(clienteD.getDados().getCliente().get(i).getCpf());
            dadosViewCliente.add(clienteD.getDados().getCliente().get(i).getDataNascimento());
            dadosViewCliente.add(clienteD.getDados().getCliente().get(i).getTelefone().getDdd());
            dadosViewCliente.add(clienteD.getDados().getCliente().get(i).getTelefone().getNumero());
            dadosViewCliente.add(clienteD.getDados().getCliente().get(i).getEndereco().getUf());
            dadosViewCliente.add(clienteD.getDados().getCliente().get(i).getEndereco().getCidade());
            dadosViewCliente.add(clienteD.getDados().getCliente().get(i).getEndereco().getBairro());
            dadosViewCliente.add(clienteD.getDados().getCliente().get(i).getEndereco().getLogradouro());
            dadosViewCliente.add(clienteD.getDados().getCliente().get(i).getCartao().getNome());
            dadosViewCliente.add(clienteD.getDados().getCliente().get(i).getCartao().getNumero());
            dadosViewCliente.add(clienteD.getDados().getCliente().get(i).getCartao().getDataVencimento());
            dadosViewCliente.add(clienteD.getDados().getCliente().get(i).getCartao().getCvv());


        return dadosViewCliente;
    }
    
    /**
     * Metodo que recebe o cpf e a partir dele encontra o cliente que o detem no sistema,
     * apos isso altera os dados do mesmo a partir de uma lista de Strings recebida por parametro. 
     * 
     * @param clienteD uma instancia ControlRegistro que contem os dados do sistema.
     * @param cpf uma String que serve para encontrar o cliente desejado no laco de repeticao.
     * @param dadosCliente lista de String que contem os novos dados do cliente.
     */
    //METODO PARA ALTERAR OS DADOS DA TELA DE UM CLIENTE
    public static void alterarDadosCliente(ControlRegistro clienteD,String cpf, List<String> dadosCliente){
        List<String> alteraDados = new ArrayList<>(dadosCliente);

        int i = 0;
        for(int index=0;index< clienteD.getDados().getCliente().size(); index++)
            if(clienteD.getDados().getCliente().get(index).getCpf().equals(cpf))
                i = index;

        clienteD.getDados().getCliente().get(i).setNome(alteraDados.get(0));
        clienteD.getDados().getCliente().get(i).setCpf(alteraDados.get(1));
        clienteD.getDados().getCliente().get(i).setDataNascimento(alteraDados.get(2));
        clienteD.getDados().getCliente().get(i).getTelefone().setDdd(alteraDados.get(3));
        clienteD.getDados().getCliente().get(i).getTelefone().setNumero(alteraDados.get(4));
        clienteD.getDados().getCliente().get(i).getEndereco().setUf(alteraDados.get(5));
        clienteD.getDados().getCliente().get(i).getEndereco().setCidade(alteraDados.get(6));
        clienteD.getDados().getCliente().get(i).getEndereco().setBairro(alteraDados.get(7));
        clienteD.getDados().getCliente().get(i).getEndereco().setLogradouro(alteraDados.get(8));
        clienteD.getDados().getCliente().get(i).getCartao().setNome(alteraDados.get(9));
        clienteD.getDados().getCliente().get(i).getCartao().setNumero(alteraDados.get(10));
        clienteD.getDados().getCliente().get(i).getCartao().setDataVencimento(alteraDados.get(11));
        clienteD.getDados().getCliente().get(i).getCartao().setCvv(alteraDados.get(12));
    }
    
    /**
     * Metodo que recebe o cpf e a partir dele encontra o cliente que o detem no sistema,
     * apos isso deleta os dados do cliente do sistema.
     * 
     * @param clienteD uma instancia ControlRegistro que contem os dados do sistema.
     * @param cpf uma String que serve para encontrar o cliente desejado no laco de repeticao.
     */
    //METODO PARA EXCLUIR OS DADOS DA TELA DE UM CLIENTE
    public static void excluirCliente(ControlRegistro clienteD,String cpf){
        int i = 0;
        for(int index=0;index< clienteD.getDados().getCliente().size(); index++)
            if(clienteD.getDados().getCliente().get(index).getCpf().equals(cpf))
                i = index;
        clienteD.getDados().getCliente().remove(i);
    }

    //GET
    public static ControlRegistro getDadosR() {
        return dadosR;
    }

}



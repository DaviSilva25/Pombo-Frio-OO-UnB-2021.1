package controller;
import models.Cartao;
import models.Cliente;
import models.Endereco;
import models.Telefone;
import java.util.*;

public class ControlCliente {
    //DECLARACAO
    private static final List<String[]> dadosCliente = new ArrayList<>();
    private static final List<String> dadosViewCliente = new ArrayList<>();
    private static String cartao;
    private static ControlRegisto dadosR;
    static {
        try {
            dadosR = new ControlRegisto();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public ControlCliente(){
    }

    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA
    public static List<String[]> dadosTabela(ControlRegisto clienteD){
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

    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA APOS O FILTRO
    public static List<String[]> filtrarTabela(ControlRegisto clienteD, String dado){
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

        ControlRegisto.getDados().getTelefone().add(novoTelefone);
        ControlRegisto.getDados().getEndereco().add(novoEndereco);
        ControlRegisto.getDados().getCartao().add(novoCartao);
        ControlRegisto.getDados().getCliente().add(novoCliente);
    }

    //METODO PARA ADQUIRIR OS DADOS PARA A TELA DE UM CLIENTE
    public static List<String> pegarDadosCliente(ControlRegisto clienteD,String cpf){
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

    //METODO PARA ALTERAR OS DADOS DA TELA DE UM CLIENTE
    public static void alterarDadosCliente(ControlRegisto clienteD,String cpf, List<String> dadosCliente){
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

    //METODO PARA EXCLUIR OS DADOS DA TELA DE UM CLIENTE
    public static void excluirCliente(ControlRegisto clienteD,String cpf){
        int i = 0;
        for(int index=0;index< clienteD.getDados().getCliente().size(); index++)
            if(clienteD.getDados().getCliente().get(index).getCpf().equals(cpf))
                i = index;
        clienteD.getDados().getCliente().remove(i);
    }

    //GET
    public static ControlRegisto getDadosR() {
        return dadosR;
    }

}



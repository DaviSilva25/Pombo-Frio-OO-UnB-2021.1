package controller;

import java.util.ArrayList;
import java.util.List;

public class ControlLoja {

    private static final List<String> dadosLoja = new ArrayList<>();

    public ControlLoja() {
    }

    //METODO PARA ADQUIRIR O DADOS PARA A TELA DE UM CLIENTE
    public static List<String> pegarDadosLoja() {
        dadosLoja.add(ControlCliente.getDadosR().getDados().getLoja().getNome());
        dadosLoja.add(ControlCliente.getDadosR().getDados().getLoja().getCnpj());
        dadosLoja.add(ControlCliente.getDadosR().getDados().getLoja().getTelefone().getDdd());
        dadosLoja.add(ControlCliente.getDadosR().getDados().getLoja().getTelefone().getNumero());
        dadosLoja.add(ControlCliente.getDadosR().getDados().getLoja().getEndereco().getUf());
        dadosLoja.add(ControlCliente.getDadosR().getDados().getLoja().getEndereco().getCidade());
        dadosLoja.add(ControlCliente.getDadosR().getDados().getLoja().getEndereco().getBairro());
        dadosLoja.add(ControlCliente.getDadosR().getDados().getLoja().getEndereco().getLogradouro());

        return dadosLoja;
    }

    //METODO PARA ALTERAR O DADOS DA TELA DA LOJA
    public static void alterarDadosLoja(List<String> dadosCliente){
        List<String> alteraDados = new ArrayList<>(dadosCliente);

        ControlCliente.getDadosR().getDados().getLoja().setNome(alteraDados.get(0));
        ControlCliente.getDadosR().getDados().getLoja().setCnpj(alteraDados.get(1));
        ControlCliente.getDadosR().getDados().getLoja().getTelefone().setDdd(alteraDados.get(2));
        ControlCliente.getDadosR().getDados().getLoja().getTelefone().setNumero(alteraDados.get(3));
        ControlCliente.getDadosR().getDados().getLoja().getEndereco().setUf(alteraDados.get(4));
        ControlCliente.getDadosR().getDados().getLoja().getEndereco().setCidade(alteraDados.get(5));
        ControlCliente.getDadosR().getDados().getLoja().getEndereco().setBairro(alteraDados.get(6));
        ControlCliente.getDadosR().getDados().getLoja().getEndereco().setLogradouro(alteraDados.get(7));

    }
}

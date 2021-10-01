package controller;

import models.Endereco;
import models.Telefone;

import java.util.ArrayList;
import java.util.List;

public class ControlLoja {

    private static List<String> dadosLoja = new ArrayList<>();

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
        Telefone telefone = new Telefone();
        Endereco endereco = new Endereco();

        ControlCliente.getDadosR().getDados().getLoja().setNome(alteraDados.get(0));
        ControlCliente.getDadosR().getDados().getLoja().setCnpj(alteraDados.get(1));
        telefone.setDdd(alteraDados.get(2));
        telefone.setNumero(alteraDados.get(3));
        ControlCliente.getDadosR().getDados().getLoja().setTelefone(telefone);
        endereco.setUf(alteraDados.get(4));
        endereco.setCidade(alteraDados.get(5));
        endereco.setBairro(alteraDados.get(6));
        endereco.setLogradouro(alteraDados.get(7));
        ControlCliente.getDadosR().getDados().getLoja().setEndereco(endereco);
    }
}

package controller;

import models.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControlVenda {
    private static List<String[]> dadosVenda = new ArrayList<>();
    private static List<String> dadosViewVenda = new ArrayList<>();
    private static List<Movel> vendaM = new ArrayList<>();
    private static List<Eletrodomestico> vendaE = new ArrayList<>();
    private static Venda novaVenda;

    public ControlVenda(){
    }

    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA
    public static List<String[]> dadosTabela(){
        dadosVenda.clear();
        for(int i=0;i< ControlCliente.getDadosR().getDados().getVendas().size(); i++){

            dadosVenda.add(new String[]{ControlCliente.getDadosR().getDados().getVendas().get(i).getCodigoDeVenda(),
                    ControlCliente.getDadosR().getDados().getVendas().get(i).getCliente().getNome(),
                    ControlCliente.getDadosR().getDados().getVendas().get(i).getCliente().getCpf(),
                    ControlCliente.getDadosR().getDados().getVendas().get(i).getLoja().getNome(),
                    String.valueOf(ControlCliente.getDadosR().getDados().getVendas().get(i).getDataVenda()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getVendas().get(i).getValorFinal())
                    });
        }
        return dadosVenda;
    }

    //METODO ADICIONAR
    public static void novaVenda(String cpf, List<String> quant, List<String> id) throws CloneNotSupportedException {
        int i = 0;
        int contE = 0;
        int contM = 0;
        vendaM.clear();
        vendaE.clear();

        for(int index=0;index< ControlCliente.getDadosR().getDados().getCliente().size(); index++)
            if(ControlCliente.getDadosR().getDados().getCliente().get(index).getCpf().equals(cpf))
                i = index;

        novaVenda = new Venda(ControlCliente.getDadosR().getDados().getCliente().get(i),
                ControlCliente.getDadosR().getDados().getLoja(),
                "CARTAO");

        for(int index=0;index< ControlCliente.getDadosR().getDados().getMovel().size(); index++){
            for(int j=0; j< id.size(); j++){
                if(String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(index).getIdProduto()).equals(id.get(j))){
                    vendaM.add(ControlCliente.getDadosR().getDados().getMovel().get(index));
                    novaVenda.adicionar(vendaM.get(contM),Integer.valueOf(quant.get(j)));
                    contM++;
                }
            }
        }

        for(int index=0;index< ControlCliente.getDadosR().getDados().getEletro().size(); index++){
            for(int j=0; j< id.size(); j++){
                if(String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(index).getIdProduto()).equals(id.get(j))){
                    vendaE.add(ControlCliente.getDadosR().getDados().getEletro().get(index));
                    novaVenda.adicionar(vendaE.get(contE),Integer.valueOf(quant.get(j)));
                    contE++;
                }
            }
        }
        novaVenda.setValorFinal();
        novaVenda.setCodigoDeVenda();
        ControlCliente.getDadosR().getDados().getVendas().add(novaVenda);

    }

    //METODO PARA ADQUIRIR O DADOS PARA A TELA DE UM CLIENTE
    public static List<String> pegarDadosVenda(String idVenda){
        int i = 0;
        dadosViewVenda.clear();
        for(int index=0;index< ControlCliente.getDadosR().getDados().getVendas().size(); index++)
            if(ControlCliente.getDadosR().getDados().getVendas().get(index).getCodigoDeVenda().equals(idVenda))
                i = index;

        dadosViewVenda.add(ControlCliente.getDadosR().getDados().getVendas().get(i).getCodigoDeVenda());
        dadosViewVenda.add(ControlCliente.getDadosR().getDados().getVendas().get(i).getCliente().getNome());
        dadosViewVenda.add(ControlCliente.getDadosR().getDados().getVendas().get(i).getCliente().getCpf());
        dadosViewVenda.add(ControlCliente.getDadosR().getDados().getVendas().get(i).getLoja().getNome());
        dadosViewVenda.add(ControlCliente.getDadosR().getDados().getVendas().get(i).getLoja().getCnpj());
        dadosViewVenda.add(String.valueOf(ControlCliente.getDadosR().getDados().getVendas().get(i).getDataVenda()));
        dadosViewVenda.add(String.valueOf(ControlCliente.getDadosR().getDados().getVendas().get(i).getValorFinal()));
        dadosViewVenda.add(String.valueOf(ControlCliente.getDadosR().getDados().getVendas().get(i).getFrete()));
        dadosViewVenda.add("CARTAO");

        return dadosViewVenda;
    }


}
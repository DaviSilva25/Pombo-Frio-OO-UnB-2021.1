package controller;

import com.sun.jdi.IntegerValue;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class ControlEstoque {
    private static List<String[]> dadosMovel = new ArrayList<>();
    private static List<String[]> dadosEletro = new ArrayList<>();
    private static List<String> dadosViewMovel = new ArrayList<>();
    private static List<String> dadosViewEletro = new ArrayList<>();

    public ControlEstoque(){
    }


    //METODOS DE MOVEL:

    //METODO PARA ADCIONAR MOVEL
    public static void adicionarMovel(List<String> dadosCliente){

        Movel novoMovel = new Movel();

        int indexF = ControlCliente.getDadosR().getDados().getMovel().size();
        novoMovel.setIdProduto(ControlCliente.getDadosR().getDados().getMovel().get(indexF-1).getIdProduto()+2);
        novoMovel.setNome(dadosCliente.get(1));
        novoMovel.setDescricao(dadosCliente.get(2));
        novoMovel.setCor(dadosCliente.get(3));
        novoMovel.setPreco(Double.valueOf(dadosCliente.get(4)));
        novoMovel.setTamanho(dadosCliente.get(5));
        novoMovel.setFabricante(dadosCliente.get(6));
        novoMovel.setQuantidade(Integer.valueOf(dadosCliente.get(7)));
        novoMovel.setAmbiente(dadosCliente.get(8));
        novoMovel.setMaterial(dadosCliente.get(9));

        ControlCliente.getDadosR().getDados().getMovel().add(novoMovel);
    }

    //METODO PARA ALTERAR O DADOS DA TELA DE ELETRODOMESTICO
    public static void alterarDadosMovel(String id, List<String> dadosCliente){
        List<String> alteraDados = new ArrayList<>(dadosCliente);
        int i = 0;
        for(int index=0;index< ControlCliente.getDadosR().getDados().getMovel().size(); index++)
            if(String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(index).getIdProduto()).equals(id))
                i = index;

        ControlCliente.getDadosR().getDados().getMovel().get(i).setIdProduto(Integer.valueOf(alteraDados.get(0)));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setNome(alteraDados.get(1));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setDescricao(alteraDados.get(2));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setCor(alteraDados.get(3));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setPreco(Double.valueOf(alteraDados.get(4)));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setTamanho(alteraDados.get(5));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setFabricante(alteraDados.get(6));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setQuantidade(Integer.valueOf(alteraDados.get(7)));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setAmbiente(alteraDados.get(8));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setMaterial(alteraDados.get(9));
    }

    //METODO PARA EXCLUIR UM ELETRODOMESTICO
    public static void excluirMovel(String id){
        int i = 0;
        for(int index=0;index< ControlCliente.getDadosR().getDados().getMovel().size(); index++)
            if(String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(index).getIdProduto()).equals(id))
                i = index;

        ControlCliente.getDadosR().getDados().getMovel().remove(i);
    }

    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA MOVEL
    public static List<String[]> tabelaMovel(){
        dadosMovel.clear();
        for(int i=0;i< ControlCliente.getDadosR().getDados().getMovel().size(); i++){
            dadosMovel.add(new String[]{String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getIdProduto()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getNome()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getPreco()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getQuantidade()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getAmbiente())});
        }
        return dadosMovel;
    }

    //METODO PARA ADQUIRIR O DADOS PARA A TELA DETALHE DE UM MOVEL
    public static List<String> pegarDadosMovel(String id){
        int i = 0;
        dadosViewMovel.clear();
        for(int index=0;index< ControlCliente.getDadosR().getDados().getMovel().size(); index++)
            if(String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(index).getIdProduto()).equals(id))
                i = index;

        dadosViewMovel.add(String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getIdProduto()));
        dadosViewMovel.add(ControlCliente.getDadosR().getDados().getMovel().get(i).getNome());
        dadosViewMovel.add(ControlCliente.getDadosR().getDados().getMovel().get(i).getDescricao());
        dadosViewMovel.add(ControlCliente.getDadosR().getDados().getMovel().get(i).getCor());
        dadosViewMovel.add(String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getPreco()));
        dadosViewMovel.add(ControlCliente.getDadosR().getDados().getMovel().get(i).getTamanho());
        dadosViewMovel.add(ControlCliente.getDadosR().getDados().getMovel().get(i).getFabricante());
        dadosViewMovel.add(String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getQuantidade()));
        dadosViewMovel.add(ControlCliente.getDadosR().getDados().getMovel().get(i).getAmbiente());
        dadosViewMovel.add(ControlCliente.getDadosR().getDados().getMovel().get(i).getMaterial());

        return dadosViewMovel;
    }


    //METODOS DE ELETRODOMESTICO:

    //METODO PARA ADCIONAR ELETRODOMESTICO
    public static void adicionarEletro(List<String> dadosCliente){

        Eletrodomestico novoEletro = new Eletrodomestico();

        int indexF = ControlCliente.getDadosR().getDados().getEletro().size();
        novoEletro.setIdProduto(ControlCliente.getDadosR().getDados().getEletro().get(indexF-1).getIdProduto()+2);
        novoEletro.setNome(dadosCliente.get(1));
        novoEletro.setDescricao(dadosCliente.get(2));
        novoEletro.setCor(dadosCliente.get(3));
        novoEletro.setPreco(Double.valueOf(dadosCliente.get(4)));
        novoEletro.setTamanho(dadosCliente.get(5));
        novoEletro.setFabricante(dadosCliente.get(6));
        novoEletro.setQuantidade(Integer.valueOf(dadosCliente.get(7)));
        novoEletro.setCapacidade(dadosCliente.get(8));
        novoEletro.setVoltagem(dadosCliente.get(9));
        novoEletro.setPotencia(dadosCliente.get(10));

        ControlCliente.getDadosR().getDados().getEletro().add(novoEletro);
    }

    //METODO PARA ALTERAR O DADOS DA TELA DE ELETRODOMESTICO
    public static void alterarDadosEletro(String id, List<String> dadosCliente){
        List<String> alteraDados = new ArrayList<>(dadosCliente);
        int i = 0;
        for(int index=0;index< ControlCliente.getDadosR().getDados().getEletro().size(); index++)
            if(String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(index).getIdProduto()).equals(id))
                i = index;

        ControlCliente.getDadosR().getDados().getEletro().get(i).setIdProduto(Integer.valueOf(alteraDados.get(0)));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setNome(alteraDados.get(1));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setDescricao(alteraDados.get(2));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setCor(alteraDados.get(3));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setPreco(Double.valueOf(alteraDados.get(4)));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setTamanho(alteraDados.get(5));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setFabricante(alteraDados.get(6));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setQuantidade(Integer.valueOf(alteraDados.get(7)));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setCapacidade(alteraDados.get(8));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setVoltagem(alteraDados.get(9));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setPotencia(alteraDados.get(10));
    }

    //METODO PARA EXCLUIR UM ELETRODOMESTICO
    public static void excluirEletro(String id){
        int i = 0;
        for(int index=0;index< ControlCliente.getDadosR().getDados().getEletro().size(); index++)
            if(String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(index).getIdProduto()).equals(id))
                i = index;

        ControlCliente.getDadosR().getDados().getEletro().remove(i);
    }

    //METODO PARA ADQUIRIR O DADOS PARA A TELA DETALHE DE UM ELETRODOMESTICO
    public static List<String> pegarDadosEletro(String id){
        int i = 0;
        dadosViewEletro.clear();
        for(int index=0;index< ControlCliente.getDadosR().getDados().getEletro().size(); index++)
            if(String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(index).getIdProduto()).equals(id))
                i = index;

        dadosViewEletro.add(String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getIdProduto()));
        dadosViewEletro.add(ControlCliente.getDadosR().getDados().getEletro().get(i).getNome());
        dadosViewEletro.add(ControlCliente.getDadosR().getDados().getEletro().get(i).getDescricao());
        dadosViewEletro.add(ControlCliente.getDadosR().getDados().getEletro().get(i).getCor());
        dadosViewEletro.add(String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getPreco()));
        dadosViewEletro.add(ControlCliente.getDadosR().getDados().getEletro().get(i).getTamanho());
        dadosViewEletro.add(ControlCliente.getDadosR().getDados().getEletro().get(i).getFabricante());
        dadosViewEletro.add(String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getQuantidade()));
        dadosViewEletro.add(ControlCliente.getDadosR().getDados().getEletro().get(i).getCapacidade());
        dadosViewEletro.add(ControlCliente.getDadosR().getDados().getEletro().get(i).getVoltagem());
        dadosViewEletro.add(ControlCliente.getDadosR().getDados().getEletro().get(i).getPotencia());

        return dadosViewEletro;
    }

    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA ELETRODOMESTICO
    public static List<String[]> tabelaEletro(){
        dadosEletro.clear();
        for(int i=0;i< ControlCliente.getDadosR().getDados().getEletro().size(); i++){
            dadosEletro.add(new String[]{String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getIdProduto()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getNome()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getPreco()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getQuantidade()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getVoltagem())});
        }
        return dadosEletro;
    }

}

package controller;
import models.*;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe para controle das acoes relacionadas a estoque
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */

@SuppressWarnings("static-access")
public class ControlEstoque {
	
    //DECLARACAO
    private static final List<String[]> dadosMovel = new ArrayList<>();
    private static final List<String[]> dadosEletro = new ArrayList<>();
    private static final List<String> dadosViewMovel = new ArrayList<>();
    private static final List<String> dadosViewEletro = new ArrayList<>();
    /**
     * Construdor de ControlEstoque
     */
    public ControlEstoque(){
    }


    //METODOS DE MOVEL:
    /**
     * Metodo que recebe uma lista de String e a partir dela e cadastrado um novo movel no sistema.
     * 
     * @param dadosMovel lista de String com dados para cadastro de Movel.
     */
    //METODO PARA ADCIONAR MOVEL
    public static void adicionarMovel(List<String> dadosMovel){

        Movel novoMovel = new Movel();

        //pega o tamanho da lista de moveis existente no registro
        int indexF = ControlCliente.getDadosR().getDados().getMovel().size();

        novoMovel.setIdProduto(ControlCliente.getDadosR().getDados().getMovel().get(indexF-1).getIdProduto()+2);
        novoMovel.setNome(dadosMovel.get(1));
        novoMovel.setDescricao(dadosMovel.get(2));
        novoMovel.setCor(dadosMovel.get(3));
        novoMovel.setPreco(Double.parseDouble(dadosMovel.get(4)));
        novoMovel.setTamanho(dadosMovel.get(5));
        novoMovel.setFabricante(dadosMovel.get(6));
        novoMovel.setQuantidade(Integer.parseInt(dadosMovel.get(7)));
        novoMovel.setAmbiente(dadosMovel.get(8));
        novoMovel.setMaterial(dadosMovel.get(9));

        ControlCliente.getDadosR().getDados().getMovel().add(novoMovel);
    }
    
    /**
     * Metodo que recebe o id e a partir dele encontra o movel que o detem no sistema,
     * apos isso altera os dados do mesmo a partir de uma lista de Strings recebida por parametro. 
     * 
     * @param id uma String que serve para encontrar o movel desejado no laco de repeticao.
     * @param dadosMovel lista de String que contem os novos dados do movel.
     */
    //METODO PARA ALTERAR O DADOS DA TELA DE MOVEL
    public static void alterarDadosMovel(String id, List<String> dadosMovel){
        List<String> alteraDados = new ArrayList<>(dadosMovel);
        int i = 0;
        //laco que compara o id recebido com os ids dos moveis existentes no registro
        for(int index=0;index< ControlCliente.getDadosR().getDados().getMovel().size(); index++)
            if(String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(index).getIdProduto()).equals(id))
                i = index;

        ControlCliente.getDadosR().getDados().getMovel().get(i).setIdProduto(Integer.parseInt(alteraDados.get(0)));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setNome(alteraDados.get(1));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setDescricao(alteraDados.get(2));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setCor(alteraDados.get(3));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setPreco(Double.parseDouble(alteraDados.get(4)));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setTamanho(alteraDados.get(5));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setFabricante(alteraDados.get(6));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setQuantidade(Integer.parseInt(alteraDados.get(7)));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setAmbiente(alteraDados.get(8));
        ControlCliente.getDadosR().getDados().getMovel().get(i).setMaterial(alteraDados.get(9));
    }
    
    /**
     * Metodo que recebe o id e a partir dele encontra o movel que o detem no sistema,
     * apos isso deleta os dados do mesmo do sistema. 
     * 
     * @param id uma String que serve para encontrar o movel desejado no laco de repeticao.
     */
    //METODO PARA EXCLUIR UM MOVEL
    public static void excluirMovel(String id){
        int i = 0;
        //laco que compara o id recebido com os ids dos moveis existentes no registro
        for(int index=0;index< ControlCliente.getDadosR().getDados().getMovel().size(); index++)
            if(String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(index).getIdProduto()).equals(id))
                i = index;

        ControlCliente.getDadosR().getDados().getMovel().remove(i);
    }
    
    /** 
     * Metodo que recebe o id e a partir disso encontra o movel que o detem no sistema,
     * apos isso salva todos os dados do mesmo em uma lista de strings para uso posterior na ViewDetalheMovel.
     * 
     * @param id uma String que serve para encontrar o movel desejado no laco de repeticao.
     * @return a lista de strings com os dados selecionados de um movel cadastrado no sistema.
     */
    //METODO PARA ADQUIRIR O DADOS PARA A TELA DETALHE DE UM MOVEL
    public static List<String> pegarDadosMovel(String id){
        int i = 0;
        dadosViewMovel.clear();
        //laco que compara o id recebido com os ids dos moveis existentes no registro
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
    
    
    /**
     * Metodo que percorre o laco de repeticao de tamanho da lista de movel cadastrados no sistema e
     * em cada repeticao adiciona dados de um movel em uma lista de String para uso posterior em uma Jtable
     * na ViewEstoque.
     * Dados adicionado em cada posicao:
     * (1) Adiciona o id do movel.  
     * (2) Adiciona o nome do movel.
     * (3) Adiciona o preco do movel.
     * (4) Adiciona a quantidade do movel.
     * (5) Adiciona a cor do movel.
     * 
     * @return a lista de strings com o dados selecionados de todos os moveis cadastrados no sistema.
     */
    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA MOVEL
    public static List<String[]> tabelaMovel(){
        dadosMovel.clear();
        //laco que compara o id recebido com os ids dos moveis existentes no registro
        for(int i=0;i< ControlCliente.getDadosR().getDados().getMovel().size(); i++){
            dadosMovel.add(new String[]{String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getIdProduto()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getNome()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getPreco()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getQuantidade()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getCor())});
        }
        return dadosMovel;
    }
    
    /**
     * Metodo que percorre o laco de repeticao de tamanho da lista de movel cadastrados no sistema e
     * em cada repeticao se o nome ou preco do for igual a String recebida por parametro adiciona os
     * dados de um movel em uma lista de String para uso posterior em uma Jtable na ViewEstoque.
     * Dados adicionado em cada posicao:
     * (1) Adiciona o id do movel.  
     * (2) Adiciona o nome do movel.
     * (3) Adiciona o preco do movel.
     * (4) Adiciona a quantidade do movel.
     * (5) Adiciona a cor do movel.
     * 
     * @param dado String usada para verificar quais moveis serao adicionados na lista.
     * @return a lista de strings com o dados dos moveis selecionados cadastrados no sistema.
     */
    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA APOS O FILTRO
    public static List<String[]> filtrarTabelaMovel(String dado){
        dadosMovel.clear();
        //laco que compara o nome recebido com os nomes dos moveis existentes no registro
        for(int i=0;i< ControlCliente.getDadosR().getDados().getMovel().size(); i++){

            if(dado.contains(ControlCliente.getDadosR().getDados().getMovel().get(i).getNome())){
                dadosMovel.add(new String[]{String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getIdProduto()),
                        String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getNome()),
                        String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getPreco()),
                        String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getQuantidade()),
                        String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getCor())});
            }
        }
        //laco que compara o preco recebido com os precos dos moveis existentes no registro
        for(int i=0;i< ControlCliente.getDadosR().getDados().getEletro().size(); i++){
            try{
                if(ControlCliente.getDadosR().getDados().getMovel().get(i).getPreco() < Double.parseDouble(dado)){
                    dadosMovel.add(new String[]{String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getIdProduto()),
                            String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getNome()),
                            String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getPreco()),
                            String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getQuantidade()),
                            String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getAmbiente())});
                }
            }catch (Exception ex){
                break;
            }
        }
        return dadosMovel;

    }


    //METODOS DE ELETRODOMESTICO:
    /**
     * Metodo que recebe uma lista de String e a partir dela e cadastrado um novo eletrodomestico no sistema.
     * 
     * @param dadosEletro lista de String com dados para cadastro de Eletrodomestico.
     */
    //METODO PARA ADCIONAR ELETRODOMESTICO
    public static void adicionarEletro(List<String> dadosEletro){

        Eletrodomestico novoEletro = new Eletrodomestico();

        //pega o tamanho da lista de eletrodomesticos existente no sistema
        int indexF = ControlCliente.getDadosR().getDados().getEletro().size();

        novoEletro.setIdProduto(ControlCliente.getDadosR().getDados().getEletro().get(indexF-1).getIdProduto()+2);
        novoEletro.setNome(dadosEletro.get(1));
        novoEletro.setDescricao(dadosEletro.get(2));
        novoEletro.setCor(dadosEletro.get(3));
        novoEletro.setPreco(Double.parseDouble(dadosEletro.get(4)));
        novoEletro.setTamanho(dadosEletro.get(5));
        novoEletro.setFabricante(dadosEletro.get(6));
        novoEletro.setQuantidade(Integer.parseInt(dadosEletro.get(7)));
        novoEletro.setCapacidade(dadosEletro.get(8));
        novoEletro.setVoltagem(dadosEletro.get(9));
        novoEletro.setPotencia(dadosEletro.get(10));

        ControlCliente.getDadosR().getDados().getEletro().add(novoEletro);
    }
    
    /**
     * Metodo que recebe o id e a partir dele encontra o eletrodomestico que o detem no sistema,
     * apos isso altera os dados do mesmo a partir de uma lista de Strings recebida por parametro. 
     * 
     * @param id uma String que serve para encontrar o eletrodomestico desejado no laco de repeticao.
     * @param dadosEletro lista de String que contem os novos dados do eletrodomestico.
     */
    //METODO PARA ALTERAR O DADOS DA TELA DE ELETRODOMESTICO
    public static void alterarDadosEletro(String id, List<String> dadosEletro){
        List<String> alteraDados = new ArrayList<>(dadosEletro);
        int i = 0;
        //laco que compara o id recebido com os ids dos eletrodomesticos existentes no registro
        for(int index=0;index< ControlCliente.getDadosR().getDados().getEletro().size(); index++)
            if(String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(index).getIdProduto()).equals(id))
                i = index;

        ControlCliente.getDadosR().getDados().getEletro().get(i).setIdProduto(Integer.parseInt(alteraDados.get(0)));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setNome(alteraDados.get(1));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setDescricao(alteraDados.get(2));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setCor(alteraDados.get(3));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setPreco(Double.parseDouble(alteraDados.get(4)));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setTamanho(alteraDados.get(5));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setFabricante(alteraDados.get(6));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setQuantidade(Integer.parseInt(alteraDados.get(7)));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setCapacidade(alteraDados.get(8));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setVoltagem(alteraDados.get(9));
        ControlCliente.getDadosR().getDados().getEletro().get(i).setPotencia(alteraDados.get(10));
    }
    
    /**
     * Metodo que recebe o id e a partir dele encontra o eletrodomestico que o detem no sistema,
     * apos isso deleta os dados do mesmo do sistema. 
     * 
     * @param id uma String que serve para encontrar o eletrodomestico desejado no laco de repeticao.
     */
    //METODO PARA EXCLUIR UM ELETRODOMESTICO
    public static void excluirEletro(String id){
        int i = 0;
        //laco que compara o id recebido com os ids dos eletrodomesticos existentes no registro
        for(int index=0;index< ControlCliente.getDadosR().getDados().getEletro().size(); index++)
            if(String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(index).getIdProduto()).equals(id))
                i = index;

        ControlCliente.getDadosR().getDados().getEletro().remove(i);
    }
    
    /** 
     * Metodo que recebe o id e a partir disso encontra o eletrodomestico que o detem no sistema,
     * apos isso salva todos os dados do mesmo em uma lista de strings para uso posterior na ViewDetalheEletro.
     * 
     * @param id uma String que serve para encontrar o eletrodomestico desejado no laco de repeticao.
     * @return a lista de strings com os dados selecionados de um eletrodomestico cadastrado no sistema.
     */
    //METODO PARA ADQUIRIR O DADOS PARA A TELA DETALHE DE UM ELETRODOMESTICO
    public static List<String> pegarDadosEletro(String id){
        int i = 0;
        dadosViewEletro.clear();

        //laco que compara o id recebido com os ids dos eletrodomesticos existentes no registro
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
    
    /**
     * Metodo que percorre o laco de repeticao de tamanho da lista de eletrodomesticos cadastrados no sistema e
     * em cada repeticao adiciona dados de um eletrodomestico em uma lista de String para uso posterior em uma Jtable
     * na ViewEstoque.
     * Dados adicionado em cada posicao:
     * (1) Adiciona o id do eletrodomesticos.  
     * (2) Adiciona o nome do eletrodomesticos.
     * (3) Adiciona o preco do eletrodomesticos.
     * (4) Adiciona a quantidade do eletrodomesticos.
     * (5) Adiciona a cor do eletrodomesticos.
     * 
     * @return a lista de strings com o dados selecionados de todos os eletrodomesticos cadastrados no sistema.
     */
    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA ELETRODOMESTICO
    public static List<String[]> tabelaEletro(){
        dadosEletro.clear();

        //laco que compara o id recebido com os ids dos eletrodomesticos existentes no registro
        for(int i=0;i< ControlCliente.getDadosR().getDados().getEletro().size(); i++){
            dadosEletro.add(new String[]{String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getIdProduto()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getNome()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getPreco()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getQuantidade()),
                    String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getCor())});
        }
        return dadosEletro;
    }
    
    /**
     * Metodo que percorre o laco de repeticao de tamanho da lista de eletrodomesticos cadastrados no sistema e
     * em cada repeticao se o nome ou preco do for igual a String recebida por parametro adiciona os
     * dados de um eletrodomesticos em uma lista de String para uso posterior em uma Jtable na ViewEstoque.
     * Dados adicionado em cada posicao:
     * (1) Adiciona o id do eletrodomesticos.  
     * (2) Adiciona o nome do eletrodomesticos.
     * (3) Adiciona o preco do eletrodomesticos.
     * (4) Adiciona a quantidade do eletrodomesticos.
     * (5) Adiciona a cor do eletrodomesticos.
     * 
     * @param dado String usada para verificar quais eletrodomesticos serao adicionados na lista.
     * @return a lista de strings com o dados dos eletrodomesticos selecionados cadastrados no sistema.
     */
    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA APOS O FILTRO
    public static List<String[]> filtrarTabelaEletro(String dado){
        dadosEletro.clear();
        //laco que compara o nome recebido com os nomes dos eletrodomesticos existentes no registro
        for(int i=0;i< ControlCliente.getDadosR().getDados().getEletro().size(); i++){

            if(dado.contains(ControlCliente.getDadosR().getDados().getEletro().get(i).getNome())){
                dadosEletro.add(new String[]{String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getIdProduto()),
                        String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getNome()),
                        String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getPreco()),
                        String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getQuantidade()),
                        String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getCor())});
            }
        }

        //laco que compara o preco recebido com os precos dos eletrodomesticos existentes no registro
        for(int i=0;i< ControlCliente.getDadosR().getDados().getEletro().size(); i++) {
            try {
                if (ControlCliente.getDadosR().getDados().getEletro().get(i).getPreco() < Double.parseDouble(dado)) {
                    dadosEletro.add(new String[]{String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getIdProduto()),
                            String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getNome()),
                            String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getPreco()),
                            String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getQuantidade()),
                            String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getVoltagem())});
                }
            } catch (Exception ex) {
                break;
            }
        }
        return dadosEletro;

    }

}

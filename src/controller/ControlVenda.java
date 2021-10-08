package controller;

import models.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para controle das acoes relacionadas ao dados da venda
 * 
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */

@SuppressWarnings("static-access")
public class ControlVenda {
    //DECLARACAO
    private static final List<String[]> dadosVenda = new ArrayList<>();
    private static final List<String[]> dadosVenda2 = new ArrayList<>();
    private static final List<String> dadosViewVenda = new ArrayList<>();
    private static final List<Movel> vendaM = new ArrayList<>();
    private static final List<Eletrodomestico> vendaE = new ArrayList<>();
    private static Venda novaVenda;
    /**
     * Construtor de ControlVenda
     */
    public ControlVenda(){
    }
    
    /**
     * Metodo que percorre o laco de repeticao de tamanho da lista de vendas cadastradas no sistema e
     * em cada repeticao adiciona dados de uma venda em uma lista de String para uso posterior em uma Jtable
     * na ViewVenda.
     * Dados adicionado em cada posicao:
     * (1) Adiciona o codigo de venda.  
     * (2) Adiciona o nome do cliente da venda.
     * (3) Adiciona o cpf do cliente da venda.
     * (4) Adiciona a data da venda.
     * (5) Adiciona o valor final da venda.
     * 
     * @return a lista de strings com o dados selecionados de todos as vendas cadastradas no sistema.
     */
    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA PRINCIPAL
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
    
    /**
     * Metodo que recebe um id de venda e apos isso percorre o laco de repeticao de tamanho da 
     * lista de vendas cadastradas no sistema e se achar a venda com o id igual ao recebido, adiciona
     * os moveis e eletrodomesticos que compoem a venda em uma lista para uso posterior numa Jtable 
     * na ViewDetalheVenda.
     * Dados adicionado em cada posicao:
     * (1) Adiciona o id do produto da venda.  
     * (2) Adiciona o nome do produto da venda.
     * (3) Adiciona o quantidade do produto vendida.
     * (4) Adiciona a preco do produto.
     * (5) Adiciona o tipo do produto.
     * 
     * @return a lista de strings com o dados selecionados de todos as vendas cadastradas no sistema.
     */
    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA SECUNDARIA
    public static List<String[]> dadosTabela2(String idVenda){
        int index = 0;
        dadosVenda2.clear();

        //laco que compara o id recebido com os ids de venda presentes no registro
        for(int i=0; i< ControlCliente.getDadosR().getDados().getVendas().size(); i++)
            if(ControlCliente.getDadosR().getDados().getVendas().get(i).getCodigoDeVenda().equals(idVenda)) {
                index = i;
            }

        for(int i=0;i< ControlCliente.getDadosR().getDados().getVendas().get(index).getMoveisVenda().size(); i++){
            dadosVenda2.add(new String[]{String.valueOf(ControlCliente.getDadosR().getDados()
                            .getVendas().get(index).getMoveisVenda().get(i).getIdProduto()),//PEGANDO ID DO PRODUTO
                            ControlCliente.getDadosR().getDados().getVendas().get(index).getMoveisVenda().get(i).getNome(),//PEGANDO NOME DO PRODUTO
                            String.valueOf(ControlCliente.getDadosR().getDados()
                            .getVendas().get(index).getMoveisVenda().get(i).getQuantidade()),//PEGANDO QUANTIDADE DO PRODUTO
                            String.valueOf(ControlCliente.getDadosR().getDados()
                            .getVendas().get(index).getMoveisVenda().get(i).getPreco()),//PEGANDO PRECO DO PRODUTO
                            "movel"
            });
        }

        for(int i=0;i< ControlCliente.getDadosR().getDados().getVendas().get(index).getEletrosVenda().size(); i++){
            dadosVenda2.add(new String[]{String.valueOf(ControlCliente.getDadosR().getDados()
                    .getVendas().get(index).getEletrosVenda().get(i).getIdProduto()),//PEGANDO ID DO PRODUTO
                    ControlCliente.getDadosR().getDados().getVendas().get(index).getEletrosVenda().get(i).getNome(),//PEGANDO NOME DO PRODUTO
                    String.valueOf(ControlCliente.getDadosR().getDados()
                            .getVendas().get(index).getEletrosVenda().get(i).getQuantidade()),//PEGANDO QUANTIDADE DO PRODUTO
                    String.valueOf(ControlCliente.getDadosR().getDados()
                            .getVendas().get(index).getEletrosVenda().get(i).getPreco()),//PEGANDO PRECO DO PRODUTO
                    "eletrodomestico"
            });
        }

        return dadosVenda2;
    }
    
    /**
     * Metodo que percorre o laco de repeticao de tamanho da lista de vendas cadastradas no sistema e
     * em cada repeticao se o cpf,nome do cliente ou codigo de venda da posicao atual for igual a string recebida por parametro
     * adiciona os dados da venda em uma lista de String para uso posterior em uma Jtable na ViewVenda.
     * Dados adicionado em cada posicao:
     * Dados adicionado em cada posicao:
     * (1) Adiciona o codigo de venda.  
     * (2) Adiciona o nome do cliente da venda.
     * (3) Adiciona o cpf do cliente da venda.
     * (4) Adiciona a data da venda.
     * (5) Adiciona o valor final da venda.
     * 
     * @param dado String usada para verificar quais vendas serao adicionados na lista
     * @return a lista de strings com os dados da venda selecionada e cadastrada no sistema
     */
    //METODO QUE DEFINE OS ELEMENTOS QUE IRAO APARECER NA TABELA APOS O FILTRO
    public static List<String[]> filtrarTabelaVenda(String dado){
        dadosVenda.clear();

        //laco que compara a string recebida com o nome ou cpf do cliente da venda ou
        // compara com o codigo de venda presente no registro
        for(int i=0;i< ControlCliente.getDadosR().getDados().getVendas().size(); i++){

            if((ControlCliente.getDadosR().getDados().getVendas().get(i).getCliente().getNome().contains(dado))
            || dado.equals(ControlCliente.getDadosR().getDados().getVendas().get(i).getCodigoDeVenda())
            || ControlCliente.getDadosR().getDados().getVendas().get(i).getCliente().getCpf().equals(dado)){

                dadosVenda.add(new String[]{ControlCliente.getDadosR().getDados().getVendas().get(i).getCodigoDeVenda(),
                        ControlCliente.getDadosR().getDados().getVendas().get(i).getCliente().getNome(),
                        ControlCliente.getDadosR().getDados().getVendas().get(i).getCliente().getCpf(),
                        ControlCliente.getDadosR().getDados().getVendas().get(i).getLoja().getNome(),
                        String.valueOf(ControlCliente.getDadosR().getDados().getVendas().get(i).getDataVenda()),
                        String.valueOf(ControlCliente.getDadosR().getDados().getVendas().get(i).getValorFinal())
                });
            }

        }
        return dadosVenda;
    }
    
    /**
     * Metodo que recebe uma String cpf e apos isso procura no laco de repeticao o cliente com o cpf
     * igual a String recebida, e com o construtor de Venda, cria uma nova venda.
     * 
     * @param cpf uma String que serve para encontrar o cliente desejado no laco de repeticao.
     */
    //METODO PARA CRIAR NOVA VENDA
    public static void novaVenda(String cpf){
        int i = 0;

        for(int index=0; index< ControlCliente.getDadosR().getDados().getCliente().size(); index++)
            if(ControlCliente.getDadosR().getDados().getCliente().get(index).getCpf().equals(cpf))
                i = index;

        novaVenda = new Venda(ControlCliente.getDadosR().getDados().getCliente().get(i),
                ControlCliente.getDadosR().getDados().getLoja(),
                "");
    }
    /**
     * Metodo que recebe duas String quant e id, e apos isso adiciona na lista de movel ou de
     * eletrodomestico, o produto que tem o id igual ao recebido e a quantidade do produto igual
     * a quantidade recebida como parametro, e por fim, acrescenta o produto na nova venda.
     * 
     * @param quant uma String que determina a quantidade do produto que ira compor a venda.
     * @param id uma String que determina qual sera o produto a compor a venda.
     * @throws CloneNotSupportedException
     */
    //METODO PARA ADICIONAR PRODUTOS NA VENDA
    public static void addVenda(String quant, String id) throws CloneNotSupportedException {
        int contE = 0;
        int contM = 0;
        vendaM.clear();
        vendaE.clear();

        for(int index=0;index< ControlCliente.getDadosR().getDados().getEletro().size(); index++){
            if(ControlCliente.getDadosR().getDados().getEletro().get(index).getIdProduto() == Integer.parseInt(id)){
                vendaE.add(ControlCliente.getDadosR().getDados().getEletro().get(index));
                novaVenda.adicionar(vendaE.get(contE), Integer.parseInt(quant));
                ControlCliente.getDadosR().getDados().getEstoque().setQuantEstoque(Integer.parseInt(quant));
                contE++;
            }
        }

        for(int index=0; index< ControlCliente.getDadosR().getDados().getMovel().size(); index++){
            if(ControlCliente.getDadosR().getDados().getMovel().get(index).getIdProduto() == Integer.parseInt(id)){
                vendaM.add(ControlCliente.getDadosR().getDados().getMovel().get(index));
                novaVenda.adicionar(vendaM.get(contM), Integer.parseInt(quant));
                ControlCliente.getDadosR().getDados().getEstoque().setQuantEstoque(Integer.parseInt(quant));
                contM++;
            }
        }
    }

    /**
     * Metodo que finaliza a nova venda.
     */
    //METODO PARA FINALIZAR NOVA VENDA
    public static void finalizaVenda(){
        novaVenda.setValorFinal();
        novaVenda.setCodigoDeVenda();
        ControlCliente.getDadosR().getDados().getVendas().add(novaVenda);

    }
    /**
     * Metodo que recebe o idvenda e a partir disso encontra a venda que o detem no sistema,
     * apos isso salva todos os dados do mesmo em uma lista de strings para uso posterior na ViewVenda.
     * 
     * @param idVenda uma String que serve para encontrar a venda desejada no laco de repeticao.
     * @return a lista de strings com os dados selecionados de uma venda cadastrada no sistema.
     */
    
    //METODO PARA ADQUIRIR O DADOS PARA A TELA DE UMA VENDA
    public static List<String> pegarDadosVenda(String idVenda){
        int i = 0;
        String c = "Cartao";
        dadosViewVenda.clear();
        for(int index=0; index< ControlCliente.getDadosR().getDados().getVendas().size(); index++)
            if(ControlCliente.getDadosR().getDados().getVendas().get(index).getCodigoDeVenda().equals(idVenda))
                i = index;

        if(ControlCliente.getDadosR().getDados().getVendas().get(i).getCliente().getCartao().getNome().equals(""))
            c = "Boleto";

        dadosViewVenda.add(ControlCliente.getDadosR().getDados().getVendas().get(i).getCodigoDeVenda());
        dadosViewVenda.add(ControlCliente.getDadosR().getDados().getVendas().get(i).getCliente().getNome());
        dadosViewVenda.add(ControlCliente.getDadosR().getDados().getVendas().get(i).getCliente().getCpf());
        dadosViewVenda.add(ControlCliente.getDadosR().getDados().getVendas().get(i).getLoja().getNome());
        dadosViewVenda.add(ControlCliente.getDadosR().getDados().getVendas().get(i).getLoja().getCnpj());
        dadosViewVenda.add(String.valueOf(ControlCliente.getDadosR().getDados().getVendas().get(i).getDataVenda()));
        dadosViewVenda.add(String.valueOf(ControlCliente.getDadosR().getDados().getVendas().get(i).getValorFinal()));
        dadosViewVenda.add(String.valueOf(ControlCliente.getDadosR().getDados().getVendas().get(i).getFrete()));
        dadosViewVenda.add(c);

        return dadosViewVenda;
    }

}
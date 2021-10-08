package controller;

import models.*;
import java.util.ArrayList;
import java.util.List;

public class ControlVenda {
    //DECLARACAO
    private static final List<String[]> dadosVenda = new ArrayList<>();
    private static final List<String[]> dadosVenda2 = new ArrayList<>();
    private static final List<String> dadosViewVenda = new ArrayList<>();
    private static final List<Movel> vendaM = new ArrayList<>();
    private static final List<Eletrodomestico> vendaE = new ArrayList<>();
    private static Venda novaVenda;

    public ControlVenda(){
    }

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


    //METODO PARA FINALIZAR NOVA VENDA
    public static void finalizaVenda(){
        novaVenda.setValorFinal();
        novaVenda.setCodigoDeVenda();
        ControlCliente.getDadosR().getDados().getVendas().add(novaVenda);

    }

    //METODO PARA ADQUIRIR O DADOS PARA A TELA DE UM CLIENTE
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
package controller;

import models.Registro;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe para controle das acoes relacionadas ao dados do registro
 * 
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */


@SuppressWarnings("static-access")
public class ControlRegistro {
	
    //DECLARACAO
    private static final Registro dados = new Registro();
    private static final String[] sigla = {"DF", "MT", "GO", "MS", "SP", "RJ", "ES", "MG", "SC", "PR", "RS", "PB", "MA",
            "CE", "PI", "RN", "PE", "AL", "SE", "BA", "AM", "PA", "TO", "RO", "RR", "AC", "AP"};
    private static final List<String> siglas = new ArrayList<>(Arrays.asList(sigla));
    
    /**
     * Contrutor da classe ControlRegistro
     */
    public ControlRegistro(){
        try {
			dados.autoCadastro();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   
    
    /**
     * Metodo que recebe uma lista de strings referente aos dados de um cliente e apos isso
     * verifica a validade dos campos necessarios.
     * 
     * @param lista a lista de Strings referentes aos dados de um cliente.
     * @param a um numero inteiro que verifica a necessidade da verifcacao do CPF ou nao.
     * @return um numero inteiro que representa a quantidade de irregularidades encontradas.
     */
    //METODOS PARA VALIDACAO DE CLIENTE
    public static int verificarCliente(List<String> lista, int a){
        int cont = 0;

        //VERIFICACAO SE HA ALGUM CAMPO NULL
        for (int i=0; i < 9; i++){
            if(cont != 0)
                break;
            if(lista.get(i).isEmpty())
                cont++;
        }

        //VERIFICACAO DO NOME
        for (int i=0; i < lista.get(0).length(); i++){
            if(cont != 0)
                break;
            if((lista.get(0).toLowerCase().charAt(i) < 97
            || lista.get(0).toLowerCase().charAt(i) > 122)
            && lista.get(0).charAt(i) != 32)
                cont++;
        }
        //VERIFICACAO DO CPF
        if(a == 0){
            for(int index=0;index< ControlCliente.getDadosR().getDados().getCliente().size(); index++)
                if(ControlCliente.getDadosR().getDados().getCliente().get(index).getCpf().equals(lista.get(1))) {
                    cont++;
                    break;
                    }

            for (int i=0; i < lista.get(1).length(); i++){
                if(lista.get(1).length() != 11)
                    cont++;
                if(cont != 0)
                    break;
                if(lista.get(1).charAt(i) < 48
                || lista.get(1).charAt(i) > 57)
                    cont++;
            }
        }

        //VERIFICACAO DO DDD
        for (int i=0; i < lista.get(3).length(); i++){
            if(lista.get(3).length() != 3)
                cont++;
            if(cont != 0)
                break;
            if(lista.get(3).toLowerCase().charAt(i) < 48
                    || lista.get(3).toLowerCase().charAt(i) > 57)
                cont++;
        }

        //VERIFICACAO DO NUMERO
        for (int i=0; i < lista.get(4).length(); i++){

            if(lista.get(4).length() != 9)
                cont++;
            if(cont != 0)
                break;
            if(lista.get(4).toLowerCase().charAt(i) < 48
                    || lista.get(4).toLowerCase().charAt(i) > 57)
                cont++;
        }

        //VERIFICACAO DO UF
        int contUF = 0;
        for (String s : siglas) {

            if (cont != 0)
                break;
            if (lista.get(5).equals(s)) {
                contUF = 1;
                break;
            }

        }
        if(contUF == 0)
            cont++;


        return cont;
    }
    
    /**
     * Metodo que recebe uma lista de strings referente aos dados do cartao de um cliente
     *  e apos isso verifica a validade dos campos necessarios.
     * 
     * @param lista a lista de Strings referentes aos dados do cartao de um cliente.
     * @return um numero inteiro que representa a quantidade de irregularidades encontradas.
     */
    public static int verificarCartao(List<String> lista){
        int cont = 0;
        for (int i=8; i < lista.size(); i++){
            if(lista.get(i).equals(""))
                cont++;
        }
        return cont;
    }
    
    /**
     * Metodo que recebe uma lista de strings referente aos dados de um movel ou eletrodomestico
     *  e apos isso verifica a validade dos campos necessarios.
     * 
     * @param lista a lista de Strings referentes aos dados de um movel ou eletrodomestico.
     * @param a um numero inteiro que verifica se os campos analisados serao de um movel ou de um eletrodomestico.
     * @return um numero inteiro que representa a quantidade de irregularidades encontradas.
     */
    //METODOS PARA VALIDACAO DE ESTOQUE
    public static int verificarEstoque(List<String> lista, int a){
        int cont = 0;

        //VERIFICACAO SE HA ALGUM CAMPO NULL
        for (int i=1; i < lista.size(); i++){
            if(cont != 0)
                break;
            if(lista.get(i).equals(""))
                cont++;
        }

        //VERIFICACAO DE COR
        for (int i=0; i < lista.get(3).length(); i++){
            if(cont != 0)
                break;
            if((lista.get(3).toLowerCase().charAt(i) < 97
                    || lista.get(3).toLowerCase().charAt(i) > 122)
                    && lista.get(3).charAt(i) != 32)
                cont++;
        }

        //VERIFICACAO DO PRECO
        for (int i=0; i < lista.get(4).length(); i++){
            if(cont != 0)
                break;
            if((lista.get(4).charAt(i) < 48
            || lista.get(4).charAt(i) > 57)
            && lista.get(4).charAt(i) != 46)
                cont++;
        }

        //VERIFICACAO DO TAMANHO
        for (int i=0; i < lista.get(5).length(); i++){
            if(cont != 0)
                break;
            if((lista.get(5).charAt(i) < 48
            || lista.get(5).charAt(i) > 57)
            && lista.get(5).charAt(i) != 46)
                cont++;
        }

        //VERIFICACAO DO QUANTIDADE
        for (int i=0; i < lista.get(7).length(); i++){
            if(cont != 0)
                break;
            if(lista.get(7).charAt(i) < 48
            || lista.get(7).charAt(i) > 57)
                cont++;
        }

        if(a == 1){
            //VERIFICACAO DO CAPACIDADE
            for (int i=0; i < lista.get(8).length(); i++){
                if(cont != 0)
                    break;
                if((lista.get(8).charAt(i) < 48
                        || lista.get(8).charAt(i) > 57)
                        && lista.get(8).charAt(i) != 46)
                    cont++;
            }

            //VERIFICACAO DO VOLTAGEM
            for (int i=0; i < lista.get(9).length(); i++){
                if(cont != 0)
                    break;
                if((lista.get(9).charAt(i) < 48
                || lista.get(9).charAt(i) > 57)
                && lista.get(9).charAt(i) != 46)
                    cont++;
            }

            //VERIFICACAO DO POTENCIA
            for (int i=0; i < lista.get(10).length(); i++){
                if(cont != 0)
                    break;
                if((lista.get(10).charAt(i) < 48
                || lista.get(10).charAt(i) > 57)
                && lista.get(10).charAt(i) != 46)
                    cont++;
            }

        }
        return cont;
    }
    
    /**
     * Metodo que recebe String cpf, String quantidade, String id e um inteiro a, que determina a ordem da analise,
     * e apos isso verifica a validade das Strings. 
     * 
     * @param cpf uma String que determina qual cliente ira compor a venda.
     * @param quantidade uma String que determina a quantidade do produto que ira compor a venda.
     * @param id uma String que determina qual sera o produto a compor a venda.
     * @param a um inteiro que determina o que sera analisado no metodo.
     * @return um numero inteiro que representa a quantidade de irregularidades encontradas.
     */
    //METODOS PARA VALIDACAO DE VENDA
	public static int verificarVenda(String cpf, String quantidade, String id, int a){
        int cont = 0;
        int cont1 = 0;
        int cont2 = 0;
        
        //verificacao cpf da venda
        if(a == 0) {

            for (int i = 0; i < ControlCliente.getDadosR().getDados().getCliente().size(); i++) {

                if (cpf.equals(ControlCliente.getDadosR().getDados().getCliente().get(i).getCpf()) == true) {
                    cont1 = 1;}

            }

            if(cont1 == 0)
                cont = 1;

        }
        //verificacao quantidade digitada
        if(a == 1) {

            for (int i = 0; i < ControlCliente.getDadosR().getDados().getMovel().size(); i++) {

                if (id.equals(String.valueOf(ControlCliente.getDadosR().getDados().getMovel().get(i).getIdProduto()))){
                    if(Integer.parseInt(quantidade) > ControlCliente.getDadosR().getDados().getMovel().get(i).getQuantidade())
                        cont++;
                    cont2 = 1;
                }

            }

            for (int i = 0; i < ControlCliente.getDadosR().getDados().getEletro().size(); i++) {

                if (id.equals(String.valueOf(ControlCliente.getDadosR().getDados().getEletro().get(i).getIdProduto()))) {
                    if(Integer.parseInt(quantidade) > ControlCliente.getDadosR().getDados().getEletro().get(i).getQuantidade())
                        cont++;
                    cont2 = 1;
                    }

            }

            if(quantidade.equals(""))
                cont++;

            for (int i=0; i < quantidade.length(); i++){
                if(cont != 0)
                    break;
                if(quantidade.charAt(i) < 48
                   || quantidade.charAt(i) > 57)
                    cont++;
            }

            if(cont2 == 0)
                cont++;
        }


        return cont;
    }
	
	/**
	 * Metodo que recebe uma lista de strings referente aos dados da loja
     * e apos isso verifica a validade dos campos necessarios.
     * 
	 * @param lista a lista de Strings referentes aos dados de uma loja.
	 * @return um numero inteiro que representa a quantidade de irregularidades encontradas.
	 */
    //METODOS PARA VALIDACAO DE LOJA
    public static int verificarLoja(List<String> lista){
        int cont = 0;

        //VERIFICACAO SE HA ALGUM CAMPO NULL
        for (String value : lista) {
            if (cont != 0)
                break;
            if (value.equals(""))
                cont++;
        }

        //VERIFICACAO DO DDD
        for (int i=0; i < lista.get(2).length(); i++){
            if(lista.get(2).length() != 3)
                cont++;
            if(cont != 0)
                break;
            if(lista.get(2).toLowerCase().charAt(i) < 48
                    || lista.get(2).toLowerCase().charAt(i) > 57)
                cont++;
        }

        //VERIFICACAO DO NUMERO
        for (int i=0; i < lista.get(3).length(); i++){

            if(lista.get(3).length() != 9)
                cont++;
            if(cont != 0)
                break;
            if(lista.get(3).toLowerCase().charAt(i) < 48
                    || lista.get(3).toLowerCase().charAt(i) > 57)
                cont++;
        }

        //VERIFICACAO DO UF
        int contUF = 0;
        for (String s : siglas) {

            if (cont != 0)
                break;
            if (lista.get(4).equals(s)) {
                contUF = 1;
                break;
            }
        }

        if(contUF == 0)
        cont++;

        return cont;
    }

    //get
    public static Registro getDados() {
        return dados;
    }

}
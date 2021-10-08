package models;
import java.util.*;
/**
 * Classe modelo Estoque
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */
public class Estoque {
    //ATRIBUTOS PROPIO
    private int quantEstoque = 0;
    //ATRIBUTOS OBTIDOS A PARTIR DA COMPOSICAO COM ELETRODOMESTICO E MOVEL
    private final List<Movel> quantMoveis = new ArrayList<>();
    private final List<Eletrodomestico> quantEletros = new ArrayList<>();
    
    /**
     * Construtor Estoque
     */
    //CONTRUTOR ESTOQUE
    public Estoque() {
    }
    
    /**
     * Metodo que recebe um movel e acrescenta ele na lista de moveis do estoque.
     * 
     * @param movel Movel que ira ser acrescentado no estoque.
     */
    /*METODO SOBRECARREDO(estocar) PARA ACRESCENTAR OS OBJETOS
    MOVEIS E ELETRODOMESTICO NO ESTOQUE*/
    public void estocar(Movel movel){
        quantMoveis.add(movel);
        quantEstoque+=movel.getQuantidade();
    }
    
    /**
     * Metodo que recebe um eletrodomestico e acrescenta ele na lista de eletrodomesticos do estoque.
     * 
     * @param eletro Eletrodomestico que ira ser acrescentado no estoque.
     */
    public void estocar(Eletrodomestico eletro){
        quantEletros.add(eletro);
        quantEstoque+=eletro.getQuantidade();
    }

    //GETS E SETS
    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantremover) {

        this.quantEstoque = quantEstoque - quantremover;
    }

}


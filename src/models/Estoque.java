package models;
import java.util.*;
public class Estoque {
    //ATRIBUTOS PROPIO
    private int quantEstoque = 0;
    //ATRIBUTOS OBTIDOS A PARTIR DA COMPOSICAO COM ELETRODOMESTICO E MOVEL
    private final List<Movel> quantMoveis = new ArrayList<>();
    private final List<Eletrodomestico> quantEletros = new ArrayList<>();

    //CONTRUTOR ESTOQUE
    public Estoque() {
    }

    /*METODO SOBRECARREDO(estocar) PARA ACRESCENTAR OS OBJETOS
    MOVEIS E ELETRODOMESTICO NO ESTOQUE*/
    public void estocar(Movel movel){
        quantMoveis.add(movel);
        quantEstoque+=movel.getQuantidade();
    }
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


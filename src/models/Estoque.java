package models;
import java.util.*;
public class Estoque {
    //ATRIBUTOS PROPIO
    private int quantEstoque = 0;
    //ATRIBUTOS OBTIDOS A PARTIR DA COMPOSICAO COM ELETRODOMESTICO E MOVEL
    private List<Movel> quantMoveis = new ArrayList<>();
    private List<Eletrodomestico> quantEletros = new ArrayList<>();

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

    @Override
    public String toString() {
        StringBuilder full;
        full = new StringBuilder(" Estoque de Moveis:");
        for (Movel quantMovei : quantMoveis) full.append("\n ").append(quantMovei.concatenador());
        full.append("\n Estoque de Eletrodomesticos:");
        for (Eletrodomestico quantEletro : quantEletros) full.append("\n ").append(quantEletro.concatenador());
        return full.toString();
    }

    //GETS E SETS
    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantremover) {

        this.quantEstoque = quantEstoque - quantremover;
    }

    public List<Movel> getQuantMoveis() {
        return quantMoveis;
    }

    public void setQuantMoveis(List<Movel> quantMoveis) {
        this.quantMoveis = quantMoveis;
    }

    public List<Eletrodomestico> getQuantEletros() {
        return quantEletros;
    }

    public void setQuantEletros(List<Eletrodomestico> quantEletros) {
        this.quantEletros = quantEletros;
    }
}


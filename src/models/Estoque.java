package models;
import java.util.*;
public class Estoque {

    private static List<Movel> moveis = new ArrayList<>();
    private static List<Eletrodomestico> eletros = new ArrayList<>();

    public int quantMoveis(){
        return moveis.size();
    }
    public int quantEletro(){
        return eletros.size();
    }

    public static List<Movel> getMoveis() {
        return moveis;
    }

    public static void setMoveis(List<Movel> moveis) {
        Estoque.moveis = moveis;
    }

    public static List<Eletrodomestico> getEletros() {
        return eletros;
    }

    public static void setEletros(List<Eletrodomestico> eletros) {
        Estoque.eletros = eletros;
    }
}

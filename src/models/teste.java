package models;

public class teste {
    public static void main(String[] args){
         //TESTE CRUD MOVEL
         var testMovel = new Movel(1, "Sofa", "4 lugares", "Marrom", 1400, "0.5m de altura 3m de comprimento",
                                     "nike", 3, "sala", "veludo", true);
         System.out.println(testMovel.toString());
         testMovel.setCor(" verde\n");
         System.out.println(testMovel.getCor());
         //TESTE CRUD ELETRODOMESTICO
         var testEletro = new Eletrodomestico(2, "Geladeira", "compacta", "Branco", 2400, "2.3m de altura 0.95m de comprimento",
                                               "consu", 5, "50L", "50v", "500w");
         System.out.println(testEletro.toString());
         testEletro.setCor("Azul");
         System.out.println(testEletro.getCor());
    }

}

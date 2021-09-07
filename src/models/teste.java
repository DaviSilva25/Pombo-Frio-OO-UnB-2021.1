package models;
import java.util.*;

public class teste {
    public static void main(String[] args){
         Calendar c = Calendar.getInstance();
         c.set(2013, Calendar.FEBRUARY, 28);
         Date data = c.getTime();

         //TESTE CRUD MOVEL
         Movel testMovel = new Movel(1, "Sofa", "4 lugares", "Marrom", 1400, "0.5m de altura 3m de comprimento",
                                        "nike", 3, "sala", "veludo", true);
         System.out.println(testMovel.toString());
         testMovel.setCor(" verde\n");
         System.out.println(testMovel.getCor());

         //TESTE CRUD ELETRODOMESTICO
         Eletrodomestico testEletro = new Eletrodomestico(2, "Geladeira", "compacta", "Branco", 2400, "2.3m de altura 0.95m de comprimento",
                                                            "consu", 5, "50L", "50v", "500w");
         System.out.println(testEletro.toString());
         testEletro.setCor(" Azul");
         System.out.println(testEletro.getCor());

         //TESTE CRUD TELEFONE
         Telefone telefoneTest = new Telefone("1","111111");

         //TESTE CRUD ENDERECO
         Endereco enderecoMain = new Endereco("A","B","C","D");

         //TESTE CRUD CARTAO
         Cartao cartaoMain = new Cartao("A","B","C","D");

         //TESTE CRUD LOJA
         Loja lojaMain = new Loja("JONH JHONICSX", "DUSAHDUAS", telefoneTest, enderecoMain);
         System.out.println(lojaMain.toString());

         //TESTE CRUD CLIENTE
         Cliente clienteMain = new Cliente("Davi", "1289",data, enderecoMain, telefoneTest, cartaoMain);
         System.out.println(clienteMain.toString());

    }

}

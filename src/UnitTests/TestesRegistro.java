package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import controller.ControlRegistro;

class TestesRegistro {
	//testes cliente
	String[] clienteTeste = {"Davi", "22345678148","12/12/2001", "061", "123123123","DF","A","A","A"};
	String[] clienteTeste1 = {"Davi", "12345678148","12/12/2001", "061", "123123123","DF","A","A","A"};
    String[] clienteTeste2 = {"Davi1", "12345678910","12/12/2001", "061", "123123123","DF","A","A","A"};
    String[] clienteTeste3 = {"Davi", "1234567891","12/12/2001", "061", "123123123","DF","A","A","A"};
    String[] clienteTeste4 = {"Davi", "1234567891a","12/12/2001", "061", "123123123","DF","A","A","A"};
    String[] clienteTeste5 = {"Davi", "12345678910","12/12/2001", "06", "123123123","DF","A","A","A"};
    String[] clienteTeste6 = {"Davi", "12345678910","12/12/2001", "06a", "123123123","DF","A","A","A"};
    String[] clienteTeste7 = {"Davi", "12345678910","12/12/2001", "061", "12312312","DF","A","A","A"};
    String[] clienteTeste8 = {"Davi", "12345678910","12/12/2001", "06a", "12312312a","DF","A","A","A"};
    String[] clienteTeste9 = {"Davi", "12345678910","12/12/2001", "06a", "123123123","Da","A","A","A"};
    String[] clienteTeste10 = {"Davi", "12345678910","12/12/2001", "06a", "123123123","DF","","",""};
    
    List<String> cliente = new ArrayList<String>(Arrays.asList(clienteTeste));
    List<String> cliente1 = new ArrayList<String>(Arrays.asList(clienteTeste1));
    List<String> cliente2 = new ArrayList<String>(Arrays.asList(clienteTeste2));
    List<String> cliente3 = new ArrayList<String>(Arrays.asList(clienteTeste3));
    List<String> cliente4 = new ArrayList<String>(Arrays.asList(clienteTeste4));
    List<String> cliente5 = new ArrayList<String>(Arrays.asList(clienteTeste5));
    List<String> cliente6 = new ArrayList<String>(Arrays.asList(clienteTeste6));
    List<String> cliente7 = new ArrayList<String>(Arrays.asList(clienteTeste7));
    List<String> cliente8 = new ArrayList<String>(Arrays.asList(clienteTeste8));
    List<String> cliente9 = new ArrayList<String>(Arrays.asList(clienteTeste9));
    List<String> cliente10 = new ArrayList<String>(Arrays.asList(clienteTeste10));
	
    //testes moveis e eletrodomesticos
    String[] movelTeste1 = {"id", "T","T", "COR", "100","10","T","10","A","T"};
    String[] movelTeste2 = {"id", "T","T", "COR1", "100","10","T","10","A","T"};
    String[] movelTeste3 = {"id", "T","T", "COR", "100a","10","T","10","A","T"};
    String[] movelTeste4 = {"id", "T","T", "COR", "100","10a","T","10","A","T"};
    String[] movelTeste5 = {"id", "T","T", "COR", "100","10","T","10a","A","T"};
    String[] movelTeste6 = {"id", "","T", "COR", "100","10","T","10","A","T"};
    
    String[] eletroTeste1 = {"id", "T","T", "COR", "100","10","T","10","10","10","10"};
    String[] eletroTeste2 = {"id", "T","T", "COR1", "100","10","T","10","10","10","10"};
    String[] eletroTeste3 = {"id", "T","T", "COR", "100a","10","T","10","10","10","10"};
    String[] eletroTeste4 = {"id", "T","T", "COR", "100","10a","T","10","10","10","10"};
    String[] eletroTeste5 = {"id", "T","T", "COR", "100","10","T","10a","10","10","10"};
    String[] eletroTeste6 = {"id", "T","T", "COR", "100","10","T","10","10a","10","10"};
    String[] eletroTeste7 = {"id", "T","T", "COR", "100","10","T","10","10","10a","10"};
    String[] eletroTeste8 = {"id", "T","T", "COR", "100","10","T","10","10","10","10a"};
    String[] eletroTeste9 = {"id", "","T", "COR", "100","10","T","10","10","10","10"};
   
    
    List<String> movel1 = new ArrayList<String>(Arrays.asList(movelTeste1));
    List<String> movel2 = new ArrayList<String>(Arrays.asList(movelTeste2));
    List<String> movel3 = new ArrayList<String>(Arrays.asList(movelTeste3));
    List<String> movel4 = new ArrayList<String>(Arrays.asList(movelTeste4));
    List<String> movel5 = new ArrayList<String>(Arrays.asList(movelTeste5));
    List<String> movel6 = new ArrayList<String>(Arrays.asList(movelTeste6));
    
    List<String> eletro1 = new ArrayList<String>(Arrays.asList(eletroTeste1));
    List<String> eletro2 = new ArrayList<String>(Arrays.asList(eletroTeste2));
    List<String> eletro3 = new ArrayList<String>(Arrays.asList(eletroTeste3));
    List<String> eletro4 = new ArrayList<String>(Arrays.asList(eletroTeste4));
    List<String> eletro5 = new ArrayList<String>(Arrays.asList(eletroTeste5));
    List<String> eletro6 = new ArrayList<String>(Arrays.asList(eletroTeste6));
    List<String> eletro7 = new ArrayList<String>(Arrays.asList(eletroTeste7));
    List<String> eletro8 = new ArrayList<String>(Arrays.asList(eletroTeste8));
    List<String> eletro9 = new ArrayList<String>(Arrays.asList(eletroTeste9));
	
	@Test
	void test1() {
		assertEquals(0,ControlRegistro.verificarCliente(cliente, 0));
		assertNotEquals(0,ControlRegistro.verificarCliente(cliente1, 0));
		assertNotEquals(0,ControlRegistro.verificarCliente(cliente2, 0));
		assertNotEquals(0,ControlRegistro.verificarCliente(cliente3, 0));
		assertNotEquals(0,ControlRegistro.verificarCliente(cliente4, 0));
		assertNotEquals(0,ControlRegistro.verificarCliente(cliente5, 0));
		assertNotEquals(0,ControlRegistro.verificarCliente(cliente6, 0));
		assertNotEquals(0,ControlRegistro.verificarCliente(cliente7, 0));
		assertNotEquals(0,ControlRegistro.verificarCliente(cliente8, 0));
		assertNotEquals(0,ControlRegistro.verificarCliente(cliente9, 0));
		assertNotEquals(0,ControlRegistro.verificarCliente(cliente10, 0));
	}
	
	@Test
	void test2() {
		assertEquals(0,ControlRegistro.verificarEstoque(movel1, 0));
		assertNotEquals(0,ControlRegistro.verificarEstoque(movel2, 0));
		assertNotEquals(0,ControlRegistro.verificarEstoque(movel3, 0));
		assertNotEquals(0,ControlRegistro.verificarEstoque(movel4, 0));
		assertNotEquals(0,ControlRegistro.verificarEstoque(movel5, 0));
		assertNotEquals(0,ControlRegistro.verificarEstoque(movel6, 0));
		
		assertEquals(0,ControlRegistro.verificarEstoque(eletro1, 1));
		assertNotEquals(0,ControlRegistro.verificarEstoque(eletro2, 1));
		assertNotEquals(0,ControlRegistro.verificarEstoque(eletro3, 1));
		assertNotEquals(0,ControlRegistro.verificarEstoque(eletro4, 1));
		assertNotEquals(0,ControlRegistro.verificarEstoque(eletro5, 1));
		assertNotEquals(0,ControlRegistro.verificarEstoque(eletro6, 1));
		assertNotEquals(0,ControlRegistro.verificarEstoque(eletro7, 1));
		assertNotEquals(0,ControlRegistro.verificarEstoque(eletro8, 1));
		assertNotEquals(0,ControlRegistro.verificarEstoque(eletro9, 1));
	}
	@Test
	void test3() {
		assertEquals(0, ControlRegistro.verificarVenda("12345678122", "", "", 0));
		assertNotEquals(0, ControlRegistro.verificarVenda("22345678122", "", "", 0));
		assertEquals(0, ControlRegistro.verificarVenda("", "2", "1", 1));
		assertEquals(0, ControlRegistro.verificarVenda("", "2", "2", 1));
		assertNotEquals(0, ControlRegistro.verificarVenda("", "2", "a", 1));
		assertNotEquals(0, ControlRegistro.verificarVenda("", "1000", "1", 1));
		assertNotEquals(0, ControlRegistro.verificarVenda("", "1000", "2", 1));
		assertNotEquals(0, ControlRegistro.verificarVenda("", "1000", "300", 1));
		assertNotEquals(0, ControlRegistro.verificarVenda("", "", "", 1));
	}

}



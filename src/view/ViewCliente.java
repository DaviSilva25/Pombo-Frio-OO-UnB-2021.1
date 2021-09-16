package view;
import javax.swing.*;

import models.Registro;

import java.awt.*;

public class ViewCliente{
    public static Registro d = new Registro();
    private static JFrame janela = new JFrame("CLIENTES");
    private static JPanel painel = new JPanel();
    private static JPanel painelBotoes = new JPanel();
    private static JButton cadastrar = new JButton("CADASTRAR");
    private static JButton filtrar = new JButton("FILTRAR");
    private static JButton deletar = new JButton("DELETAR");

    public ViewCliente(){
        painel.setLayout(null);
        janela.setBounds(600,200, 700,500);

        //CADASTRAR
        cadastrar.setFont(new Font("Arial", Font.BOLD, 10));
        cadastrar.setBounds(50,400, 100,40);
        painelBotoes.add(cadastrar);

        //FILTRAR
        filtrar.setFont(new Font("Arial", Font.BOLD, 10));
        filtrar.setBounds(250,400, 100,40);
        painelBotoes.add(filtrar);

        //DELETAR
        deletar.setFont(new Font("Arial", Font.BOLD, 10));
        deletar.setBounds(450,400, 100,40);
        painelBotoes.add(deletar);


        janela.add(painel);
        painel.setVisible(true);
        janela.add(painelBotoes);
        janela.setVisible(true);
    }

}




package view;

import controller.ControlCliente;
import controller.ControlLoja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ViewLoja {

    //dados Loja
    private static JFrame janela = new JFrame("Loja");
    private static JLabel labelNome = new JLabel("Nome:");
    private static JTextField valorNome = new JTextField();
    private static JLabel labelCNPJ = new JLabel("CNPJ: ");
    private static JTextField valorCNPJ = new JTextField();
    //dados Telefone
    private static JLabel labelTelefone = new JLabel("Telefone: ");
    private static JTextField valorDDD = new JTextField();
    private static JTextField valorTelefone = new JTextField();
    //dados Endereco
    private static JLabel labelEndereco = new JLabel("Endereco: ");
    private static JLabel labelUF = new JLabel("UF: ");
    private static JTextField valorUF = new JTextField();
    private static JLabel labelCidade = new JLabel("Cidade: ");
    private static JTextField valorCidade = new JTextField();
    private static JLabel labelBairro = new JLabel("Bairro: ");
    private static JTextField valorBairro = new JTextField();
    private static JLabel labelLogradouro = new JLabel("Logradouro: ");
    private static JTextField valorLogradouro = new JTextField();
    //DECLARACAO
    private static List<String> dadosLoja = new ArrayList<>(ControlLoja.pegarDadosLoja());
    private static JButton salvar = new JButton("Salvar");
    private static MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if(e.getSource() == salvar) {
                ControlLoja.alterarDadosLoja(dadosDigitados());
                dadosLoja = dadosDigitados();
                new ViewMenu();
                janela.dispose();
            }
        }
    };


    //metodo para organizar na janela os dados da loja
    public ViewLoja() {
        //CONFIGURACOES DA JANELA
        janela.setLayout(null);
        janela.setVisible(true);
        janela.setResizable(false);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setBackground(new Color(227, 176, 255));
        janela.setSize(423, 460);
        janela.setLocationRelativeTo(null);

        //BOTAO SALVAR
        salvar.removeMouseListener(click);
        salvar.setBounds(130, 353, 150, 50);
        //clienteButton.setIcon(cliente2);
        salvar.setFocusable(false);
        salvar.addMouseListener(click);
        janela.add(salvar);

        //DADOS DA LOJA
        labelNome.setBounds(20,20, 150, 25);
        janela.add(labelNome);
        valorNome.setBounds(180,20, 210,25);
        valorNome.setText(dadosLoja.get(0));
        janela.add(valorNome);

        labelCNPJ.setBounds(20,50, 150,25);
        janela.add(labelCNPJ);
        valorCNPJ.setBounds(180,50, 130,25);
        valorCNPJ.setText(dadosLoja.get(1));
        janela.add(valorCNPJ);

        labelTelefone.setBounds(20,80, 150,25);
        janela.add(labelTelefone);
        valorDDD.setBounds(180,80, 33,25);
        valorDDD.setText(dadosLoja.get(2));
        janela.add(valorDDD);
        valorTelefone.setBounds(215,80, 95,25);
        valorTelefone.setText(dadosLoja.get(3));
        janela.add(valorTelefone);

        labelEndereco.setBounds(20,120, 150,25);
        janela.add(labelEndereco);

        labelUF.setBounds(150,120,28,25);
        janela.add(labelUF);
        valorUF.setBounds(180,120, 33,25);
        valorUF.setText(dadosLoja.get(4));
        janela.add(valorUF);

        labelCidade.setBounds(225,120, 58,25);
        janela.add(labelCidade);
        valorCidade.setBounds(275,120, 115,25);
        valorCidade.setText(dadosLoja.get(5));
        janela.add(valorCidade);

        labelBairro.setBounds(129,150, 58,25);
        janela.add(labelBairro);
        valorBairro.setBounds(180,150, 210,25);
        valorBairro.setText(dadosLoja.get(6));
        janela.add(valorBairro);

        labelLogradouro.setBounds(99,180, 78,25);
        janela.add(labelLogradouro);
        valorLogradouro.setBounds(180,180, 210,25);
        valorLogradouro.setText(dadosLoja.get(7));
        janela.add(valorLogradouro);
    }

    //metodo para pegar o dados digitados
    public static List<String> dadosDigitados(){
        List<String> dadosNovos = new ArrayList<>();
        dadosNovos.add(valorNome.getText());
        dadosNovos.add(valorCNPJ.getText());
        dadosNovos.add(valorDDD.getText());
        dadosNovos.add(valorTelefone.getText());
        dadosNovos.add(valorUF.getText());
        dadosNovos.add(valorCidade.getText());
        dadosNovos.add(valorBairro.getText());
        dadosNovos.add(valorLogradouro.getText());

        return dadosNovos;
    }
}

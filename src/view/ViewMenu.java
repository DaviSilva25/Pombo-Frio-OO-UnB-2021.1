package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewMenu{
    private static JFrame janela = new JFrame();
    private static JPanel clientePanel = new JPanel();
    private static JPanel estoquePanel = new JPanel();
    private static JPanel vendaPanel = new JPanel();
    private static JPanel lojaPanel = new JPanel();
    private static JButton clienteButton = new JButton();
    private static JButton estoqueButton = new JButton();
    private static JButton vendaButton = new JButton();
    private static JButton lojaButton = new JButton();
    private static MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == clienteButton){
                new ViewCliente(0);
                janela.dispose();
            }

        }
    };

    public static void main(String[] args) {
        new ViewMenu();

    }

    public ViewMenu(){
        JLabel logoPanel = new JLabel();
        janela.setLayout(null);
        ImageIcon logo = new ImageIcon("src/images/pombo.png");
        ImageIcon logo2 = new ImageIcon("src/images/logoPombo.png");

        logoPanel.setIcon(logo);
        logoPanel.setBounds(17,20, 301,200);
        ClienteMenu();
        EstoqueMenu();
        VendaMenu();
        LojaMenu();


        janela.setSize(350,670);
        janela.setLocationRelativeTo(null);
        janela.setTitle("Menu Principal");
        janela.setIconImage(logo2.getImage());
        janela.getContentPane().setBackground(new Color(218,228,233));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.setVisible(true);
        janela.add(logoPanel);
        janela.add(clientePanel);
        janela.add(estoquePanel);
        janela.add(vendaPanel);
        janela.add(lojaPanel);
    }


    //ESTRUTURA DO CLIENTE NO MENU
    public void ClienteMenu(){
        JLabel clienteLabel = new JLabel();

        ImageIcon cliente = new ImageIcon("src/images/cliente.png");
        ImageIcon cliente2 = new ImageIcon("src/images/ButtonCliente.png");

        clientePanel.setLayout(null);
        clientePanel.setBackground(new Color(227,176,255));
        clientePanel.setBounds(42,240, 250,72);
        clientePanel.setBorder(BorderFactory.createLineBorder(new Color(101,1,154),3));

        clienteButton.removeMouseListener(click);
        clienteButton.setBounds(75,6, 169,60);
        clienteButton.setIcon(cliente2);
        clienteButton.setFocusable(false);
        clienteButton.addMouseListener(click);

        clienteLabel.setIcon(cliente);
        clienteLabel.setBounds(3,3 ,69,66);

        clientePanel.setVisible(true);
        clientePanel.add(clienteLabel);
        clientePanel.add(clienteButton);
    }
    //ESTRUTURA DO ESTOQUE NO MENU
    public void EstoqueMenu(){
        JLabel estoqueLabel = new JLabel();

        ImageIcon estoque = new ImageIcon("src/images/estoque.png");
        ImageIcon estoque2 = new ImageIcon("src/images/ButtonEstoque.png");

        estoquePanel.setLayout(null);
        estoquePanel.setBackground(new Color(227,176,255));
        estoquePanel.setBounds(42,332, 250,72);
        estoquePanel.setBorder(BorderFactory.createLineBorder(new Color(101,1,154),3));

        estoqueButton.setBounds(75,6, 169,60);
        estoqueButton.setIcon(estoque2);
        estoqueButton.setFocusable(false);

        estoqueLabel.setIcon(estoque);
        estoqueLabel.setBounds(3,3 ,69,66);

        estoquePanel.setVisible(true);
        estoquePanel.add(estoqueLabel);
        estoquePanel.add(estoqueButton);
    }
    //ESTRUTURA DA VENDA NO MENU
    public void VendaMenu(){
        JLabel vendaLabel = new JLabel();

        ImageIcon venda = new ImageIcon("src/images/venda.png");
        ImageIcon venda2 = new ImageIcon("src/images/ButtonVenda.png");

        vendaPanel.setLayout(null);
        vendaPanel.setBackground(new Color(227,176,255));
        vendaPanel.setBounds(42,424, 250,72);
        vendaPanel.setBorder(BorderFactory.createLineBorder(new Color(101,1,154),3));

        vendaButton.setBounds(75,6, 169,60);
        vendaButton.setIcon(venda2);
        vendaButton.setFocusable(false);

        vendaLabel.setIcon(venda);
        vendaLabel.setBounds(3,3 ,69,66);

        vendaPanel.setVisible(true);
        vendaPanel.add(vendaLabel);
        vendaPanel.add(vendaButton);
    }
    //ESTRUTURA DA LOJA NO MENU
    public void LojaMenu(){
        JLabel lojaLabel = new JLabel();

        ImageIcon loja = new ImageIcon("src/images/loja.png");
        ImageIcon loja2 = new ImageIcon("src/images/ButtonLoja.png");

        lojaPanel.setLayout(null);
        lojaPanel.setBackground(new Color(227,176,255));
        lojaPanel.setBounds(42,516, 250,72);
        lojaPanel.setBorder(BorderFactory.createLineBorder(new Color(101,1,154),3));

        lojaButton.setBounds(75,6, 169,60);
        lojaButton.setIcon(loja2);
        lojaButton.setFocusable(false);

        lojaLabel.setIcon(loja);
        lojaLabel.setBounds(3,3 ,69,66);

        lojaPanel.setVisible(true);
        lojaPanel.add(lojaLabel);
        lojaPanel.add(lojaButton);
    }


}


package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Classe View Menu
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */
public class ViewMenu{
    private static final JFrame janela = new JFrame();
    private static final JPanel clientePanel = new JPanel();
    private static final JPanel estoquePanel = new JPanel();
    private static final JPanel vendaPanel = new JPanel();
    private static final JPanel lojaPanel = new JPanel();
    private static final JButton clienteButton = new JButton();
    private static final JButton estoqueButton = new JButton();
    private static final JButton vendaButton = new JButton();
    private static final JButton lojaButton = new JButton();
    private static final MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            //evento clique no botao cliente
            if(e.getSource() == clienteButton){
                new ViewCliente(0);
                janela.dispose();
            }
            //evento clique no botao estoque
            if(e.getSource() == estoqueButton){
                new ViewEstoque(0);
                janela.dispose();
            }
            //evento clique no botao venda
            if(e.getSource() == vendaButton){
                new ViewVenda(0);
                janela.dispose();
            }
            //evento clique no botao loja
            if(e.getSource() == lojaButton){
                new ViewLoja();
                janela.dispose();
            }
        }
    };
    /**
     * Metodo main do programa
     * @param args
     */
    public static void main(String[] args) {
        new ViewMenu();
    }
    
    /**
     * Construtor da ViewMenu
     */
    public ViewMenu(){

        janela.setLayout(null);
        JLabel logoPanel = new JLabel();
        ImageIcon logo = new ImageIcon("src/images/pombo.png");
        ImageIcon logo2 = new ImageIcon("src/images/logoPombo.png");

        logoPanel.setIcon(logo);
        logoPanel.setBounds(17,20, 301,200);

        //Organiza os componentes de cliente no menu
        clienteMenu();
        //Organiza os componentes de estoque no menu
        estoqueMenu();
        //Organiza os componentes de venda no menu
        vendaMenu();
        //Organiza os componentes de loja no menu
        lojaMenu();

        //definicoes da janela
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

    /**
     * Metodo que organiza o botao cliente na janela menu
     */
    //ESTRUTURA DO CLIENTE NO MENU
    public void clienteMenu(){
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
    
    /**
     * Metodo que organiza o botao estoque na janela menu
     */
    //ESTRUTURA DO ESTOQUE NO MENU
    public void estoqueMenu(){
        JLabel estoqueLabel = new JLabel();

        ImageIcon estoque = new ImageIcon("src/images/estoque.png");
        ImageIcon estoque2 = new ImageIcon("src/images/ButtonEstoque.png");

        estoquePanel.setLayout(null);
        estoquePanel.setBackground(new Color(227,176,255));
        estoquePanel.setBounds(42,332, 250,72);
        estoquePanel.setBorder(BorderFactory.createLineBorder(new Color(101,1,154),3));

        estoqueButton.removeMouseListener(click);
        estoqueButton.setBounds(75,6, 169,60);
        estoqueButton.setIcon(estoque2);
        estoqueButton.setFocusable(false);
        estoqueButton.addMouseListener(click);

        estoqueLabel.setIcon(estoque);
        estoqueLabel.setBounds(3,3 ,69,66);

        estoquePanel.setVisible(true);
        estoquePanel.add(estoqueLabel);
        estoquePanel.add(estoqueButton);
    }
    
    /**
     * Metodo que organiza o botao venda na janela menu
     */
    //ESTRUTURA DA VENDA NO MENU
    public void vendaMenu(){
        JLabel vendaLabel = new JLabel();

        ImageIcon venda = new ImageIcon("src/images/venda.png");
        ImageIcon venda2 = new ImageIcon("src/images/ButtonVenda.png");

        vendaPanel.setLayout(null);
        vendaPanel.setBackground(new Color(227,176,255));
        vendaPanel.setBounds(42,424, 250,72);
        vendaPanel.setBorder(BorderFactory.createLineBorder(new Color(101,1,154),3));

        vendaButton.removeMouseListener(click);
        vendaButton.setBounds(75,6, 169,60);
        vendaButton.setIcon(venda2);
        vendaButton.setFocusable(false);
        vendaButton.addMouseListener(click);

        vendaLabel.setIcon(venda);
        vendaLabel.setBounds(3,3 ,69,66);

        vendaPanel.setVisible(true);
        vendaPanel.add(vendaLabel);
        vendaPanel.add(vendaButton);
    }
    
    /**
     * Metodo que organiza o botao loja na janela menu
     */
    //ESTRUTURA DA LOJA NO MENU
    public void lojaMenu(){
        JLabel lojaLabel = new JLabel();

        ImageIcon loja = new ImageIcon("src/images/loja.png");
        ImageIcon loja2 = new ImageIcon("src/images/ButtonLoja.png");

        lojaPanel.setLayout(null);
        lojaPanel.setBackground(new Color(227,176,255));
        lojaPanel.setBounds(42,516, 250,72);
        lojaPanel.setBorder(BorderFactory.createLineBorder(new Color(101,1,154),3));

        lojaButton.removeMouseListener(click);
        lojaButton.setBounds(75,6, 169,60);
        lojaButton.setIcon(loja2);
        lojaButton.setFocusable(false);
        lojaButton.addMouseListener(click);

        lojaLabel.setIcon(loja);
        lojaLabel.setBounds(3,3 ,69,66);

        lojaPanel.setVisible(true);
        lojaPanel.add(lojaLabel);
        lojaPanel.add(lojaButton);
    }


}


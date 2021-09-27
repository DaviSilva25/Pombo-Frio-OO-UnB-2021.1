package view;
import controller.ControlCliente;
import controller.ControlRegisto;
import modelTables.MTableCliente;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCliente implements ActionListener {

    private static ControlCliente a = new ControlCliente();
    public static ControlRegisto d;
    static {
        try {
            d = new ControlRegisto();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private static JPanel painel = new JPanel();
    private static JPanel painelButtons = new JPanel();
    private static JButton cadastrar = new JButton();
    private static JButton filtrar = new JButton();
    private static JButton menu = new JButton();
    private static JLabel listaCliente = new JLabel();
    private static JLabel logoJanela = new JLabel();
    private static JFrame janela = new JFrame("CLIENTE");
    private static MTableCliente dadosTabela = new MTableCliente(ControlCliente.dadosTabela(d));
    private static JTable tabelaCliente = new JTable(dadosTabela);
    private static JScrollPane scroll = new JScrollPane(tabelaCliente);

    public ViewCliente(){
        janela.setLayout(null);
        janela.setBounds(500,200, 800,525);
        scroll.setBackground(new Color(101,240,154));

        //FUNCAO QUE CHAMA SO BOTOES
        painelBotoes();

        //LABEL DA LOGO
        logoJanela.setIcon(new ImageIcon("src/images/logo2Pombo.png"));
        logoJanela.setBounds(15,25, 175,175);

        //PANEL DA TABELA
        painel.setLayout(new GridLayout());
        painel.setBorder(BorderFactory.createLineBorder(new Color(101,1,154),5));
        painel.setBounds(200,25, 570,450);

        //DEFINIÇÕES DA TABELA
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabelaCliente.getTableHeader().setReorderingAllowed(false);
        tabelaCliente.getTableHeader().setResizingAllowed(false);
        tabelaCliente.getTableHeader().setBackground(new Color(101,240,154));
        tabelaCliente.getTableHeader().setForeground(Color.black);
        tabelaCliente.getTableHeader().setFont(new Font("Consolas",Font.BOLD,15));
        tabelaCliente.setSelectionBackground(new Color(101,90,154));
        tabelaCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaCliente.setFont(new Font("Consolas",Font.ITALIC,11));
        tabelaCliente.setBackground(new Color(218,230,233));
        tabelaCliente.setRowHeight(22);
        tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(10);
        tabelaCliente.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        tabelaCliente.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        tabelaCliente.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        tabelaCliente.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        tabelaCliente.setFocusable(false);

        //TITULO DA LISTA
        listaCliente.setText("LISTA DE CLIENTES");
        listaCliente.setBounds(372, 2, 230,25);
        listaCliente.setFont(new Font("Consolas",Font.ITALIC,23));

        //DEFINICOES DA JANELA
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setIconImage(new ImageIcon("src/images/logoPombo.png").getImage());
        janela.getContentPane().setBackground(new Color(227,176,255));
        janela.setVisible(true);
        painel.add(scroll);
        janela.add(logoJanela);
        janela.add(listaCliente);
        janela.add(painelButtons);
        janela.add(painel);
    }

    public void painelBotoes(){

        //DEFINICOES DO PAINEL
        painelButtons.setLayout(null);
        painelButtons.setBorder(BorderFactory.createLineBorder(new Color(101,1,154),5));
        painelButtons.setBounds(15,285, 170,190);
        painelButtons.setBackground(new Color(161,96,228));

        //BOTAO CADASTRAR
        cadastrar.setBounds(10,10, 150,50);
        cadastrar.setIcon(new ImageIcon("src/images/novoButton.png"));
        cadastrar.setFocusable(false);
        cadastrar.addActionListener(this);

        //BOTAO FILTRAR
        filtrar.setBounds(10,70, 150,50);
        filtrar.setIcon(new ImageIcon("src/images/filtrarButton.png"));
        filtrar.setFocusable(false);

        //BOTAO MENU
        menu.setBounds(10, 130, 150,50);
        menu.setIcon(new ImageIcon("src/images/menuButton.png"));
        menu.setFocusable(false);
        menu.addActionListener(this);

        //ADICIONANDO OS BOTOES AO PAINEL
        painelButtons.add(cadastrar);
        painelButtons.add(filtrar);
        painelButtons.add(menu);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cadastrar){
            painel.remove(scroll);
            janela.dispose();
            new ViewMenu();
        }
        else if
        (e.getSource() == menu){
            painel.remove(scroll);
            janela.dispose();
            new ViewMenu();
        }

    }


}




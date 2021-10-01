package view;


import controller.ControlEstoque;
import modelTables.MTableEletro;
import modelTables.MTableMovel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewEstoque {

    private static JPanel painelButtons = new JPanel();
    private static JButton cadastrarMovel = new JButton();
    private static JButton cadastrarEletro = new JButton();
    private static JButton filtrar = new JButton();
    private static JButton menu = new JButton();
    private static JButton ok = new JButton("ok");
    private static JLabel logoJanela = new JLabel();
    private static JFrame janela = new JFrame("ESTOQUE");
    private static JTextField filtroTextfield = new JTextField();
    private static JLabel labelFiltro = new JLabel("Digite o nome para o filtro: ");

    private static JLabel listaMovel = new JLabel();
    private static JPanel painelMovel = new JPanel();
    private static MTableMovel dadosTabela;
    private static JTable tabelaMovel = new JTable();
    private static JScrollPane scroll = new JScrollPane();

    private static JLabel listaEletro = new JLabel();
    private static JPanel painelEletro = new JPanel();
    private static MTableEletro dadosTabela2;
    private static JTable tabelaEletro = new JTable();
    private static JScrollPane scroll2 = new JScrollPane();
    private static MouseAdapter click = new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {

            if(e.getClickCount() == 2 && e.getSource() == tabelaMovel) {
                new ViewDetalheMovel((String) tabelaMovel.getValueAt(tabelaMovel.getSelectedRow(),0), 1);
                janela.dispose();
            }

            if(e.getSource() == cadastrarMovel){
                new ViewDetalheMovel("qualquer coisa",2);
                janela.dispose();
            }

            if(e.getClickCount() == 2 && e.getSource() == tabelaEletro) {
                new ViewDetalheEletro((String) tabelaEletro.getValueAt(tabelaEletro.getSelectedRow(),0), 1);
                janela.dispose();
            }

            if(e.getSource() == cadastrarEletro){
                new ViewDetalheEletro("qualquer coisa",2);
                janela.dispose();
            }

            if (e.getSource() == ok){
                new ViewCliente(1);
                filtroTextfield.setText(null);
            }

            if (e.getSource() == filtrar){
                new ViewCliente(1);
            }

            if (e.getSource() == menu){
                new ViewMenu();
                janela.dispose();
            }
        }
    };

    public ViewEstoque(){

        dadosTabela = new MTableMovel(ControlEstoque.tabelaMovel());
        tabelaMovel.setModel(dadosTabela);
        scroll.setViewportView(tabelaMovel);

        dadosTabela2 = new MTableEletro(ControlEstoque.tabelaEletro());
        tabelaEletro.setModel(dadosTabela2);
        scroll2.setViewportView(tabelaEletro);

        janela.setLayout(null);
        janela.setSize(1135, 590);
        janela.setLocationRelativeTo(null);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);

        //FUNCAO QUE CHAMA SO BOTOES
        painelBotoes();

        //LABEL DA LOGO
        logoJanela.setIcon(new ImageIcon("src/images/logo2Pombo.png"));
        logoJanela.setBounds(475, 25, 175, 175);

        //PANEL DA TABELA movel
        painelMovel.setLayout(new GridLayout());
        painelMovel.setBorder(BorderFactory.createLineBorder(new Color(101, 1, 154), 5));
        painelMovel.setBounds(655, 25, 450, 510);
        painelMovel.add(scroll);

        //DEFINIÇÕES DA TABELA MOVEL

        scroll.setBackground(new Color(101, 240, 154));
        tabelaMovel.removeMouseListener(click);
        tabelaMovel.getTableHeader().setReorderingAllowed(false);
        tabelaMovel.getTableHeader().setResizingAllowed(false);
        tabelaMovel.getTableHeader().setBackground(new Color(101, 240, 154));
        tabelaMovel.getTableHeader().setForeground(Color.black);
        tabelaMovel.getTableHeader().setFont(new Font("Consolas", Font.BOLD, 15));
        tabelaMovel.setSelectionBackground(new Color(250, 120, 154));
        tabelaMovel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaMovel.setFont(new Font("Consolas", Font.BOLD, 11));
        tabelaMovel.setBackground(new Color(218, 230, 233));
        tabelaMovel.setRowHeight(22);
        tabelaMovel.getColumnModel().getColumn(0).setPreferredWidth(5);
        tabelaMovel.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabelaMovel.getColumnModel().getColumn(2).setPreferredWidth(5);
        tabelaMovel.getColumnModel().getColumn(3).setPreferredWidth(40);
        tabelaMovel.getColumnModel().getColumn(4).setPreferredWidth(40);
        tabelaMovel.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        tabelaMovel.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        tabelaMovel.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        tabelaMovel.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        tabelaMovel.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        tabelaMovel.setFocusable(false);
        tabelaMovel.addMouseListener(click);

        //TITULO DA TABELA MOVEL
        listaMovel.setText("LISTA DE MOVEIS");
        listaMovel.setBounds(775, 2, 230, 25);
        listaMovel.setFont(new Font("Consolas", Font.ITALIC, 23));

        //PANEL DA TABELA ELETRODOMESTICO
        painelEletro.setLayout(new GridLayout());
        painelEletro.setBorder(BorderFactory.createLineBorder(new Color(101, 1, 154), 5));
        painelEletro.setBounds(15, 25, 450, 510);
        painelEletro.add(scroll2);

        //DEFINIÇÕES DA TABELA ELETRODOMESTICO
        scroll2.setBackground(new Color(101, 240, 154));
        tabelaEletro.removeMouseListener(click);
        tabelaEletro.getTableHeader().setReorderingAllowed(false);
        tabelaEletro.getTableHeader().setResizingAllowed(false);
        tabelaEletro.getTableHeader().setBackground(new Color(101, 240, 154));
        tabelaEletro.getTableHeader().setForeground(Color.black);
        tabelaEletro.getTableHeader().setFont(new Font("Consolas", Font.BOLD, 15));
        tabelaEletro.setSelectionBackground(new Color(250, 120, 154));
        tabelaEletro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaEletro.setFont(new Font("Consolas", Font.BOLD, 11));
        tabelaEletro.setBackground(new Color(218, 230, 233));
        tabelaEletro.setRowHeight(22);
        tabelaEletro.getColumnModel().getColumn(0).setPreferredWidth(5);
        tabelaEletro.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabelaEletro.getColumnModel().getColumn(2).setPreferredWidth(10);
        tabelaEletro.getColumnModel().getColumn(3).setPreferredWidth(30);
        tabelaEletro.getColumnModel().getColumn(4).setPreferredWidth(30);
        tabelaEletro.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        tabelaEletro.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        tabelaEletro.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        tabelaEletro.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        tabelaEletro.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        tabelaEletro.setFocusable(false);
        tabelaEletro.addMouseListener(click);

        //TITULO DA TABELA ELETRODOMESTICO
        listaEletro.setText("LISTA DE ELETRODOMESTICOS");
        listaEletro.setBounds(75, 2, 340, 25);
        listaEletro.setFont(new Font("Consolas", Font.ITALIC, 23));

     //DEFINICOES DA JANELA

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setIconImage(new ImageIcon("src/images/logoPombo.png").getImage());
        janela.getContentPane().setBackground(new Color(227, 176, 255));
        janela.setVisible(true);
        janela.setResizable(false);
        janela.add(logoJanela);
        janela.add(painelButtons);
        janela.add(listaMovel);
        janela.add(listaEletro);
        janela.add(painelMovel);
        janela.add(painelEletro);

}

    public void painelBotoes(){

        //DEFINICOES DO PAINEL
        painelButtons.setLayout(null);
        painelButtons.setBorder(BorderFactory.createLineBorder(new Color(101,1,154),5));
        painelButtons.setBounds(475,285, 170,250);
        painelButtons.setBackground(new Color(161,96,228));

        //BOTAO CADASTRAR
        cadastrarMovel.removeMouseListener(click);
        cadastrarMovel.setBounds(10,10, 150,50);
        cadastrarMovel.setIcon(new ImageIcon("src/images/novoButton.png"));
        cadastrarMovel.setFocusable(false);
        cadastrarMovel.addMouseListener(click);

        //BOTAO CADASTRAR
        cadastrarEletro.removeMouseListener(click);
        cadastrarEletro.setBounds(10,70, 150,50);
        cadastrarEletro.setIcon(new ImageIcon("src/images/novoButton.png"));
        cadastrarEletro.setFocusable(false);
        cadastrarEletro.addMouseListener(click);

        //BOTAO FILTRAR
        filtrar.removeMouseListener(click);
        filtrar.setBounds(10,130, 150,50);
        filtrar.setIcon(new ImageIcon("src/images/filtrarButton.png"));
        filtrar.setFocusable(false);
        filtrar.addMouseListener(click);

        //BOTAO MENU
        menu.removeMouseListener(click);
        menu.setBounds(10, 190, 150,50);
        menu.setIcon(new ImageIcon("src/images/menuButton.png"));
        menu.setFocusable(false);
        menu.addMouseListener(click);

        //ADICIONANDO OS BOTOES AO PAINEL
        painelButtons.add(cadastrarMovel);
        painelButtons.add(cadastrarEletro);
        painelButtons.add(filtrar);
        painelButtons.add(menu);

    }
}

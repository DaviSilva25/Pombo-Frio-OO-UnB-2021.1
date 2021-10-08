package view;

import controller.ControlEstoque;

import modelTables.MTableEletro;
import modelTables.MTableMovel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Classe View Estoque
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */
public class ViewEstoque {

    //DECLARACAO
    private static final JFrame janela = new JFrame("ESTOQUE");
    private static final JPanel painelMovel = new JPanel();
    private static final JPanel painelEletro = new JPanel();
    private static final JPanel painelButtons = new JPanel();
    private static final JButton ok = new JButton();
    private static final JButton menu = new JButton();
    private static final JButton filtrar = new JButton();
    private static final JButton cadastrarMovel = new JButton();
    private static final JButton cadastrarEletro = new JButton();
    private static final JLabel logoJanela = new JLabel();
    private static final JLabel listaMovel = new JLabel();
    private static final JLabel listaEletro = new JLabel();
    private static final JLabel labelFiltro = new JLabel("Digite um nome ou  um preco: ");
    private static final JTextField filtroTextfield = new JTextField();
    private static final JTable tabelaEletro = new JTable();
    private static final JTable tabelaMovel = new JTable();
    private static final JScrollPane scroll = new JScrollPane();
    private static final JScrollPane scroll2 = new JScrollPane();
    private static final MouseAdapter click = new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {

            //EVENTO CLIQUE NA TABELA MOVEL
            if(e.getClickCount() == 2 && e.getSource() == tabelaMovel) {
                new ViewDetalheMovel((String) tabelaMovel.getValueAt(tabelaMovel.getSelectedRow(),0), 1);
                janela.dispose();
            }
            //EVENTO CLIQUE BOTAO CADASTRAR MOVEL
            if(e.getSource() == cadastrarMovel){
                new ViewDetalheMovel("qualquer coisa",2);
                janela.dispose();
            }
            //EVENTO CLIQUE NA TABELA ELETRODOMESTICO
            if(e.getClickCount() == 2 && e.getSource() == tabelaEletro) {
                new ViewDetalheEletro((String) tabelaEletro.getValueAt(tabelaEletro.getSelectedRow(),0), 1);
                janela.dispose();
            }
            //EVENTO CLIQUE BOTAO CADASTRAR ELETRODOMESTICO
            if(e.getSource() == cadastrarEletro){
                new ViewDetalheEletro("",2);
                janela.dispose();
            }
            //EVENTO CLIQUE NO BOTAO OK
            if (e.getSource() == ok){
                new ViewEstoque(2);
                filtroTextfield.setText(null);
            }
            //EVENTO CLIQUE NO BOTAO FILTRAR
            if (e.getSource() == filtrar){
                new ViewEstoque(1);
            }
            //EVENTO CLIQUE NO BOTAO MENU
            if (e.getSource() == menu){
                new ViewMenu();
                janela.dispose();
            }
        }
    };
    /**
     * Construtor da classe ViewEstoque
     * 
     * @param a int que altera a forma que a janela sera apresentada.
     */
    public ViewEstoque(int a){

        //DADOS DAS TABELAS
        MTableMovel dadosTabela;
        MTableEletro dadosTabela2;

        // JANELA APOS FILTRO
        if(a == 1){
            //remove componentes remanescentes
            janela.remove(painelMovel);
            janela.remove(painelEletro);
            painelMovel.remove(scroll);
            painelEletro.remove(scroll2);

            ok.removeMouseListener(click);
            ok.setBounds(615,255, 30,25);
            ok.setIcon(new ImageIcon("src/images/OK.png"));
            ok.setFocusable(false);
            ok.addMouseListener(click);

            labelFiltro.setBounds(475,230, 180,30);
            filtroTextfield.setBounds(475,255, 135, 25);
            janela.add(ok);
            janela.add(labelFiltro);
            janela.add(filtroTextfield);

            //seta os dados da tabela movel
            dadosTabela = new MTableMovel(ControlEstoque.tabelaMovel());
            tabelaMovel.setModel(dadosTabela);
            scroll.setViewportView(tabelaMovel);
            //seta os dados da tabela eletrodomestico
            dadosTabela2 = new MTableEletro(ControlEstoque.tabelaEletro());
            tabelaEletro.setModel(dadosTabela2);
            scroll2.setViewportView(tabelaEletro);

            painelMovel.add(scroll);
            painelEletro.add(scroll2);
            filtroTextfield.setText(null);
        }

        // JANELA APOS OK
        else if(a == 2){
            //remove componentes remanescentes
            janela.remove(painelMovel);
            janela.remove(painelEletro);
            painelMovel.remove(scroll);
            painelEletro.remove(scroll2);
            janela.remove(ok);
            janela.remove(filtroTextfield);
            janela.remove(labelFiltro);

            //seta os dados da tabela movel
            dadosTabela = new MTableMovel(ControlEstoque.filtrarTabelaMovel(filtroTextfield.getText()));
            tabelaMovel.setModel(dadosTabela);
            scroll.setViewportView(tabelaMovel);
            //seta os dados da tabela eletrodomestico
            dadosTabela2 = new MTableEletro(ControlEstoque.filtrarTabelaEletro(filtroTextfield.getText()));
            tabelaEletro.setModel(dadosTabela2);
            scroll2.setViewportView(tabelaEletro);

            painelMovel.add(scroll);
            painelEletro.add(scroll2);
        }

        // JANELA PADRAO
        else {
            //remove componentes remanescentes
            janela.remove(painelMovel);
            janela.remove(painelEletro);
            painelMovel.remove(scroll);
            painelEletro.remove(scroll2);
            janela.remove(ok);
            janela.remove(filtroTextfield);
            janela.remove(labelFiltro);

            //seta os dados da tabela movel
            dadosTabela = new MTableMovel(ControlEstoque.tabelaMovel());
            tabelaMovel.setModel(dadosTabela);
            scroll.setViewportView(tabelaMovel);
            //seta os dados da tabela eletrodomestico
            dadosTabela2 = new MTableEletro(ControlEstoque.tabelaEletro());
            tabelaEletro.setModel(dadosTabela2);
            scroll2.setViewportView(tabelaEletro);

            painelMovel.add(scroll);
            painelEletro.add(scroll2);

        }

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
    
    /**
     * Metodo que organiza os botoes da classe ViewCliente em um Jpanel.
     */
    public void painelBotoes(){

        //DEFINICOES DO PAINEL
        painelButtons.setLayout(null);
        painelButtons.setBorder(BorderFactory.createLineBorder(new Color(101,1,154),5));
        painelButtons.setBounds(475,285, 170,250);
        painelButtons.setBackground(new Color(161,96,228));

        //BOTAO CADASTRAR MOVEL
        cadastrarMovel.removeMouseListener(click);
        cadastrarMovel.setBounds(10,10, 150,50);
        cadastrarMovel.setIcon(new ImageIcon("src/images/Movel.png"));
        cadastrarMovel.setFocusable(false);
        cadastrarMovel.addMouseListener(click);

        //BOTAO CADASTRAR ELETRODOMESTICO
        cadastrarEletro.removeMouseListener(click);
        cadastrarEletro.setBounds(10,70, 150,50);
        cadastrarEletro.setIcon(new ImageIcon("src/images/Eletrodomestico.png"));
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

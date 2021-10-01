package view;
import controller.ControlCliente;
import modelTables.MTableCliente;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewCliente{

    private static JPanel painel = new JPanel();
    private static JPanel painelButtons = new JPanel();
    private static JButton cadastrar = new JButton();
    private static JButton filtrar = new JButton();
    private static JButton menu = new JButton();
    private static JButton ok = new JButton("ok");
    private static JLabel listaCliente = new JLabel();
    private static JLabel logoJanela = new JLabel();
    private static JFrame janela = new JFrame("CLIENTE");
    private static JTextField filtroTextfield = new JTextField();
    private static JLabel labelFiltro = new JLabel("Digite o nome para o filtro: ");
    private static MTableCliente dadosTabela;
    private static JTable tabelaCliente = new JTable();
    private static JScrollPane scroll = new JScrollPane();
    private static MouseAdapter click = new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {

            if(e.getClickCount() == 2 && e.getSource() == tabelaCliente) {
                new ViewDetalheCliente((String) tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 1),1);
                janela.dispose();
            }

            if(e.getSource() == cadastrar){
                new ViewDetalheCliente("qualquercoisa",2);
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

    public ViewCliente(int a){

        if(a != 0){
            ok.addMouseListener(click);
            ok.setBounds(160,255, 30,25);
            labelFiltro.setBounds(15,230, 180,30);
            filtroTextfield.setBounds(15,255, 140, 25);
            janela.add(ok);
            janela.add(labelFiltro);
            janela.add(filtroTextfield);
            dadosTabela = new MTableCliente(ControlCliente.filtrarTabela(ControlCliente.getDadosR(), filtroTextfield.getText()));
            tabelaCliente.setModel(dadosTabela);
            scroll.setViewportView(tabelaCliente);
        }

        else {
            janela.remove(ok);
            janela.remove(filtroTextfield);
            janela.remove(labelFiltro);
            dadosTabela = new MTableCliente(ControlCliente.dadosTabela(ControlCliente.getDadosR()));
            tabelaCliente.setModel(dadosTabela);
            scroll.setViewportView(tabelaCliente);
        }

            janela.setLayout(null);
            janela.setSize(800, 525);
            janela.setLocationRelativeTo(null);
            scroll.setBackground(new Color(101, 240, 154));

            //FUNCAO QUE CHAMA SO BOTOES
            painelBotoes();

            //LABEL DA LOGO
            logoJanela.setIcon(new ImageIcon("src/images/logo2Pombo.png"));
            logoJanela.setBounds(15, 25, 175, 175);

            //PANEL DA TABELA
            painel.setLayout(new GridLayout());
            painel.setBorder(BorderFactory.createLineBorder(new Color(101, 1, 154), 5));
            painel.setBounds(200, 25, 570, 450);
            painel.add(scroll);

            //DEFINIÇÕES DA TABELA
            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(JLabel.CENTER);
            tabelaCliente.removeMouseListener(click);
            tabelaCliente.getTableHeader().setReorderingAllowed(false);
            tabelaCliente.getTableHeader().setResizingAllowed(false);
            tabelaCliente.getTableHeader().setBackground(new Color(101, 240, 154));
            tabelaCliente.getTableHeader().setForeground(Color.black);
            tabelaCliente.getTableHeader().setFont(new Font("Consolas", Font.BOLD, 15));
            tabelaCliente.setSelectionBackground(new Color(250, 120, 154));
            tabelaCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tabelaCliente.setFont(new Font("Consolas", Font.BOLD, 11));
            tabelaCliente.setBackground(new Color(218, 230, 233));
            tabelaCliente.setRowHeight(22);
            tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(10);
            tabelaCliente.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
            tabelaCliente.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
            tabelaCliente.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
            tabelaCliente.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
            tabelaCliente.setFocusable(false);
            tabelaCliente.addMouseListener(click);

            //TITULO DA LISTA
            listaCliente.setText("LISTA DE CLIENTES");
            listaCliente.setBounds(372, 2, 230, 25);
            listaCliente.setFont(new Font("Consolas", Font.ITALIC, 23));

            //DEFINICOES DA JANELA
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setIconImage(new ImageIcon("src/images/logoPombo.png").getImage());
            janela.getContentPane().setBackground(new Color(227, 176, 255));
            janela.setVisible(true);
            janela.setResizable(false);
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
        cadastrar.addMouseListener(click);

        //BOTAO FILTRAR
        filtrar.setBounds(10,70, 150,50);
        filtrar.setIcon(new ImageIcon("src/images/filtrarButton.png"));
        filtrar.setFocusable(false);
        filtrar.addMouseListener(click);

        //BOTAO MENU
        menu.removeMouseListener(click);
        menu.setBounds(10, 130, 150,50);
        menu.setIcon(new ImageIcon("src/images/menuButton.png"));
        menu.setFocusable(false);
        menu.addMouseListener(click);

        //ADICIONANDO OS BOTOES AO PAINEL
        painelButtons.add(cadastrar);
        painelButtons.add(filtrar);
        painelButtons.add(menu);

    }

}




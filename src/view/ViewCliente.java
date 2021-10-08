package view;
import controller.ControlCliente;
import modelTables.MTableCliente;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewCliente{
    //DECLARACAO
    private static final JFrame janela = new JFrame("CLIENTE");
    private static final JPanel painel = new JPanel();
    private static final JPanel painelButtons = new JPanel();
    private static final JButton ok = new JButton();
    private static final JButton menu = new JButton();
    private static final JButton filtrar = new JButton();
    private static final JButton cadastrar = new JButton();
    private static final JLabel logoJanela = new JLabel();
    private static final JLabel labelFiltro = new JLabel("Digite um nome ou um cpf: ");
    private static final JLabel listaCliente = new JLabel();
    private static final JScrollPane scroll = new JScrollPane();
    private static final JScrollPane scroll2 = new JScrollPane();
    private static final JTextField filtroTextfield = new JTextField();
    private static final JTable tabelaCliente = new JTable();
    private static final MouseAdapter click = new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
            //CLIQUE NA TABELA
            if(e.getClickCount() == 2 && e.getSource() == tabelaCliente) {
                new ViewDetalheCliente((String) tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 1),1);
                janela.dispose();
            }
            //BOTAO CADASTRAR
            if(e.getSource() == cadastrar){
                new ViewDetalheCliente("",2);
                janela.dispose();
            }
            //BOTAO OK
            if (e.getSource() == ok){
                new ViewCliente(2);
                filtroTextfield.setText(null);
            }
            //BOTAO FILTRAR
            if (e.getSource() == filtrar){
                new ViewCliente(1);
            }
            //BOTAO VOLTAR
            if (e.getSource() == menu){
                new ViewMenu();
                janela.dispose();
            }
        }
    };

    public ViewCliente(int a){

        // JANELA APOS FILTRO
        MTableCliente dadosTabela2;
        if(a == 1){
            //remove componentes remanescentes da janela
            janela.remove(painel);
            painel.remove(scroll);
            painel.remove(scroll2);

            ok.removeMouseListener(click);
            ok.setBounds(155,255, 30,25);
            ok.setIcon(new ImageIcon("src/images/OK.png"));
            ok.setFocusable(false);
            ok.addMouseListener(click);
            labelFiltro.setBounds(15,230, 180,30);
            filtroTextfield.setBounds(15,255, 135, 25);

            janela.add(ok);
            janela.add(labelFiltro);
            janela.add(filtroTextfield);

            //seta os dados da tabela de clientes
            dadosTabela2 = new MTableCliente(ControlCliente.dadosTabela(ControlCliente.getDadosR()));
            filtroTextfield.setText(null);
            tabelaCliente.setModel(dadosTabela2);
            scroll2.setViewportView(tabelaCliente);
            painel.add(scroll2);
        }

        // JANELA APOS OK
        else if(a == 2){

            //remove componentes remanescentes da janela
            janela.remove(painel);
            painel.remove(scroll2);
            painel.remove(scroll);
            janela.remove(ok);
            janela.remove(filtroTextfield);
            janela.remove(labelFiltro);

            //seta os dados da tabela de clientes
            dadosTabela2 = new MTableCliente(ControlCliente.filtrarTabela(ControlCliente.getDadosR(), filtroTextfield.getText()));
            tabelaCliente.setModel(dadosTabela2);
            scroll2.setViewportView(tabelaCliente);
            painel.add(scroll2);
        }

        // JANELA PADRAO
        else {
            //remove componentes remanescentes da janela
            janela.remove(painel);
            painel.remove(scroll);
            painel.remove(scroll2);
            janela.remove(ok);
            janela.remove(filtroTextfield);
            janela.remove(labelFiltro);

            //seta os dados da tabela de clientes
            MTableCliente dadosTabela = new MTableCliente(ControlCliente.dadosTabela(ControlCliente.getDadosR()));
            tabelaCliente.setModel(dadosTabela);
            scroll.setViewportView(tabelaCliente);
            painel.add(scroll);

        }

            janela.setLayout(null);
            janela.setSize(800, 525);
            janela.setLocationRelativeTo(null);
            scroll.setBackground(new Color(101, 240, 154));
            scroll2.setBackground(new Color(101, 240, 154));

            //FUNCAO QUE CHAMA SO BOTOES
            painelBotoes();

            //LABEL DA LOGO
            logoJanela.setIcon(new ImageIcon("src/images/logo2Pombo.png"));
            logoJanela.setBounds(15, 25, 175, 175);

            //PANEL DA TABELA
            painel.setLayout(new GridLayout());
            painel.setBorder(BorderFactory.createLineBorder(new Color(101, 1, 154), 5));
            painel.setBounds(200, 25, 570, 450);

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
        cadastrar.removeMouseListener(click);
        cadastrar.setBounds(10,10, 150,50);
        cadastrar.setIcon(new ImageIcon("src/images/novoButton.png"));
        cadastrar.setFocusable(false);
        cadastrar.addMouseListener(click);

        //BOTAO FILTRAR
        filtrar.removeMouseListener(click);
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




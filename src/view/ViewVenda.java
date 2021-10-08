package view;

import controller.ControlVenda;
import modelTables.MtableVenda;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewVenda {

    private static final JFrame janela = new JFrame("VENDA");
    private static final JPanel painel = new JPanel();
    private static final JPanel painelButtons = new JPanel();
    private static final JButton cadastrar = new JButton();
    private static final JButton filtrar = new JButton();
    private static final JButton menu = new JButton();
    private static final JButton ok = new JButton();
    private static final JLabel listaCliente = new JLabel();
    private static final JLabel logoJanela = new JLabel();
    private static final JTextField filtroTextfield = new JTextField();
    private static final JLabel labelFiltro = new JLabel("Digite Nome ou CPF do cliente");
    private static final JLabel labelFiltro2 = new JLabel("ou um Codigo de venda: ");
    private static final JTable tabelaVenda = new JTable();
    private static final JScrollPane scroll = new JScrollPane();
    private static final JScrollPane scroll2 = new JScrollPane();
    private static final MouseAdapter click = new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {

            //evento clique na tabela venda
            if(e.getClickCount() == 2 && e.getSource() == tabelaVenda) {
                new ViewDetalheVenda((String) tabelaVenda.getValueAt(tabelaVenda.getSelectedRow(), 0),1);
                janela.dispose();
            }
            //evento clique no botao cadastrar
            if(e.getSource() == cadastrar){
                new ViewDetalheVenda("a",2);
                janela.dispose();
            }
            //eventro clique no botao filtrar
            if (e.getSource() == filtrar){
                new ViewVenda(1);
            }
            //evento clique no botao ok
            if (e.getSource() == ok){
                new ViewVenda(2);
                filtroTextfield.setText(null);
            }
            //evento clique no botao menu
            if (e.getSource() == menu){
                new ViewMenu();
                janela.dispose();
            }
        }
    };

    public ViewVenda(int a){

        //dados da tabela venda
        MtableVenda dadosTabela2;

        // JANELA APOS FILTRO
        if(a == 1){
            //remove os componentes remanescentes da janela
            janela.remove(painel);
            painel.remove(scroll2);
            painel.remove(scroll);

            ok.removeMouseListener(click);
            ok.setBounds(155,255, 30,25);
            ok.setIcon(new ImageIcon("src/images/OK.png"));
            ok.setFocusable(false);
            ok.addMouseListener(click);

            labelFiltro.setBounds(15,215, 180,30);
            labelFiltro2.setBounds(15,230, 180,30);
            filtroTextfield.setBounds(15,255, 135, 25);

            janela.add(ok);
            janela.add(labelFiltro);
            janela.add(labelFiltro2);
            janela.add(filtroTextfield);

            //seta os dados da tabela venda
            dadosTabela2 = new MtableVenda(ControlVenda.dadosTabela());
            filtroTextfield.setText(null);
            tabelaVenda.setModel(dadosTabela2);
            scroll2.setViewportView(tabelaVenda);

            painel.add(scroll2);
        }

        // JANELA APOS OK
        else if(a == 2){
            //remove os componentes remanescentes da janela
            janela.remove(painel);
            painel.remove(scroll2);
            painel.remove(scroll);
            janela.remove(ok);
            janela.remove(filtroTextfield);
            janela.remove(labelFiltro);
            janela.remove(labelFiltro2);

            //seta os dados da tabela venda
            dadosTabela2 = new MtableVenda(ControlVenda.filtrarTabelaVenda(filtroTextfield.getText()));
            tabelaVenda.setModel(dadosTabela2);
            scroll2.setViewportView(tabelaVenda);

            painel.add(scroll2);
        }

        // JANELA PADRAO
        else {
            //remove os componentes remanescentes da janela
            janela.remove(painel);
            painel.remove(scroll);
            painel.remove(scroll2);
            janela.remove(ok);
            janela.remove(filtroTextfield);
            janela.remove(labelFiltro);
            janela.remove(labelFiltro2);

            //seta os dados da tabela venda
            MtableVenda dadosTabela = new MtableVenda(ControlVenda.dadosTabela());
            tabelaVenda.setModel(dadosTabela);
            scroll.setViewportView(tabelaVenda);

            painel.add(scroll);

        }
        //definicoes da janela        janela.setLayout(null);
        janela.setSize(930, 525);
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
        painel.setBounds(200, 25, 700, 450);

        //DEFINIÇÕES DA TABELA
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabelaVenda.removeMouseListener(click);
        tabelaVenda.getTableHeader().setReorderingAllowed(false);
        tabelaVenda.getTableHeader().setResizingAllowed(false);
        tabelaVenda.getTableHeader().setBackground(new Color(101, 240, 154));
        tabelaVenda.getTableHeader().setForeground(Color.black);
        tabelaVenda.getTableHeader().setFont(new Font("Consolas", Font.BOLD, 15));
        tabelaVenda.setSelectionBackground(new Color(250, 120, 154));
        tabelaVenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaVenda.setFont(new Font("Consolas", Font.BOLD, 11));
        tabelaVenda.setBackground(new Color(218, 230, 233));
        tabelaVenda.setRowHeight(22);
        tabelaVenda.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabelaVenda.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        tabelaVenda.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        tabelaVenda.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        tabelaVenda.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        tabelaVenda.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);
        tabelaVenda.setFocusable(false);
        tabelaVenda.addMouseListener(click);

        //TITULO DA LISTA
        listaCliente.setText("LISTA DE VENDAS");
        listaCliente.setBounds(450, 2, 230, 25);
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

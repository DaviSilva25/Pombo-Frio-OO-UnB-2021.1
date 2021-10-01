package view;

import controller.ControlCliente;
import controller.ControlEstoque;
import controller.ControlVenda;
import modelTables.MTableCliente;
import modelTables.MTableEletro;
import modelTables.MTableMovel;
import models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ViewDetalheVenda {

    //declaracoes
    private static String cpf = new String();
    private static List<String> produtos = new ArrayList<>();
    private static List<String> quant = new ArrayList<>();
    private static JFrame janela = new JFrame("VENDA");
    private static JFrame janela2 = new JFrame("CADASTRAR CLIENTE EM VENDA");
    private static JFrame janela3 = new JFrame("CADASTRAR PRODUTOS EM VENDA");
    private static JPanel painel = new JPanel();
    private static MTableCliente dadosTabela;
    private static JTable tabelaCliente = new JTable();
    private static JScrollPane scroll = new JScrollPane();
    private static JLabel listaCliente = new JLabel();
    private static JLabel logoJanela = new JLabel();
    private static JTextField clienteTextfield = new JTextField();
    private static JLabel labelFiltro = new JLabel("Digite o cpf do cliente que deseja atribuir a venda: ");
    private static JTextField quantTextfield = new JTextField();
    private static JLabel labelquant = new JLabel("Quantidade a ser adiconada: ");
    private static JTextField idTextfield = new JTextField();
    private static JLabel labelid = new JLabel("Digite o Id do produto: ");
    private static JButton ok = new JButton(">");
    private static JButton ok2 = new JButton(">");
    private static JButton concluir = new JButton("Concluir");

    private static JLabel listaMovel = new JLabel();
    private static JPanel painelMovel = new JPanel();
    private static MTableMovel dadosTabela1;
    private static JTable tabelaMovel = new JTable();
    private static JScrollPane scroll1 = new JScrollPane();

    private static JLabel listaEletro = new JLabel();
    private static JPanel painelEletro = new JPanel();
    private static MTableEletro dadosTabela2;
    private static JTable tabelaEletro = new JTable();
    private static JScrollPane scroll2 = new JScrollPane();

    //dados venda
    private static JLabel labelCodigoVenda = new JLabel("Codigo da venda: ");
    private static JTextField valorCodigaVenda = new JTextField();
    private static JLabel labelNome = new JLabel("Nome do cliente: ");
    private static JTextField valorNome = new JTextField();
    private static JLabel labelCPF = new JLabel("CPF do cliente: ");
    private static JTextField valorCPF = new JTextField();
    private static JLabel labelNomeLoja = new JLabel("Nome da loja: ");
    private static JTextField valorNomeLoja = new JTextField();
    private static JLabel labelCNPJ = new JLabel("CNPJ da loja: ");
    private static JTextField valorCNPJ = new JTextField();
    private static JLabel labelDataVenda = new JLabel("Data da venda: ");
    private static JTextField valorDataVenda = new JTextField();
    private static JLabel labelValorFinal = new JLabel("Valor final: ");
    private static JTextField valorFinal = new JTextField();
    private static JLabel labelFrete = new JLabel("Valor do frete: ");
    private static JTextField valorFrete = new JTextField();
    private static JLabel labelFormaPagamento = new JLabel("Forma pagamento: ");
    private static JTextField valorFormaPagamento = new JTextField();

    private static List<String> preencherVenda = new ArrayList<>();
    private static JButton menu = new JButton("Voltar");
    private static MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if(e.getSource() == menu) {
                new ViewVenda(0);
                janela.dispose();
            }
            if(e.getSource() == ok) {
                cpf = clienteTextfield.getText();
                new ViewDetalheVenda("a",3);
                janela2.dispose();
            }
            if(e.getSource() == ok2) {
                produtos.add(idTextfield.getText());
                quant.add(quantTextfield.getText());
                mensagemSucessoCadastroVenda();
            }
            if(e.getSource() == concluir) {
                try {
                    ControlVenda.novaVenda(cpf, produtos, quant);
                } catch (CloneNotSupportedException ex) {
                    ex.printStackTrace();
                }
                new ViewVenda(0);
                janela3.dispose();
            }
        }
    };

    //construtor para quando clicar na tabela
    public ViewDetalheVenda(String id, int controlador) {
        preencherVenda = ControlVenda.pegarDadosVenda(id);
        janela.setIconImage(new ImageIcon("src/images/logoPombo.png").getImage());
        janela.setLayout(null);
        janela.setVisible(true);
        janela.setResizable(false);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setBackground(new Color(227, 176, 255));
        janela.setSize(423, 460);
        janela.setLocationRelativeTo(null);
        //DADOS CLIENTE
        janelaVenda();


        if(controlador == 1){
            janela2.setVisible(false);
            janela3.setVisible(false);
            janela.setTitle("Detalhes do cliente");
            janela.remove(menu);

            valorCodigaVenda.setText(preencherVenda.get(0));
            valorNome.setText(preencherVenda.get(1));
            valorCPF.setText(preencherVenda.get(2));
            valorNomeLoja.setText(preencherVenda.get(3));
            valorCNPJ.setText(preencherVenda.get(4));
            valorDataVenda.setText(preencherVenda.get(5));
            valorFinal.setText(preencherVenda.get(6));
            valorFrete.setText(preencherVenda.get(7));
            valorFormaPagamento.setText(preencherVenda.get(8));


            menu.removeMouseListener(click);
            menu.setBounds(30, 353, 150, 50);
            //clienteButton.setIcon(cliente2);
            menu.setFocusable(false);
            menu.addMouseListener(click);
            janela.add(menu);

            preencherVenda.clear();

        }
        else if(controlador == 2){
            selecionaCliente();
        }
        else if(controlador == 3){
            selecionaProduto();
        }


    }

    public static void mensagemSucessoExclusao() {
        JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    public static void mensagemSucessoCadastroVenda() {
        JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    public static void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
                        + "Pode ter ocorrido um dos dois erros a seguir:  \n"
                        + "1. Nem todos os campos foram preenchidos \n"
                        + "2. CPF, DDD e telefone nao contem apenas numeros \n"
                        + "3  Nome e Nome do cartao nao contem apenas caracteres validos,", null,
                JOptionPane.ERROR_MESSAGE);
    }
    //metodo para pegar o dados digitados
    public static List<String> dadosDigitados(){
        List<String> dadosNovos = new ArrayList<>();
        dadosNovos.add(valorNome.getText());
        dadosNovos.add(valorCPF.getText());
        dadosNovos.add(valorNomeLoja.getText());
        dadosNovos.add(valorCNPJ.getText());
        dadosNovos.add(valorDataVenda.getText());
        dadosNovos.add(valorFinal.getText());
        dadosNovos.add(valorFrete.getText());
        dadosNovos.add(valorFormaPagamento.getText());

        return dadosNovos;
    }

    private void selecionaCliente(){
        dadosTabela = new MTableCliente(ControlCliente.dadosTabela(ControlCliente.getDadosR()));
        tabelaCliente.setModel(dadosTabela);
        scroll.setViewportView(tabelaCliente);
        scroll.setBackground(new Color(101, 240, 154));

        // PAINEL DA TABELA
        painel.setLayout(new GridLayout());
        painel.setBorder(BorderFactory.createLineBorder(new Color(101, 1, 154), 5));
        painel.setBounds(15,25, 550,450);
        painel.add(scroll);

        //TITULO DA LISTA
        listaCliente.setText("LISTA DE CLIENTES");
        listaCliente.setBounds(190,2, 230,25);
        listaCliente.setFont(new Font("Consolas", Font.ITALIC, 23));

        //DEFINIÇÕES DA TABELA
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabelaCliente.setRowSelectionAllowed(false);
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


        ok.removeMouseListener(click);
        ok.setBounds(170,500, 30,25);
        ok.addMouseListener(click);
        labelFiltro.setBounds(25,475, 300,30);
        clienteTextfield.setBounds(25,500, 140, 25);

        janela2.setVisible(true);
        janela.setVisible(false);
        janela3.setVisible(false);
        janela2.add(ok);
        janela2.add(labelFiltro);
        janela2.add(clienteTextfield);
        janela2.add(listaCliente);
        janela2.add(painel);
        janela2.setIconImage(new ImageIcon("src/images/logoPombo.png").getImage());
        janela2.setLayout(null);
        janela2.setResizable(false);
        janela2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela2.getContentPane().setBackground(new Color(227, 176, 255));
        janela2.setSize(595, 580);
        janela2.setLocationRelativeTo(null);

    }

    private void selecionaProduto(){

        dadosTabela1 = new MTableMovel(ControlEstoque.tabelaMovel());
        dadosTabela2 = new MTableEletro(ControlEstoque.tabelaEletro());
        tabelaMovel.setModel(dadosTabela1);
        scroll1.setViewportView(tabelaMovel);
        tabelaEletro.setModel(dadosTabela2);
        scroll2.setViewportView(tabelaEletro);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);

        //LABEL DA LOGO
        logoJanela.setIcon(new ImageIcon("src/images/logo2Pombo.png"));
        logoJanela.setBounds(475, 25, 175, 175);

        //PANEL DA TABELA movel
        painelMovel.setLayout(new GridLayout());
        painelMovel.setBorder(BorderFactory.createLineBorder(new Color(101, 1, 154), 5));
        painelMovel.setBounds(655, 25, 450, 510);
        painelMovel.add(scroll1);

        //DEFINIÇÕES DA TABELA MOVEL

        scroll1.setBackground(new Color(101, 240, 154));
        tabelaMovel.setRowSelectionAllowed(false);
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
        tabelaEletro.setRowSelectionAllowed(false);
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

        //TITULO DA TABELA ELETRODOMESTICO
        listaEletro.setText("LISTA DE ELETRODOMESTICOS");
        listaEletro.setBounds(75, 2, 340, 25);
        listaEletro.setFont(new Font("Consolas", Font.ITALIC, 23));

        //BOTAO CONCLUIR
        concluir.removeMouseListener(click);
        concluir.setBounds(485,330, 150,50);
        concluir.setFocusable(false);
        concluir.addMouseListener(click);

        ok2.addMouseListener(click);
        ok2.setBounds(620,290, 30,25);
        labelquant.setBounds(475,200, 175,25);
        quantTextfield.setBounds(475,230, 175,25);
        labelid.setBounds(475,260, 175,25);
        idTextfield.setBounds(475,290, 140,25);

        janela3.setVisible(true);
        janela.setVisible(false);
        janela2.setVisible(false);
        janela3.add(ok2);
        janela3.add(concluir);
        janela3.add(quantTextfield);
        janela3.add(labelquant);
        janela3.add(idTextfield);
        janela3.add(labelid);
        janela3.add(listaMovel);
        janela3.add(listaEletro);
        janela3.add(painelMovel);
        janela3.add(painelEletro);
        janela3.add(logoJanela);


        janela3.setIconImage(new ImageIcon("src/images/logoPombo.png").getImage());
        janela3.setLayout(null);
        janela3.setResizable(false);
        janela3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela3.getContentPane().setBackground(new Color(227, 176, 255));
        janela3.setSize(1135, 590);
        janela3.setLocationRelativeTo(null);
    }

    //metodo para organizar na janela os dados do cliente
    private void janelaVenda(){

        labelCodigoVenda.setBounds(20,20, 150,25);
        janela.add(labelCodigoVenda);

        valorCodigaVenda.setEditable(false);
        valorCodigaVenda.setBounds(180,20, 80,25);
        janela.add(valorCodigaVenda);
        valorCodigaVenda.setText(null);

        labelNome.setBounds(20,50, 150,25);
        janela.add(labelNome);

        valorNome.setEditable(false);
        valorNome.setBounds(180,50, 180,25);
        janela.add(valorNome);
        valorNome.setText(null);

        labelCPF.setBounds(20,80, 150,25);
        janela.add(labelCPF);

        valorCPF.setEditable(false);
        valorCPF.setBounds(180,80, 180,25);
        janela.add(valorCPF);
        valorCPF.setText(null);

        labelNomeLoja.setBounds(20,110, 150,25);
        janela.add(labelNomeLoja);

        valorNomeLoja.setEditable(false);
        valorNomeLoja.setBounds(180,110, 130,25);
        janela.add(valorNomeLoja);
        valorNomeLoja.setText(null);

        labelCNPJ.setBounds(20,140, 150,25);
        janela.add(labelCNPJ);

        valorCNPJ.setEditable(false);
        valorCNPJ.setBounds(180,140, 180,25);
        janela.add(valorCNPJ);
        valorCNPJ.setText(null);

        labelDataVenda.setBounds(20,170, 150,25);
        janela.add(labelDataVenda);

        valorDataVenda.setEditable(false);
        valorDataVenda.setBounds(180,170, 80,25);
        janela.add(valorDataVenda);
        valorDataVenda.setText(null);

        labelValorFinal.setBounds(20,200, 150,25);
        janela.add(labelValorFinal);

        valorFinal.setEditable(false);
        valorFinal.setBounds(180,200, 80,25);
        janela.add(valorFinal);
        valorFinal.setText(null);

        labelFrete.setBounds(20,230, 150,25);
        janela.add(labelFrete);

        valorFrete.setEditable(false);
        valorFrete.setBounds(180,230, 80,25);
        janela.add(valorFrete);
        valorFrete.setText(null);

        labelFormaPagamento.setBounds(20,260, 150,25);
        janela.add(labelFormaPagamento);

        valorFormaPagamento.setEditable(false);
        valorFormaPagamento.setBounds(180,260, 80,25);
        janela.add(valorFormaPagamento);
        valorFormaPagamento.setText(null);
    }

}

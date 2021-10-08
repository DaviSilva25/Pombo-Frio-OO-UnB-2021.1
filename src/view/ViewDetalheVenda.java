package view;

import controller.ControlCliente;
import controller.ControlEstoque;
import controller.ControlRegisto;
import controller.ControlVenda;
import modelTables.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ViewDetalheVenda {

    private static final JFrame janela = new JFrame("VENDA");
    private static final JFrame janela2 = new JFrame("CADASTRAR CLIENTE EM VENDA");
    private static final JFrame janela3 = new JFrame("CADASTRAR PRODUTOS EM VENDA");
    private static final JPanel painel = new JPanel();
    private static final JPanel painelVenda = new JPanel();
    private static final JPanel painelMovel = new JPanel();
    private static final JPanel painelEletro = new JPanel();
    private static final JTable tabelaCliente = new JTable();
    private static final JTable tabelaMovel = new JTable();
    private static final JTable tabelaEletro = new JTable();
    private static final JTable tabelaVenda = new JTable();
    private static final JLabel listaCliente = new JLabel();
    private static final JLabel listaMovel = new JLabel();
    private static final JLabel listaVenda = new JLabel();
    private static final JLabel listaEletro = new JLabel();
    private static final JLabel logoJanela = new JLabel();
    private static final JLabel labelFiltro = new JLabel("Digite o cpf do cliente que deseja atribuir a venda: ");
    private static final JLabel labelquant = new JLabel("Quantidade a ser adiconada: ");
    private static final JLabel labelid = new JLabel("Digite o Id do produto: ");
    private static final JTextField clienteTextfield = new JTextField();
    private static final JTextField quantTextfield = new JTextField();
    private static final JTextField idTextfield = new JTextField();
    private static final JButton ok = new JButton();
    private static final JButton ok2 = new JButton();
    private static final JButton concluir = new JButton();
    private static final JButton menu = new JButton();
    private static final JScrollPane scroll = new JScrollPane();
    private static final JScrollPane scroll1 = new JScrollPane();
    private static final JScrollPane scroll2 = new JScrollPane();
    private static final JScrollPane scroll3 = new JScrollPane();

    //Labels e textfields para detalhes da venda
    private static final JLabel labelCodigoVenda = new JLabel("Codigo da venda: ");
    private static final JLabel labelNome = new JLabel("Nome do cliente: ");
    private static final JLabel labelCPF = new JLabel("CPF do cliente: ");
    private static final JLabel labelNomeLoja = new JLabel("Nome da loja: ");
    private static final JLabel labelCNPJ = new JLabel("CNPJ da loja: ");
    private static final JLabel labelDataVenda = new JLabel("Data da venda: ");
    private static final JLabel labelValorFinal = new JLabel("Valor final (R$): ");
    private static final JLabel labelFrete = new JLabel("Valor do frete (R$): ");
    private static final JLabel labelFormaPagamento = new JLabel("Forma pagamento: ");
    private static final JTextField valorCodigaVenda = new JTextField();
    private static final JTextField valorNome = new JTextField();
    private static final JTextField valorCPF = new JTextField();
    private static final JTextField valorNomeLoja = new JTextField();
    private static final JTextField valorCNPJ = new JTextField();
    private static final JTextField valorDataVenda = new JTextField();
    private static final JTextField valorFinal = new JTextField();
    private static final JTextField valorFrete = new JTextField();
    private static final JTextField valorFormaPagamento = new JTextField();
    private static boolean clickcount;



    private static final MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if(e.getSource() == menu) {
                new ViewVenda(0);
                janela.dispose();
            }
            if(e.getSource() == ok) {
                String cpf = clienteTextfield.getText();

                if(ControlRegisto.VerificarVenda(cpf,"","",0) == 0){
                    ControlVenda.novaVenda(cpf);
                    new ViewDetalheVenda("a",3);
                    clienteTextfield.setText(null);
                    janela2.dispose();
                }
                else {
                    mensagemErroCPF();
                    clienteTextfield.setText(null);
                }
            }
            if(e.getSource() == ok2) {
                String quant = quantTextfield.getText();
                String produtos = idTextfield.getText();

                if(ControlRegisto.VerificarVenda("",quant, produtos,1) == 0){
                    idTextfield.setText(null);
                    quantTextfield.setText(null);

                    try {
                        ControlVenda.addVenda(quant, produtos);
                    } catch (CloneNotSupportedException ex) {
                        ex.printStackTrace();
                    }
                    clickcount = true;
                    mensagemSucessoCadastro1();
                    new ViewDetalheVenda("",3);
                }
                else {
                    mensagemErroProduto();
                    idTextfield.setText(null);
                    quantTextfield.setText(null);
                }

            }
            if(e.getSource() == concluir) {
                if(clickcount == true){
                    ControlVenda.finalizaVenda();
                    mensagemSucessoCadastro();
                    clickcount = false;
                    new ViewVenda(0);
                    janela3.dispose();

                }
                else {
                    mensagemErroVenda();
                }
            }
        }
    };

    //construtor para quando clicar na tabela
    public ViewDetalheVenda(String id, int controlador) {

        List<String> preencherVenda = ControlVenda.pegarDadosVenda(id);
        janela.setIconImage(new ImageIcon("src/images/logoPombo.png").getImage());
        janela.setLayout(null);
        janela.setResizable(false);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setBackground(new Color(227, 176, 255));
        janela.setSize(825, 425);
        janela.setLocationRelativeTo(null);
        //DADOS CLIENTE
        janelaVenda();


        if(controlador == 1){
            janela2.setVisible(false);
            janela3.setVisible(false);
            janela.setVisible(true);
            MTableProdutos dadosTabela = new MTableProdutos(ControlVenda.dadosTabela2(id));
            janela.setTitle("Detalhes da venda");
            janela.remove(menu);


            //TITULO DA TABELA DE PRODUTOS COMPRADOS
            listaVenda.setText("LISTA DE PRODUTOS COMPRADOS");
            listaVenda.setBounds(417, 20, 400, 25);
            listaVenda.setFont(new Font("Consolas", Font.ITALIC, 23));

            //TABELA DE PRODUTOS COMPRADOS
            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(JLabel.CENTER);
            tabelaVenda.setModel(dadosTabela);
            tabelaVenda.setRowSelectionAllowed(false);
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
            tabelaVenda.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabelaVenda.getColumnModel().getColumn(2).setPreferredWidth(30);
            tabelaVenda.getColumnModel().getColumn(3).setPreferredWidth(35);
            tabelaVenda.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
            tabelaVenda.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
            tabelaVenda.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
            tabelaVenda.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
            tabelaVenda.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
            tabelaVenda.setFocusable(false);
            scroll3.setViewportView(tabelaVenda);


            painelVenda.setLayout(new GridLayout());
            painelVenda.setBorder(BorderFactory.createLineBorder(new Color(101, 1, 154), 5));
            painelVenda.setBounds(390,50, 400,235);
            painelVenda.add(scroll3);

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
            menu.setBounds(315, 315, 150, 50);
            menu.setIcon(new ImageIcon("src/images/voltar.png"));
            menu.setFocusable(false);
            menu.addMouseListener(click);
            janela.add(menu);
            janela.add(painelVenda);
            janela.add(listaVenda);

            preencherVenda.clear();

        }
        else if(controlador == 2){
            selecionaCliente();
        }

        else if(controlador == 3){
            selecionaProduto();
        }


    }

    private void selecionaCliente(){
        MTableCliente dadosTabela = new MTableCliente(ControlCliente.dadosTabela(ControlCliente.getDadosR()));
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
        ok.setIcon(new ImageIcon("src/images/OK.png"));
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

        MTableMovel dadosTabela1 = new MTableMovel(ControlEstoque.tabelaMovel());
        MTableEletro dadosTabela2 = new MTableEletro(ControlEstoque.tabelaEletro());
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
        concluir.setBounds(485,460, 150,50);
        concluir.setIcon(new ImageIcon("src/images/salvar.png"));
        concluir.setFocusable(false);
        concluir.addMouseListener(click);

        ok2.removeMouseListener(click);
        ok2.setBounds(620,310, 30,25);
        ok2.setIcon(new ImageIcon("src/images/OK.png"));
        ok2.addMouseListener(click);
        labelquant.setBounds(475,220, 175,25);
        quantTextfield.setBounds(475,250, 175,25);
        labelid.setBounds(475,280, 175,25);
        idTextfield.setBounds(475,310, 140,25);

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

    private static void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    private static void mensagemSucessoCadastro1() {
        JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    private static void mensagemErroVenda() {
        JOptionPane.showMessageDialog(null,
                "NAO FORAM ADICIONADOS PRODUTOS NA VENDA!", null,
                JOptionPane.ERROR_MESSAGE);
    }

    private static void mensagemErroCPF() {
        JOptionPane.showMessageDialog(null,
                "CPF INVALIDO OU INEXISTENTE!", null,
                JOptionPane.ERROR_MESSAGE);
    }
    private static void mensagemErroProduto() {
        JOptionPane.showMessageDialog(null,
                "ERRO AO ADICIONAR PRODUTO!\n" +
                        "Pode ter ocorrido algum dos erros a seguir: \n"+
                        "1. Ha campos vazios.\n"+
                        "2. Nao foi digitado um valor positivo para quantidade \n"+
                        "3. A quantidade digitada excede a quantidade em estoque.\n"+
                        "4. O id digitados nao existe.\n"+
                        "5. Nao foram digitados apenas numeros para quantidade ou id.", null,
                JOptionPane.ERROR_MESSAGE);
    }

}

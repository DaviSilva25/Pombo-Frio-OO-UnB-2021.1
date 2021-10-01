package view;

import controller.ControlCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class ViewDetalheCliente {
    //dados cliente
    private static JFrame janela = new JFrame();
    private static JLabel labelNome = new JLabel("Nome: ");
    private static JTextField valorNome = new JTextField();
    private static JLabel labelCPF = new JLabel("CPF: ");
    private static JTextField valorCPF = new JTextField();
    private static JLabel labelDataNasc = new JLabel("Data de nascimento: ");
    private static JTextField valorDataNasc = new JTextField();
    //dados telefone
    private static JLabel labelTelefone = new JLabel("Telefone: ");
    private static JTextField valorDDD = new JTextField();
    private static JTextField valorTelefone = new JTextField();
    //dados endereco
    private static JLabel labelEndereco = new JLabel("Endereco: ");
    private static JLabel labelUF = new JLabel("UF: ");
    private static JTextField valorUF = new JTextField();
    private static JLabel labelCidade = new JLabel("Cidade: ");
    private static JTextField valorCidade = new JTextField();
    private static JLabel labelBairro = new JLabel("Bairro: ");
    private static JTextField valorBairro = new JTextField();
    private static JLabel labelLogradouro = new JLabel("Logradouro: ");
    private static JTextField valorLogradouro = new JTextField();
    //dados cartao
    private static JLabel labelCartao = new JLabel("Cartao: ");
    private static JLabel labelNomeCartao = new JLabel("Nome no cartao: ");
    private static JTextField valorNomeCartao = new JTextField();
    private static JLabel labelNumero = new JLabel("Numero do cartao: ");
    private static JTextField valorNumero = new JTextField();
    private static JLabel labelCVV = new JLabel("CVV: ");
    private static JTextField valorCVV = new JTextField();
    private static JLabel labelDataVenc = new JLabel("Data de vencimento: ");
    private static JTextField valorDataVenc = new JTextField();
    //DECLARACAO
    private static List<String> preencherCliente = new ArrayList<>();
    private static JButton salvar = new JButton("Salvar");
    private static JButton salvar2 = new JButton("Salvar");
    private static JButton excluir = new JButton("Excluir");
    private static JButton cancelar = new JButton("Cancelar");
    private static MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if(e.getSource() == salvar) {
                ControlCliente.alterarDadosCliente(ControlCliente.getDadosR(), valorCPF.getText(), ViewDetalheCliente.dadosDigitados());
                new ViewCliente(0);
                janela.dispose();
            }
            if(e.getSource() == salvar2) {
                ControlCliente.adicionarCliente(dadosDigitados());
                new ViewCliente(0);
                janela.dispose();
            }
            if(e.getSource() == cancelar) {
                new ViewCliente(0);
                janela.dispose();
            }
            if(e.getSource() == excluir){
                ControlCliente.excluirCliente(ControlCliente.getDadosR(), valorCPF.getText(), ViewDetalheCliente.dadosDigitados());
                new ViewCliente(0);
                janela.dispose();
            }
        }
    };

    //construtor para quando clicar na tabela
    public ViewDetalheCliente(String cpf, int controlador) {
        preencherCliente = ControlCliente.pegarDadosCliente(ControlCliente.getDadosR(), cpf);
        janela.setIconImage(new ImageIcon("src/images/logoPombo.png").getImage());
        janela.setLayout(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setBackground(new Color(227, 176, 255));
        janela.setSize(423, 460);
        janela.setLocationRelativeTo(null);
        //DADOS CLIENTE
        janelaCliente();
        //TELEFONE
        janelaTelefone();
        //ENDERECO
        janelaEndereco();
        //CARTAO
        janelaCartao();

        if(controlador == 1){
           janela.setTitle("Detalhes do cliente");
           janela.remove(salvar2);
           janela.remove(cancelar);
           valorNome.setText(preencherCliente.get(0));
           valorCPF.setText(preencherCliente.get(1));
           valorDataNasc.setText(preencherCliente.get(2));

           valorDDD.setText(preencherCliente.get(3));
           valorTelefone.setText(preencherCliente.get(4));

           valorUF.setText(preencherCliente.get(5));
           valorCidade.setText(preencherCliente.get(6));
           valorBairro.setText(preencherCliente.get(7));
           valorLogradouro.setText(preencherCliente.get(8));

           valorNomeCartao.setText(preencherCliente.get(9));
           valorNumero.setText(preencherCliente.get(10));
           valorDataVenc.setText(preencherCliente.get(11));
           valorCVV.setText(preencherCliente.get(12));

           salvar.removeMouseListener(click);
           salvar.setBounds(30, 353, 150, 50);
           //clienteButton.setIcon(cliente2);
           salvar.setFocusable(false);
           salvar.addMouseListener(click);
           janela.add(salvar);

           excluir.removeMouseListener(click);
           excluir.setBounds(225, 353, 150, 50);
           //clienteButton.setIcon(cliente2);
           excluir.setFocusable(false);
           excluir.addMouseListener(click);
           janela.add(excluir);

           preencherCliente.clear();

       }
       else if(controlador == 2){
           janela.setTitle("Cadastrar novo cliente");
           janela.remove(salvar);
           janela.remove(excluir);
           valorCPF.setEditable(true);
           dadosDigitados();

           salvar2.removeMouseListener(click);
           salvar2.setBounds(30, 353, 150, 50);
           //clienteButton.setIcon(cliente2);
           salvar2.setFocusable(false);
           salvar2.addMouseListener(click);
           janela.add(salvar2);

           cancelar.removeMouseListener(click);
           cancelar.setBounds(225, 353, 150, 50);
           //clienteButton.setIcon(cliente2);
           cancelar.setFocusable(false);
           cancelar.addMouseListener(click);
           janela.add(cancelar);
       }


    }

    public void mensagemSucessoExclusao() {
        JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    public void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    public void mensagemErroCadastro() {
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
        dadosNovos.add(valorDataNasc.getText());
        dadosNovos.add(valorDDD.getText());
        dadosNovos.add(valorTelefone.getText());
        dadosNovos.add(valorUF.getText());
        dadosNovos.add(valorCidade.getText());
        dadosNovos.add(valorBairro.getText());
        dadosNovos.add(valorLogradouro.getText());
        dadosNovos.add(valorNomeCartao.getText());
        dadosNovos.add(valorNumero.getText());
        dadosNovos.add(valorDataVenc.getText());
        dadosNovos.add(valorCVV.getText());

        return dadosNovos;
    }

    //metodo para organizar na janela os dados do cliente
    private void janelaCliente(){

        labelNome.setBounds(20,20, 150,25);
        janela.add(labelNome);

        valorNome.setBounds(180,20, 210,25);
        janela.add(valorNome);
        valorNome.setText(null);

        labelCPF.setBounds(20,50, 150,25);
        janela.add(labelCPF);

        valorCPF.setEditable(false);
        valorCPF.setBounds(180,50, 130,25);
        janela.add(valorCPF);
        valorCPF.setText(null);

        labelDataNasc.setBounds(20,80, 150,25);
        janela.add(labelDataNasc);

        valorDataNasc.setBounds(180,80, 130,25);
        janela.add(valorDataNasc);
        valorDataNasc.setText(null);
    }

    //metodo para organizar na janela o telefone do cliente
    private void janelaTelefone(){

        labelTelefone.setBounds(20,110, 150,25);
        janela.add(labelTelefone);

        valorDDD.setBounds(180,110, 33,25);
        janela.add(valorDDD);
        valorDDD.setText(null);

        valorTelefone.setBounds(215,110, 95,25);
        janela.add(valorTelefone);
        valorTelefone.setText(null);
    }

    //metodo para organizar na janela o endereco do cliente
    private void janelaEndereco(){

        labelEndereco.setBounds(20,150, 150,25);
        janela.add(labelEndereco);

        labelUF.setBounds(150,150,28,25);
        janela.add(labelUF);

        valorUF.setBounds(180,150, 33,25);
        janela.add(valorUF);
        valorUF.setText(null);

        labelCidade.setBounds(225,150, 58,25);
        janela.add(labelCidade);

        valorCidade.setBounds(275,150, 115,25);
        janela.add(valorCidade);
        valorCidade.setText(null);

        labelBairro.setBounds(129,180, 58,25);
        janela.add(labelBairro);

        valorBairro.setBounds(180,180, 210,25);
        janela.add(valorBairro);
        valorBairro.setText(null);

        labelLogradouro.setBounds(99,210, 78,25);
        janela.add(labelLogradouro);


        valorLogradouro.setBounds(180,210, 210,25);
        janela.add(valorLogradouro);
        valorLogradouro.setText(null);
    }

    //metodo para organizar na janela o cartao do cliente
    private void janelaCartao(){

        labelCartao.setBounds(20, 250, 150, 25);
        janela.add(labelCartao);

        labelNomeCartao.setBounds(75,250, 100, 25);
        janela.add(labelNomeCartao);

        valorNomeCartao.setBounds(180,250, 210,25);
        janela.add(valorNomeCartao);
        valorNomeCartao.setText(null);

        labelNumero.setBounds(63,280, 150,25);
        janela.add(labelNumero);

        valorNumero.setBounds(180,280, 210,25);
        janela.add(valorNumero);
        valorNumero.setText(null);

        labelDataVenc.setBounds(53,310, 150,25);
        janela.add(labelDataVenc);

        valorDataVenc.setBounds(180,310, 110,25);
        janela.add(valorDataVenc);
        valorDataVenc.setText(null);

        labelCVV.setBounds(300,310, 48,25);
        janela.add(labelCVV);

        valorCVV.setBounds(342,310, 48,25);
        janela.add(valorCVV);
        valorCVV.setText(null);
    }

}

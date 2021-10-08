package view;

import controller.ControlCliente;
import controller.ControlRegistro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe View Detalhe do Cliente
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */
public class ViewDetalheCliente {

    //dados cliente
    private static final JLabel labelNome = new JLabel("Nome: ");
    private static final JLabel labelCPF = new JLabel("CPF: ");
    private static final JLabel labelDataNasc = new JLabel("Data de nascimento: ");
    private static final JTextField valorNome = new JTextField();
    private static final JTextField valorCPF = new JTextField();
    private static final JTextField valorDataNasc = new JTextField();
    //dados telefone
    private static final JLabel labelTelefone = new JLabel("Telefone: ");
    private static final JTextField valorDDD = new JTextField();
    private static final JTextField valorTelefone = new JTextField();
    //dados endereco
    private static final JLabel labelEndereco = new JLabel("Endereco: ");
    private static final JLabel labelUF = new JLabel("UF: ");
    private static final JLabel labelCidade = new JLabel("Cidade: ");
    private static final JLabel labelBairro = new JLabel("Bairro: ");
    private static final JLabel labelLogradouro = new JLabel("Logradouro: ");
    private static final JTextField valorUF = new JTextField();
    private static final JTextField valorCidade = new JTextField();
    private static final JTextField valorBairro = new JTextField();
    private static final JTextField valorLogradouro = new JTextField();
    //dados cartao
    private static final JLabel labelCartao = new JLabel("Cartao: ");
    private static final JLabel labelNomeCartao = new JLabel("Nome no cartao: ");
    private static final JLabel labelNumero = new JLabel("Numero do cartao: ");
    private static final JLabel labelCVV = new JLabel("CVV: ");
    private static final JLabel labelDataVenc = new JLabel("Data de vencimento: ");
    private static final JTextField valorNomeCartao = new JTextField();
    private static final JTextField valorNumero = new JTextField();
    private static final JTextField valorCVV = new JTextField();
    private static final JTextField valorDataVenc = new JTextField();
    //DECLARACAO
    private static final JFrame janela = new JFrame();
    private static final JButton salvar = new JButton();
    private static final JButton salvar2 = new JButton();
    private static final JButton excluir = new JButton();
    private static final JButton cancelar = new JButton();
    private static final MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            //SALVAR MUDANCAS EM UM CLIENTE EXISTENTE
            if(e.getSource() == salvar) {
                //verificacao dos dados digitados
                if (ControlRegistro.verificarCliente(dadosDigitados(),1) == 0
                        && (ControlRegistro.verificarCartao(dadosDigitados()) == 0
                        ||  ControlRegistro.verificarCartao(dadosDigitados()) == 4)){

                    ControlCliente.alterarDadosCliente(ControlCliente.getDadosR(), valorCPF.getText(), ViewDetalheCliente.dadosDigitados());
                    mensagemSucessoCadastro();
                }
                else {
                    mensagemErroCadastro();
                }
                new ViewCliente(0);
                janela.dispose();
            }

            //SALVAR NOVO CLIENTE
            if(e.getSource() == salvar2) {
                //verificacao dos dados digitados
                if (ControlRegistro.verificarCliente(dadosDigitados(),0) == 0
                && (ControlRegistro.verificarCartao(dadosDigitados()) == 0
                ||  ControlRegistro.verificarCartao(dadosDigitados()) == 4)){

                    ControlCliente.adicionarCliente(dadosDigitados());
                    mensagemSucessoCadastro1();
                }
                else {
                    mensagemErroCadastro();
                }
                new ViewCliente(0);
                janela.dispose();
            }
            //CANCELAR CADASTRO
            if(e.getSource() == cancelar) {
                new ViewCliente(0);
                janela.dispose();
            }
            //EXCLUIR CLIENTE
            if(e.getSource() == excluir){
                ControlCliente.excluirCliente(ControlCliente.getDadosR(), valorCPF.getText());
                mensagemSucessoExclusao();
                new ViewCliente(0);
                janela.dispose();
            }
        }
    };

    /**
     * Construtor da ViewDetalheCliente
     * 
     * @param cpf String que serve para localizar o cliente que foi selecionado na Jtable.
     * @param controlador int que altera a forma que a janela sera apresentada. 
     */
    //construtor para quando clicar na tabela
    public ViewDetalheCliente(String cpf, int controlador) {

        //preenche a lista de String com dados do cliente com o cpf passado no parametro do construtor
        List<String> preencherCliente = ControlCliente.pegarDadosCliente(ControlCliente.getDadosR(), cpf);

        janela.setIconImage(new ImageIcon("src/images/logoPombo.png").getImage());
        janela.setLayout(null);
        janela.setVisible(true);
        janela.setResizable(false);
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

        //JANELA DE DETALHE DO CLIENTE
        if(controlador == 1){

           janela.setTitle("Detalhes do cliente");
           janela.remove(salvar2);
           janela.remove(cancelar);
           //CLIENTE DADOS
           valorNome.setText(preencherCliente.get(0));
           valorCPF.setText(preencherCliente.get(1));
           valorDataNasc.setText(preencherCliente.get(2));
           //CLIENTE TELEFONE
           valorDDD.setText(preencherCliente.get(3));
           valorTelefone.setText(preencherCliente.get(4));
           //CLIENTE ENDERECO
           valorUF.setText(preencherCliente.get(5));
           valorCidade.setText(preencherCliente.get(6));
           valorBairro.setText(preencherCliente.get(7));
           valorLogradouro.setText(preencherCliente.get(8));
           //CLIENTE CARTAO
           valorNomeCartao.setText(preencherCliente.get(9));
           valorNumero.setText(preencherCliente.get(10));
           valorDataVenc.setText(preencherCliente.get(11));
           valorCVV.setText(preencherCliente.get(12));

           //BOTAO SALVAR MUDANCAS
           salvar.removeMouseListener(click);
           salvar.setBounds(30, 353, 150, 50);
           salvar.setIcon(new ImageIcon("src/images/Salvar.png"));
           salvar.setFocusable(false);
           salvar.addMouseListener(click);
           janela.add(salvar);

           //BOTAO EXCLUIR CLIENTE
           excluir.removeMouseListener(click);
           excluir.setBounds(225, 353, 150, 50);
           excluir.setIcon(new ImageIcon("src/images/Excluir.png"));
           excluir.setFocusable(false);
           excluir.addMouseListener(click);
           janela.add(excluir);

           //LIMPA A LISTA PARA O PROXIMO CLIENTE
           preencherCliente.clear();

       }
        //JANELA CADASTRO DE NOVO CLIENTE
        else if(controlador == 2){

           janela.setTitle("Cadastrar novo cliente");
           janela.remove(salvar);
           janela.remove(excluir);

           valorCPF.setEditable(true);

           //PREENCHE O CLIENTE COM OS DADOS DOS TEXTFIELDS
           dadosDigitados();

           //BOTAO SALVAR NOVO CLIENTE
           salvar2.removeMouseListener(click);
           salvar2.setBounds(30, 353, 150, 50);
           salvar2.setIcon(new ImageIcon("src/images/Salvar.png"));
           salvar2.setFocusable(false);
           salvar2.addMouseListener(click);
           janela.add(salvar2);

           //BOTAO CANCELAR CADASTRO DE NOVO CLIENTE
           cancelar.removeMouseListener(click);
           cancelar.setBounds(225, 353, 150, 50);
           cancelar.setIcon(new ImageIcon("src/images/Cancelar.png"));
           cancelar.setFocusable(false);
           cancelar.addMouseListener(click);
           janela.add(cancelar);
        }


    }
    
    /**
     * Metodo que adiciona os dados digitados nos JtextFields da ViewDetalheCliente em uma lista
     * de Strings para uso posterior na ControlCliente.
     * 
     * @return a lista de Strings com os dados dos JtextFields da ViewDetalheCliente.
     */
    //metodo para pegar o dados digitados nos textfields
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
    
    /**
     * Metodo para organizar os labels e textfields da ViewDetalheCliente
     */
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
    
    /**
     * Metodo para organizar os labels e textfields da ViewDetalheCliente
     */
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
    
    /**
     * Metodo para organizar os labels e textfields da ViewDetalheCliente
     */
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
    
    /**
     * Metodo para organizar os labels e textfields da ViewDetalheCliente
     */
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
    
    /**
     * Metodo que exibe uma mensagem de sucesso apos uma excluisao de cliente.
     */
    private static void mensagemSucessoExclusao() {
        JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }
    
    /**
     * Metodo que exibe uma mensagem de sucesso apos uma alteracao em um cliente.
     */
    private static void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }
    
    /**
     * Metodo que exibe uma mensagem de sucesso apos um cadastro de cliente.
     */
    private static void mensagemSucessoCadastro1() {
        JOptionPane.showMessageDialog(null, "Novo cliente salvo com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }
    
    /**
     * Metodo que exibe uma mensagem de erro caso alguma irregularidade tenha ocorrido.
     */
    private static void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null,
                "ERRO AO SALVAR OS DADOS!\n" +
                        "Pode ter ocorrido algum dos erros a seguir: \n"+
                        "1. Ha campos obrigatorios que nao foram preenchidos.\n"+
                        "2. Nome nao possui apenas letras e espaço como caracteres. \n"+
                        "3. CPF nao possui apenas numeros, ja existe algum cpf igual ou nao possui 11 caracteres.\n"+
                        "4. DDD nao possui apenas numeros ou nao possui 3 caracteres.\n"+
                        "5. Numero nao possui apenas numeros ou nao possui 9 caracteres.\n"+
                        "6. O UF digitado nao existe em territorio nacional.\n"+
                        "7. Cartao possui no maximo 3 campos preenchidos, deve ter 4 ou nenhum.", null,
                JOptionPane.ERROR_MESSAGE);
    }
}

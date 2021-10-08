package view;

import controller.ControlLoja;
import controller.ControlRegisto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ViewLoja {

    //dados Loja
    private static final JFrame janela = new JFrame("Loja");
    private static final JLabel labelNome = new JLabel("Nome:");
    private static final JLabel labelCNPJ = new JLabel("CNPJ: ");
    private static final JTextField valorNome = new JTextField();
    private static final JTextField valorCNPJ = new JTextField();
    //dados Telefone
    private static final JLabel labelTelefone = new JLabel("Telefone: ");
    private static final JTextField valorDDD = new JTextField();
    private static final JTextField valorTelefone = new JTextField();
    //dados Endereco
    private static final JLabel labelEndereco = new JLabel("Endereco: ");
    private static final JLabel labelUF = new JLabel("UF: ");
    private static final JLabel labelCidade = new JLabel("Cidade: ");
    private static final JLabel labelBairro = new JLabel("Bairro: ");
    private static final JLabel labelLogradouro = new JLabel("Logradouro: ");
    private static final JTextField valorUF = new JTextField();
    private static final JTextField valorCidade = new JTextField();
    private static final JTextField valorBairro = new JTextField();
    private static final JTextField valorLogradouro = new JTextField();
    //DECLARACAO
    private static List<String> dadosLoja = new ArrayList<>(ControlLoja.pegarDadosLoja());
    private static final JButton salvar = new JButton();
    private static final MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            //evento clique no botao salvar
            if(e.getSource() == salvar) {
                if(ControlRegisto.VerificarLoja(dadosDigitados()) == 0){
                    ControlLoja.alterarDadosLoja(dadosDigitados());
                    dadosLoja = dadosDigitados();
                    new ViewMenu();
                    janela.dispose();
                }
                else{
                    mensagemErroCadastro();
                    new ViewLoja();
                }
            }
        }
    };

    //metodo para organizar na janela os dados da loja
    public ViewLoja() {

        JLabel logoPanel = new JLabel();
        ImageIcon logo = new ImageIcon("src/images/pombo2.png");
        logoPanel.setIcon(logo);
        logoPanel.setBounds(55,20, 301,200);

        //CONFIGURACOES DA JANELA
        janela.setLayout(null);
        janela.setIconImage(new ImageIcon(("src/images/logoPombo.png")).getImage());
        janela.setVisible(true);
        janela.setResizable(false);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setBackground(new Color(227, 176, 255));
        janela.setSize(423, 540);
        janela.setLocationRelativeTo(null);
        janela.add(logoPanel);

        //BOTAO SALVAR
        salvar.removeMouseListener(click);
        salvar.setBounds(135, 433, 150, 50);
        salvar.setIcon(new ImageIcon("src/images/Salvar.png"));
        salvar.setFocusable(false);
        salvar.addMouseListener(click);
        janela.add(salvar);

        //DADOS DA LOJA
        labelNome.setBounds(20,230, 150, 25);
        janela.add(labelNome);
        valorNome.setBounds(180,230, 210,25);
        valorNome.setText(dadosLoja.get(0));
        valorNome.setEditable(false);
        janela.add(valorNome);

        labelCNPJ.setBounds(20,260, 150,25);
        janela.add(labelCNPJ);
        valorCNPJ.setBounds(180,260, 130,25);
        valorCNPJ.setText(dadosLoja.get(1));
        valorCNPJ.setEditable(false);
        janela.add(valorCNPJ);

        labelTelefone.setBounds(20,290, 150,25);
        janela.add(labelTelefone);
        valorDDD.setBounds(180,290, 33,25);
        valorDDD.setText(dadosLoja.get(2));
        janela.add(valorDDD);
        valorTelefone.setBounds(215,290, 95,25);
        valorTelefone.setText(dadosLoja.get(3));
        janela.add(valorTelefone);

        labelEndereco.setBounds(20,330, 150,25);
        janela.add(labelEndereco);

        labelUF.setBounds(150,330,28,25);
        janela.add(labelUF);
        valorUF.setBounds(180,330, 33,25);
        valorUF.setText(dadosLoja.get(4));
        janela.add(valorUF);

        labelCidade.setBounds(225,330, 58,25);
        janela.add(labelCidade);
        valorCidade.setBounds(275,330, 115,25);
        valorCidade.setText(dadosLoja.get(5));
        janela.add(valorCidade);

        labelBairro.setBounds(129,360, 58,25);
        janela.add(labelBairro);
        valorBairro.setBounds(180,360, 210,25);
        valorBairro.setText(dadosLoja.get(6));
        janela.add(valorBairro);

        labelLogradouro.setBounds(99,390, 78,25);
        janela.add(labelLogradouro);
        valorLogradouro.setBounds(180,390, 210,25);
        valorLogradouro.setText(dadosLoja.get(7));
        janela.add(valorLogradouro);
    }

    //metodo para pegar o dados digitados nos textfields
    public static List<String> dadosDigitados(){
        List<String> dadosNovos = new ArrayList<>();
        dadosNovos.add(valorNome.getText());
        dadosNovos.add(valorCNPJ.getText());
        dadosNovos.add(valorDDD.getText());
        dadosNovos.add(valorTelefone.getText());
        dadosNovos.add(valorUF.getText());
        dadosNovos.add(valorCidade.getText());
        dadosNovos.add(valorBairro.getText());
        dadosNovos.add(valorLogradouro.getText());

        return dadosNovos;
    }

    private static void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null,
                "ERRO AO SALVAR OS DADOS!\n" +
                        "Pode ter ocorrido algum dos erros a seguir: \n"+
                        "1. Ha campos obrigatorios que nao foram preenchidos.\n"+
                        "2. DDD nao possui apenas numeros ou nao possui 3 caracteres.\n"+
                        "3. Numero nao possui apenas numeros ou nao possui 9 caracteres.\n"+
                        "4. O UF digitado nao existe em territorio nacional.", null,
                JOptionPane.ERROR_MESSAGE);
    }
}

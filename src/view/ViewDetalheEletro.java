package view;

import controller.ControlEstoque;
import controller.ControlRegisto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ViewDetalheEletro {

    //labels e textfields de eletrodomesticos
    private static final JLabel labelId = new JLabel("ID do produto: ");
    private static final JLabel labelNome = new JLabel("Nome: ");
    private static final JLabel labelDescricao = new JLabel("Descricao: ");
    private static final JLabel labelPreco = new JLabel("Preco: ");
    private static final JLabel labelTamanho = new JLabel("Tamanho(m): ");
    private static final JLabel labelFabricante = new JLabel("Fabricante: ");
    private static final JLabel labelQuantidade = new JLabel("Quantidade: ");
    private static final JLabel labelCor = new JLabel("Cor: ");
    private static final JLabel labelCapacidade = new JLabel("Capacidade(L): ");
    private static final JLabel labelVoltagem = new JLabel("Voltagem(V): ");
    private static final JLabel labelPotencia = new JLabel("Potencia(W): ");
    private static final JTextField valorId = new JTextField();
    private static final JTextField valorNome = new JTextField();
    private static final JTextField valorDescricao = new JTextField();
    private static final JTextField valorCor = new JTextField();
    private static final JTextField valorPreco = new JTextField();
    private static final JTextField valorTamanho = new JTextField();
    private static final JTextField valorFabricante = new JTextField();
    private static final JTextField valorQuantidade = new JTextField();
    private static final JTextField valorCapacidade = new JTextField();
    private static final JTextField valorVoltagem = new JTextField();
    private static final JTextField valorPotencia = new JTextField();
    //DECLARACAO
    private static final JFrame janela = new JFrame();
    private static final JButton salvar = new JButton();
    private static final JButton salvar2 = new JButton();
    private static final JButton excluir = new JButton();
    private static final JButton cancelar = new JButton();
    private static final MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            //SALVAR MUDANÇAS EM UM ELETRODOMESTICO EXISTENTE
            if(e.getSource() == salvar) {

                //verificacao dos dados digitados
                if (ControlRegisto.VerificarEstoque(dadosDigitados(),1) == 0){

                    ControlEstoque.alterarDadosEletro(valorId.getText(), ViewDetalheEletro.dadosDigitados());
                    mensagemSucessoCadastro();
                }
                else {
                    mensagemErroCadastro();
                }
                new ViewEstoque(0);
                janela.dispose();
            }
            //SALVAR MUDANÇAS EM UM ELETRODOMESTICO NOVO
            if(e.getSource() == salvar2) {

                //verificacao dos dados digitados
                if (ControlRegisto.VerificarEstoque(dadosDigitados(),1) == 0){

                    ControlEstoque.adicionarEletro(dadosDigitados());
                    mensagemSucessoCadastro1();
                }
                else {
                    mensagemErroCadastro();
                }
                new ViewEstoque(0);
                janela.dispose();
            }
            //EXCLUIR ELETRODOMESTICO
            if(e.getSource() == excluir){

                ControlEstoque.excluirEletro(valorId.getText());
                mensagemSucessoExclusao();
                new ViewEstoque(0);
                janela.dispose();
            }
            //CANCELAR
            if(e.getSource() == cancelar) {

                new ViewEstoque(0);
                janela.dispose();
            }

        }
    };


    public ViewDetalheEletro(String id, int controlador){

        //preenche a lista de Strings com os dados do eletrodomestico que tem o id do parametro do construtor
        List<String> preencherEletro = ControlEstoque.pegarDadosEletro(id);

        janela.setIconImage(new ImageIcon("src/images/logoPombo.png").getImage());
        janela.setLayout(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setBackground(new Color(227, 176, 255));
        janela.setSize(375, 460);
        janela.setLocationRelativeTo(null);

        //Metodo para organizar os componetes da janela
        janelaEletrodomestico();

        //JANELA DETALHE DO ELETRODOMESTICO
        if(controlador == 1){

            janela.setTitle("Detalhes do eletrodomestico");
            janela.remove(salvar2);
            janela.remove(cancelar);

            //PREENCHE OS TEXFIELDS COM OS DADOS DA LISTA ANTERIOR
            valorId.setText(preencherEletro.get(0));
            valorNome.setText(preencherEletro.get(1));
            valorDescricao.setText(preencherEletro.get(2));
            valorCor.setText(preencherEletro.get(3));
            valorPreco.setText(preencherEletro.get(4));
            valorTamanho.setText(preencherEletro.get(5));
            valorFabricante.setText(preencherEletro.get(6));
            valorQuantidade.setText(preencherEletro.get(7));
            valorCapacidade.setText(preencherEletro.get(8));
            valorVoltagem.setText(preencherEletro.get(9));
            valorPotencia.setText(preencherEletro.get(10));

            //BOTAO SALVAR MUDANCAS ELETRODOMESTICO
            salvar.removeMouseListener(click);
            salvar.setBounds(20, 353, 150, 50);
            salvar.setIcon(new ImageIcon("src/images/Salvar.png"));
            salvar.setFocusable(false);
            salvar.addMouseListener(click);
            janela.add(salvar);

            //BOTAO EXCLUIR ELETRODOMESTICO
            excluir.removeMouseListener(click);
            excluir.setBounds(190, 353, 150, 50);
            excluir.setIcon(new ImageIcon("src/images/Excluir.png"));
            excluir.setFocusable(false);
            excluir.addMouseListener(click);
            janela.add(excluir);

            //LIMPA A LISTA DE ELETRODOMESTICOS PARA UM PROXIMO
            preencherEletro.clear();

        }
        //JANELA NOVO MOVEL
        else if(controlador == 2){

            janela.setTitle("Cadastrar novo eletrodomestico");
            janela.remove(salvar);
            janela.remove(excluir);

            //BOTAO SALVAR NOVO ELETRODOMESTICO
            salvar2.removeMouseListener(click);
            salvar2.setBounds(20, 353, 150, 50);
            salvar2.setIcon(new ImageIcon("src/images/Salvar.png"));
            salvar2.setFocusable(false);
            salvar2.addMouseListener(click);
            janela.add(salvar2);

            //BOTAO CANCELAR
            cancelar.removeMouseListener(click);
            cancelar.setBounds(190, 353, 150, 50);
            cancelar.setIcon(new ImageIcon("src/images/Cancelar.png"));
            cancelar.setFocusable(false);
            cancelar.addMouseListener(click);
            janela.add(cancelar);
        }


    }

    //metodo para pegar o dados digitados nos textfields
    public static List<String> dadosDigitados(){

        List<String> dadosNovos = new ArrayList<>();
        dadosNovos.add(valorId.getText());
        dadosNovos.add(valorNome.getText());
        dadosNovos.add(valorDescricao.getText());
        dadosNovos.add(valorCor.getText());
        dadosNovos.add(valorPreco.getText());
        dadosNovos.add(valorTamanho.getText());
        dadosNovos.add(valorFabricante.getText());
        dadosNovos.add(valorQuantidade.getText());
        dadosNovos.add(valorCapacidade.getText());
        dadosNovos.add(valorVoltagem.getText());
        dadosNovos.add(valorPotencia.getText());

        return dadosNovos;
    }

    //metodo para organizar na janela os dados do eletrodomestico
    private void janelaEletrodomestico(){

        labelId.setBounds(20,20, 150,25);
        janela.add(labelId);

        valorId.setEditable(false);
        valorId.setBounds(190,20, 50,25);
        janela.add(valorId);
        valorId.setText(null);

        labelNome.setBounds(20,50, 50,25);
        janela.add(labelNome);

        valorNome.setBounds(190,50, 150,25);
        janela.add(valorNome);
        valorNome.setText(null);

        labelDescricao.setBounds(20,80, 150,25);
        janela.add(labelDescricao);

        valorDescricao.setBounds(190,80, 150,25);
        janela.add(valorDescricao);
        valorDescricao.setText(null);

        labelCor.setBounds(20, 110, 150, 25);
        janela.add(labelCor);

        valorCor.setBounds(190, 110, 100, 25);
        janela.add(valorCor);
        valorCor.setText(null);

        labelPreco.setBounds(20,140, 150,25);
        janela.add(labelPreco);

        valorPreco.setBounds(190,140, 80,25);
        janela.add(valorPreco);
        valorPreco.setText(null);

        labelTamanho.setBounds(20,170, 150,25);
        janela.add(labelTamanho);

        valorTamanho.setBounds(190,170, 50,25);
        janela.add(valorTamanho);
        valorTamanho.setText(null);

        labelFabricante.setBounds(20,200, 150,25);
        janela.add(labelFabricante);

        valorFabricante.setBounds(190,200, 100,25);
        janela.add(valorFabricante);
        valorFabricante.setText(null);

        labelQuantidade.setBounds(20,230, 150,25);
        janela.add(labelQuantidade);

        valorQuantidade.setBounds(190,230, 50,25);
        janela.add(valorQuantidade);
        valorQuantidade.setText(null);

        labelCapacidade.setBounds(20, 260, 150, 25);
        janela.add(labelCapacidade);

        valorCapacidade.setBounds(190,260, 50,25);
        janela.add(valorCapacidade);
        valorCapacidade.setText(null);

        labelVoltagem.setBounds(20,290, 150,25);
        janela.add(labelVoltagem);

        valorVoltagem.setBounds(190,290, 50,25);
        janela.add(valorVoltagem);
        valorVoltagem.setText(null);

        labelPotencia.setBounds(20,320, 150,25);
        janela.add(labelPotencia);

        valorPotencia.setBounds(190,320, 50,25);
        janela.add(valorPotencia);
        valorPotencia.setText(null);
    }

    private static void mensagemSucessoExclusao() {
        JOptionPane.showMessageDialog(null, "Eletrodomestico excluido com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    private static void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Eletrodomestico salvo com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    private static void mensagemSucessoCadastro1() {
        JOptionPane.showMessageDialog(null, "Novo eletrodomestico salvo com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    private static void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null,
                        "ERRO AO SALVAR OS DADOS!\n" +
                        "Pode ter ocorrido algum dos erros a seguir: \n"+
                        "1. Ha campos obrigatorios que nao foram preenchidos.\n"+
                        "2. Cor nao possui apenas letras e espaço como caracteres. \n"+
                        "3. Preco nao possui apenas numeros.\n"+
                        "4. Tamanho nao possui apenas numeros.\n"+
                        "5. Quantidade nao possui apenas numeros.\n"+
                        "6. Capacidade nao possui apenas numeros.\n"+
                        "7. Voltagem nao possui apenas numeros.\n"+
                        "8. Potencia nao possui apenas numeros.", null,
                JOptionPane.ERROR_MESSAGE);
    }



}

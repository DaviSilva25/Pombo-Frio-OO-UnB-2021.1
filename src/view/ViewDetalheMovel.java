package view;

import controller.ControlEstoque;
import controller.ControlRegisto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ViewDetalheMovel {

    //labels e textfields de movel
    private static final JLabel labelId = new JLabel("ID do produto: ");
    private static final JLabel labelNome = new JLabel("Nome: ");
    private static final JLabel labelDescricao = new JLabel("Descricao: ");
    private static final JLabel labelCor = new JLabel("Cor: ");
    private static final JLabel labelPreco = new JLabel("Preco (R$): ");
    private static final JLabel labelTamanho = new JLabel("Tamanho (m): ");
    private static final JLabel labelFabricante = new JLabel("Fabricante: ");
    private static final JLabel labelQuantidade = new JLabel("Quantidade: ");
    private static final JLabel labelAmbiente = new JLabel("Ambiente: ");
    private static final JLabel labelMaterial = new JLabel("Material: ");
    private static final JTextField valorId = new JTextField();
    private static final JTextField valorNome = new JTextField();
    private static final JTextField valorDescricao = new JTextField();
    private static final JTextField valorCor = new JTextField();
    private static final JTextField valorPreco = new JTextField();
    private static final JTextField valorTamanho = new JTextField();
    private static final JTextField valorFabricante = new JTextField();
    private static final JTextField valorQuantidade = new JTextField();
    private static final JTextField valorAmbiente = new JTextField();
    private static final JTextField valorMaterial = new JTextField();

    //DECLARACAO
    private static final JFrame janela = new JFrame();
    private static final JButton salvar = new JButton();
    private static final JButton salvar2 = new JButton();
    private static final JButton excluir = new JButton();
    private static final JButton cancelar = new JButton();
    private static final MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            //SALVAR MUDANÇAS EM UM MOVEL EXISTENTE
            if(e.getSource() == salvar) {

                //verificacao dos dados digitados
                if (ControlRegisto.VerificarEstoque(dadosDigitados(),0) == 0){

                    ControlEstoque.alterarDadosMovel(valorId.getText(), ViewDetalheMovel.dadosDigitados());
                    mensagemSucessoCadastro();
                    new ViewEstoque(0);
                }
                else {
                    mensagemErroCadastro();
                    new ViewEstoque(0);
                }
                janela.dispose();
            }

            //SALVAR MUDANÇAS EM UM MOVEL NOVO
            if(e.getSource() == salvar2) {

                //verificacao dos dados digitados
                if (ControlRegisto.VerificarEstoque(dadosDigitados(),0) == 0){

                    ControlEstoque.adicionarMovel(dadosDigitados());
                    mensagemSucessoCadastro1();
                    new ViewEstoque(0);
                }
                else {
                    mensagemErroCadastro();
                    new ViewEstoque(0);
                }
                janela.dispose();
            }
            //EXCLUIR MOVEL
            if(e.getSource() == excluir){

                ControlEstoque.excluirMovel(valorId.getText());
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


    public ViewDetalheMovel(String id, int controlador){

        //preenche a lista de Strings com os dados do movel que tem o id do parametro do construtor
        List<String> preencherMovel = ControlEstoque.pegarDadosMovel(id);

        janela.setIconImage(new ImageIcon("src/images/logoPombo.png").getImage());
        janela.setLayout(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setBackground(new Color(227, 176, 255));
        janela.setSize(375, 460);
        janela.setLocationRelativeTo(null);

        //Metodo para organizar os componetes da janela
        janelaMovel();

        //JANELA DETALHE DO MOVEL
        if(controlador == 1){

            janela.setTitle("Detalhes do Movel");
            janela.remove(salvar2);
            janela.remove(cancelar);

            //PREENCHE OS TEXFIELDS COM OS DADOS DA LISTA ANTERIOR
            valorId.setText(preencherMovel.get(0));
            valorNome.setText(preencherMovel.get(1));
            valorDescricao.setText(preencherMovel.get(2));
            valorCor.setText(preencherMovel.get(3));
            valorPreco.setText(preencherMovel.get(4));
            valorTamanho.setText(preencherMovel.get(5));
            valorFabricante.setText(preencherMovel.get(6));
            valorQuantidade.setText(preencherMovel.get(7));
            valorAmbiente.setText(preencherMovel.get(8));
            valorMaterial.setText(preencherMovel.get(9));

            //BOTAO SALVAR MUDANCAS MOVEL
            salvar.removeMouseListener(click);
            salvar.setBounds(20, 353, 150, 50);
            salvar.setIcon(new ImageIcon("src/images/Salvar.png"));
            salvar.setFocusable(false);
            salvar.addMouseListener(click);
            janela.add(salvar);

            //BOTAO EXCLUIR MOVEL
            excluir.removeMouseListener(click);
            excluir.setBounds(190, 353, 150, 50);
            excluir.setIcon(new ImageIcon("src/images/Excluir.png"));
            excluir.setFocusable(false);
            excluir.addMouseListener(click);
            janela.add(excluir);

            //LIMPA A LISTA DE MOVEIS PARA UM PROXIMO
            preencherMovel.clear();

        }
        //JANELA NOVO ELETRODOMESTICO
        else if(controlador == 2){

            janela.setTitle("Cadastrar novo Movel");
            janela.remove(salvar);
            janela.remove(excluir);

            //BOTAO SALVAR NOVO MOVEL
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
        dadosNovos.add(valorAmbiente.getText());
        dadosNovos.add(valorMaterial.getText());

        return dadosNovos;
    }

    //metodo para organizar na janela os dados do movel
    private void janelaMovel(){

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

        labelAmbiente.setBounds(20, 260, 150, 25);
        janela.add(labelAmbiente);

        valorAmbiente.setBounds(190,260, 100,25);
        janela.add(valorAmbiente);
        valorAmbiente.setText(null);

        labelMaterial.setBounds(20,290, 150,25);
        janela.add(labelMaterial);

        valorMaterial.setBounds(190,290, 100,25);
        janela.add(valorMaterial);
        valorMaterial.setText(null);

    }

    private static void mensagemSucessoExclusao() {
        JOptionPane.showMessageDialog(null, "Movel excluido com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    private static void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Movel salvo com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    private static void mensagemSucessoCadastro1() {
        JOptionPane.showMessageDialog(null, "Novo movel salvo com sucesso!", null,
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
                        "5. Quantidade nao possui apenas numeros.", null,
                JOptionPane.ERROR_MESSAGE);
    }
}

package view;

import controller.ControlEstoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ViewDetalheEletro {

    private static JFrame janela = new JFrame();
    private static JLabel labelId = new JLabel("ID do produto: ");
    private static JTextField valorId = new JTextField();
    private static JLabel labelNome = new JLabel("Nome: ");
    private static JTextField valorNome = new JTextField();
    private static JLabel labelDescricao = new JLabel("Descricao: ");
    private static JTextField valorDescricao = new JTextField();
    private static JLabel labelCor = new JLabel("Cor: ");
    private static JTextField valorCor = new JTextField();
    private static JLabel labelPreco = new JLabel("*Preco: ");
    private static JTextField valorPreco = new JTextField();
    private static JLabel labelTamanho = new JLabel("Tamanho: ");
    private static JTextField valorTamanho = new JTextField();
    private static JLabel labelFabricante = new JLabel("Fabricante: ");
    private static JTextField valorFabricante = new JTextField();
    private static JLabel labelQuantidade = new JLabel("*Quantidade: ");
    private static JTextField valorQuantidade = new JTextField();
    //dados cartao
    private static JLabel labelCapacidade = new JLabel("Capacidade(L): ");
    private static JTextField valorCapacidade = new JTextField();
    private static JLabel labelVoltagem = new JLabel("Voltagem(V): ");
    private static JTextField valorVoltagem = new JTextField();
    private static JLabel labelPotencia = new JLabel("Potencia(W): ");
    private static JTextField valorPotencia = new JTextField();
    //DECLARACAO
    private static List<String> preencherEletro = new ArrayList<>();
    private static JButton salvar = new JButton("Salvar");
    private static JButton salvar2 = new JButton("Salvar");
    private static JButton excluir = new JButton("Excluir");
    private static JButton cancelar = new JButton("Cancelar");
    private static MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if(e.getSource() == salvar) {
                ControlEstoque.alterarDadosEletro(valorId.getText(), ViewDetalheEletro.dadosDigitados());
                new ViewEstoque();
                janela.dispose();
            }

            if(e.getSource() == excluir){
                ControlEstoque.excluirEletro(valorId.getText());
                new ViewEstoque();
                janela.dispose();
            }

            if(e.getSource() == salvar2) {
                ControlEstoque.adicionarEletro(dadosDigitados());
                new ViewEstoque();
                janela.dispose();
            }
            if(e.getSource() == cancelar) {
                new ViewEstoque();
                janela.dispose();
            }

        }
    };


    public ViewDetalheEletro(String id, int controlador){

        preencherEletro = ControlEstoque.pegarDadosEletro(id);
        janela.setIconImage(new ImageIcon("src/images/logoPombo.png").getImage());
        janela.setLayout(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setBackground(new Color(227, 176, 255));
        janela.setSize(375, 460);
        janela.setLocationRelativeTo(null);
        janelaEletrodomestico();
        janelaEletrodomestico2();

        if(controlador == 1){

            janela.setTitle("Detalhes do Movel");
            janela.remove(salvar2);
            janela.remove(cancelar);
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

            salvar.removeMouseListener(click);
            salvar.setBounds(20, 353, 150, 50);
            //clienteButton.setIcon(cliente2);
            salvar.setFocusable(false);
            salvar.addMouseListener(click);
            janela.add(salvar);

            excluir.removeMouseListener(click);
            excluir.setBounds(190, 353, 150, 50);
            //clienteButton.setIcon(cliente2);
            excluir.setFocusable(false);
            excluir.addMouseListener(click);
            janela.add(excluir);

            preencherEletro.clear();

        }
        else if(controlador == 2){
            janela.setTitle("Cadastrar novo cliente");
            janela.remove(salvar);
            janela.remove(excluir);
            //valorCPF.setEditable(true);
            //dadosDigitados();

            salvar2.removeMouseListener(click);
            salvar2.setBounds(20, 353, 150, 50);
            //clienteButton.setIcon(cliente2);
            salvar2.setFocusable(false);
            salvar2.addMouseListener(click);
            janela.add(salvar2);

            cancelar.removeMouseListener(click);
            cancelar.setBounds(190, 353, 150, 50);
            //clienteButton.setIcon(cliente2);
            cancelar.setFocusable(false);
            cancelar.addMouseListener(click);
            janela.add(cancelar);
        }


    }

    //metodo para pegar o dados digitados
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

    //metodo para organizar na janela os dados do cliente
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

        valorTamanho.setBounds(190,170, 100,25);
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
    }

    //metodo para organizar na janela o cartao do cliente
    private void janelaEletrodomestico2(){

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
}

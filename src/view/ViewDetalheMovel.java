package view;

import controller.ControlEstoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ViewDetalheMovel {
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
    private static JLabel labelAmbiente = new JLabel("Ambiente: ");
    private static JTextField valorAmbiente = new JTextField();
    private static JLabel labelMaterial = new JLabel("Material: ");
    private static JTextField valorMaterial = new JTextField();

    //DECLARACAO
    private static List<String> preencherMovel = new ArrayList<>();
    private static JButton salvar = new JButton("Salvar");
    private static JButton salvar2 = new JButton("Salvar");
    private static JButton excluir = new JButton("Excluir");
    private static JButton cancelar = new JButton("Cancelar");
    private static MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            if(e.getSource() == salvar) {
                ControlEstoque.alterarDadosMovel(valorId.getText(), ViewDetalheMovel.dadosDigitados());
                new ViewEstoque();
                janela.dispose();
            }

            if(e.getSource() == excluir){
                ControlEstoque.excluirMovel(valorId.getText());
                new ViewEstoque();
                janela.dispose();
            }

            if(e.getSource() == salvar2) {
                ControlEstoque.adicionarMovel(dadosDigitados());
                new ViewEstoque();
                janela.dispose();
            }
            if(e.getSource() == cancelar) {
                new ViewEstoque();
                janela.dispose();
            }

        }
    };


    public ViewDetalheMovel(String id, int controlador){

        preencherMovel = ControlEstoque.pegarDadosMovel(id);
        janela.setIconImage(new ImageIcon("src/images/logoPombo.png").getImage());
        janela.setLayout(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setBackground(new Color(227, 176, 255));
        janela.setSize(375, 460);
        janela.setLocationRelativeTo(null);
        janelaMovel();
        janelaMovel2();

        if(controlador == 1){

            janela.setTitle("Detalhes do Movel");
            janela.remove(salvar2);
            janela.remove(cancelar);
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

            preencherMovel.clear();

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
        dadosNovos.add(valorAmbiente.getText());
        dadosNovos.add(valorMaterial.getText());

        return dadosNovos;
    }

    //metodo para organizar na janela os dados do cliente
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
    private void janelaMovel2(){

        labelAmbiente.setBounds(20, 260, 150, 25);
        janela.add(labelAmbiente);

        valorAmbiente.setBounds(190,260, 50,25);
        janela.add(valorAmbiente);
        valorAmbiente.setText(null);

        labelMaterial.setBounds(20,290, 150,25);
        janela.add(labelMaterial);

        valorMaterial.setBounds(190,290, 50,25);
        janela.add(valorMaterial);
        valorMaterial.setText(null);

    }
}

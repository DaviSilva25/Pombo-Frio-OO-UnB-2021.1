package models;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;
/**
 * Classe modelo Venda
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */

public class Venda {

    //ATRIBUTOS PROPIOS
    private String codigoDeVenda;
    private String dataVenda = "";
    private double valorFinal = 0;
    private String formaDePagamento;
    private double frete;

    //ATRIBUTOS ASSOCIADOS
    private final Boleto boleto = new Boleto();
    private Cliente cliente;
    private final Loja loja;
    private final List<Movel> moveisVenda = new ArrayList<>();
    private final List<Eletrodomestico> eletrosVenda = new ArrayList<>();

    //VARIAVEIS AUXILIARES
    private static int setaVenda = 1;
    
    /**
     * Construtor de venda.
     * 
     * @param cliente Cliente que representa o cliente de venda.
     * @param loja Loja que representa a loja de venda.
     * @param formaDePagamento String que representa a forma de pagamendo de venda.
     */
    //CONSTRUTORES VENDA
    public Venda(Cliente cliente, Loja loja, String formaDePagamento) {
        this.cliente = cliente;
        this.loja = loja;
        this.setDataVenda();
        this.setFormaDePagamento(formaDePagamento);
        this.setFrete();
    }
    //METODO(SOBRECARREGADO) EM ADIOCIONAR(MOVEL OU ELETRODOMESTISCO) EM VENDA
    
    /**
     * Metodo que recebe um movel e uma quantidade, e apos isso adiciona
     * a quantidade do movel e o movel em uma venda.
     * 
     * @param movel Movel que representa o movel que ia ser adiconado na venda.
     * @param quantMovel int que representa a quantidade do movel a ser adicionada na venda.
     * @throws CloneNotSupportedException
     */
    public void adicionar(Movel movel, int quantMovel) throws CloneNotSupportedException {

        Movel movel1 = (Movel) movel.clone();
        movel1.setQuantidade(quantMovel);
        moveisVenda.add(movel1);
        movel.setQuantidade(movel.getQuantidade()-quantMovel);

        valorFinal += movel.getPreco()*quantMovel;
    }
    
    /**
     * Metodo que recebe um eletrodomestico e uma quantidade, e apos isso adiciona
     * a quantidade do eletrodomestico e o eletrodomestico em uma venda.
     * 
     * @param eletro Eletrodomestico que representa o eletrodomestico que ia ser adiconado na venda.
     * @param quantEletro int que representa a quantidade do eletrodomestico a ser adicionada na venda.
     * @throws CloneNotSupportedException
     */
    public void adicionar(Eletrodomestico eletro, int quantEletro) throws CloneNotSupportedException {

        Eletrodomestico eletro1 = (Eletrodomestico) eletro.clone();
        eletro1.setQuantidade(quantEletro);
        eletrosVenda.add(eletro1);
        eletro.setQuantidade(eletro.getQuantidade()-quantEletro);

        valorFinal += eletro.getPreco()*quantEletro;
    }

    //GETS E SETS
    public String getCodigoDeVenda() {
        return codigoDeVenda;
    }

    public void setCodigoDeVenda() {
        this.codigoDeVenda = "VN"+setaVenda+"DE"+(moveisVenda.size()+eletrosVenda.size());
        setaVenda +=1;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda() {
        dataVenda = (LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal() {
        this.valorFinal = valorFinal+getFrete();
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        if(formaDePagamento.equals("BOLETO"))
            this.formaDePagamento = boleto.toString();
        else
            this.formaDePagamento = cliente.getCartao().toString();
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete() {
        String D1 = cliente.getEndereco().getUf();

        String[]RCO = {"DF", "MT", "GO", "MS"};
        String[]RSD = {"SP", "RJ", "ES", "MG"};
        String[]RSU = {"SC", "PR", "SR"};
        String[]RND = {"PB", "MA", "CE", "PI", "RN", "PE", "AL", "SE", "BA"};
        List<String> centroOeste = new ArrayList<>(Arrays.asList(RCO));
        List<String> sudeste = new ArrayList<>(Arrays.asList(RSD));
        List<String> sul = new ArrayList<>(Arrays.asList(RSU));
        List<String> nordeste = new ArrayList<>(Arrays.asList(RND));

        if(centroOeste.contains(D1))
            this.frete = 10.50;
        else if(sudeste.contains(D1))
            this.frete = 17.50;
        else if(sul.contains(D1))
            this.frete = 32.50;
        else if(nordeste.contains(D1))
            this.frete = 29.50;
        else
            this.frete = 40.43;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Loja getLoja() {
        return loja;
    }

    public List<Movel> getMoveisVenda() {
        return moveisVenda;
    }

    public List<Eletrodomestico> getEletrosVenda() {
        return eletrosVenda;
    }
}

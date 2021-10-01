package models;
import java.util.*;
import java.time.LocalDate;

public class Venda {

    //ATRIBUTOS PROPIOS
    private String codigoDeVenda;
    private final List<LocalDate> dataVenda = new ArrayList<>();
    private double valorFinal = 0;
    private String formaDePagamento;
    private double frete;

    //ATRIBUTOS ASSOCIADOS
    private Boleto boleto = new Boleto();
    private Cliente cliente = new Cliente();
    private Loja loja = new Loja();
    private List<Movel> moveisVenda = new ArrayList<>();
    private List<Eletrodomestico> eletrosVenda = new ArrayList<>();

    //VARIAVEIS AUXILIARES
    private int contaQnt = 0;
    private static int setaVenda = 1;

    //CONSTRUTORES VENDA
    public Venda(Cliente cliente, Loja loja, String formaDePagamento) {
        this.cliente = cliente;
        this.loja = loja;
        this.setDataVenda();
        this.setFormaDePagamento(formaDePagamento);
        this.setFrete();
    }
    public Venda(){
        this.setDataVenda();
    }

    //METODO(SOBRECARREGADO) EM ADIOCIONAR(MOVEL OU ELETRODOMESTISCO) EM VENDA
    public void adicionar(Movel movel, int quantMovel) throws CloneNotSupportedException {

        Movel movel1 = (Movel) movel.clone();
        movel1.setQuantidade(quantMovel);
        moveisVenda.add(movel1);
        movel.setQuantidade(movel.getQuantidade()-quantMovel);

        valorFinal += movel.getPreco()*quantMovel;
        contaQnt += quantMovel;
    }
    public void adicionar(Eletrodomestico eletro, int quantEletro) throws CloneNotSupportedException {

        Eletrodomestico eletro1 = (Eletrodomestico) eletro.clone();
        eletro1.setQuantidade(quantEletro);
        eletrosVenda.add(eletro1);
        eletro.setQuantidade(eletro.getQuantidade()-quantEletro);

        valorFinal += eletro.getPreco()*quantEletro;
        contaQnt += quantEletro;
    }

    //GETS E SETS
    public String getCodigoDeVenda() {
        return codigoDeVenda;
    }

    public void setCodigoDeVenda() {
        this.codigoDeVenda = "VN"+setaVenda+"DE"+(moveisVenda.size()+eletrosVenda.size());
        setaVenda +=1;
    }

    public List<LocalDate> getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda() {
        dataVenda.add(LocalDate.now());
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

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public List<Movel> getMoveisVenda() {
        return moveisVenda;
    }

    public void setMoveisVenda(List<Movel> moveisVenda) {
        this.moveisVenda = moveisVenda;
    }

    public List<Eletrodomestico> getEletrosVenda() {
        return eletrosVenda;
    }

    public void setEletrosVenda(List<Eletrodomestico> eletrosVenda) {
        this.eletrosVenda = eletrosVenda;
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

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}

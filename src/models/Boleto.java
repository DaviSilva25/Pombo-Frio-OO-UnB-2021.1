package models;
import java.util.*;
public class Boleto {

    private Date dataVencimento;
    private String codigoDeBarra;

    public Boleto(Date dataVencimento, String codigoDeBarra) {
        this.dataVencimento = dataVencimento;
        this.codigoDeBarra = codigoDeBarra;
    }

    @Override
    public String toString() {
        return  " Boleto" + "\n" +
                " Data de Vencimento: " + dataVencimento + "\n" +
                " Codigo de Barra: " + codigoDeBarra + "\n";
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }
}

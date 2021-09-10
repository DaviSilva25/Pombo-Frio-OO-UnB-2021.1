package models;
import java.time.LocalDate;
import java.util.*;
public class Boleto {
    //ATRIBUTOS PROPIOS
    private final LocalDate[] dataVencimento = new LocalDate[20];
    private static int auxDv = 0;
    private final int[] codigoDeBarra = new int[20];
    private static int auxB = 0;

    //CONSTRUTOR BOLETO
    public Boleto() {
        this.setDataVencimento();
        this.setCodigoDeBarra();
    }

    @Override
    public String toString() {
        return  "Data de Vencimento:[" +dataVencimento[auxDv-1].getDayOfMonth()+"/"+dataVencimento[auxDv-1].getMonthValue()+"/"+dataVencimento[auxDv-1].getYear()+"] " +
                "Codigo de Barra:[" +codigoDeBarra[auxB-1]+ "]";
    }

    //GETS E SETS
    public LocalDate getDataVencimento() {
        return dataVencimento[auxDv];
    }

    public void setDataVencimento() {
        LocalDate d = LocalDate.now();
        LocalDate dv = LocalDate.from(d.plusMonths(1));
        this.dataVencimento[auxDv] = dv;
        auxDv += 1;
    }

    public int getCodigoDeBarra() {
        return codigoDeBarra[auxB];
    }

    public void setCodigoDeBarra() {
        Random random = new Random();
        this.codigoDeBarra[auxB] = random.nextInt(1000000000)+100000000;
        auxB += 1;
    }

}

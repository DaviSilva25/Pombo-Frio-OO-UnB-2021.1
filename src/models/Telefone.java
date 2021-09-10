package models;

public class Telefone {
    //ATRIBUTOS PROPIOS
    private String ddd;
    private String numero;

    //CONSTRUTORES TELEFONE
    public Telefone(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }
    public Telefone(){
    }

    @Override
    public String toString() {
        return  "(" +ddd+ ") " +numero;
    }

    //GETS E SETS
    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


}

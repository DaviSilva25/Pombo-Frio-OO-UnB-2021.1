package models;
/**
 * Classe modelo Telefone
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */
public class Telefone {
    //ATRIBUTOS PROPIOS
    private String ddd;
    private String numero;
    
    /**
     * Construtor de Telefone
     * 
     * @param ddd String que representa o ddd de Telefone.
     * @param numero String que representa o numero de Telefone.
     */
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

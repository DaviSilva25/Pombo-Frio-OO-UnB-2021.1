package controller;

import models.Registro;

public class ControlRegisto {
    private static Registro dados = new Registro();


    public ControlRegisto() throws CloneNotSupportedException {
        dados.autoCadastro();
    }



    //gets e sets
    public static Registro getDados() {
        return dados;
    }

    public void setDados(Registro dados) {
        this.dados = dados;
    }

}
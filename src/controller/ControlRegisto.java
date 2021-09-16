package controller;

import models.Registro;

public class ControlRegisto {
    private Registro dados = new Registro();

    public ControlRegisto() throws CloneNotSupportedException {
        dados.autoCadastro();
    }
    //gets e sets
    public Registro getDados() {
        return dados;
    }

    public void setDados(Registro dados) {
        this.dados = dados;
    }

}
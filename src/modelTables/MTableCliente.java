package modelTables;

import models.Telefone;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MTableCliente extends AbstractTableModel {

    private final String[] colunas = {"Nome", "CPF", "UF", "Telefone", "Tem cartao?"};
    private List<String[]> clienteDados;

    public MTableCliente(List<String[]> listaCli){
        Collections.sort(listaCli, new Comparator<String[]>() {
            @Override
            public int compare(String[] A, String[] B) {
                return A[0].compareTo(B[0]);
            }
        });

        clienteDados = listaCli;
    }


    @Override
    public int getRowCount() {
        return clienteDados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna){
            case 0 -> {
                return clienteDados.get(linha)[0];
            }
            case 1 -> {
                return clienteDados.get(linha)[1];
            }
            case 2 -> {
                return clienteDados.get(linha)[2];
            }
            case 3 -> {
                return clienteDados.get(linha)[3];
            }
            case 4 -> {
                return clienteDados.get(linha)[4];
            }
            default -> {
                return 0;
            }
        }
    }

    @Override
    public String getColumnName(int indice){
        return colunas[indice];
    }

    public Class getColClass(int coluna){
        switch (coluna){
            case 0, 1, 2 -> {
                return String.class;
            }
            default -> {
                return null;
            }

        }
    }







}

package modelTables;

import javax.swing.table.AbstractTableModel;
import java.util.Comparator;
import java.util.List;

public class MTableEletro extends AbstractTableModel {

    private final String[] colunas = {"ID", "Nome", "Preco R$", "Quantidade", "Volts(V)"};
    private static List<String[]> eletroDados;

    public MTableEletro(List<String[]> listaEletro){
        eletroDados = listaEletro;
    }

    @Override
    public int getRowCount() {
        return eletroDados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna){
            case 0 -> {
                return eletroDados.get(linha)[0];
            }
            case 1 -> {
                return eletroDados.get(linha)[1];
            }
            case 2 -> {
                return eletroDados.get(linha)[2];
            }
            case 3 -> {
                return eletroDados.get(linha)[3];
            }
            case 4 -> {
                return eletroDados.get(linha)[4];
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


}
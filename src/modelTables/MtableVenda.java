package modelTables;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MtableVenda extends AbstractTableModel {

    private final String[] colunas = {"ID venda", "Nome Cliente", "CPF Cliente", "Loja",
                                      "Data da venda", "Valor Final R$"};
    private static List<String[]> vendaDados;

    public MtableVenda(List<String[]> listaVenda){
        vendaDados = listaVenda;
    }

    @Override
    public int getRowCount() {
        return vendaDados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna){
            case 0 -> {
                return vendaDados.get(linha)[0];
            }
            case 1 -> {
                return vendaDados.get(linha)[1];
            }
            case 2 -> {
                return vendaDados.get(linha)[2];
            }
            case 3 -> {
                return vendaDados.get(linha)[3];
            }
            case 4 -> {
                return vendaDados.get(linha)[4];
            }
            case 5 -> {
                return vendaDados.get(linha)[5];
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

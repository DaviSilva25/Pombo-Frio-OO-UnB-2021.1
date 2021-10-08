package modelTables;

import javax.swing.table.AbstractTableModel;

import java.util.Comparator;
import java.util.List;
/**
 * Classe MTableModel Cliente
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */

@SuppressWarnings("serial")
public class MTableCliente extends AbstractTableModel {

    private final String[] colunas = {"Nome", "CPF", "UF", "Telefone", "Tem cartao?"};
    private static List<String[]> clienteDados;
    
    /**
     * Contrutor da MTableCliente
     * 
     * @param listaCli List<String[]> representa a lista de array de Strings que irao compor a tabela.
     */
    public MTableCliente(List<String[]> listaCli){
        listaCli.sort(Comparator.comparing(A -> A[0]));
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

}

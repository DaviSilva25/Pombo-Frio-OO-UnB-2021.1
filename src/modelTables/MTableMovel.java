package modelTables;

import javax.swing.table.AbstractTableModel;
import java.util.List;
/**
 * Classe MTableModel Movel
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */
@SuppressWarnings("serial")
public class MTableMovel extends AbstractTableModel {

    private final String[] colunas = {"ID", "Nome", "Preco R$", "Quantidade", "Cor"};
    private static List<String[]> movelDados;
    
    /**
     * Contrutor da MTableMovel
     * 
     * @param listaMovel List<String[]> representa a lista de array de Strings que irao compor a tabela.
     */
    public MTableMovel(List<String[]> listaMovel){
        movelDados = listaMovel;
    }

    @Override
    public int getRowCount() {
        return movelDados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna){
            case 0 -> {
                return movelDados.get(linha)[0];
            }
            case 1 -> {
                return movelDados.get(linha)[1];
            }
            case 2 -> {
                return movelDados.get(linha)[2];
            }
            case 3 -> {
                return movelDados.get(linha)[3];
            }
            case 4 -> {
                return movelDados.get(linha)[4];
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

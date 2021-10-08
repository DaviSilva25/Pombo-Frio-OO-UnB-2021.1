package modelTables;

import javax.swing.table.AbstractTableModel;
import java.util.Comparator;
import java.util.List;
/**
 * Classe MTableModel Produtos
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */
@SuppressWarnings("serial")
public class MTableProdutos extends AbstractTableModel {
    private final String[] colunas = {"ID", "Nome", "QTD", "Preco", "TIPO"};
    private static List<String[]> produtoDados;
    
    /**
     * Contrutor da MTableProdutos
     * 
     * @param lista List<String[]> representa a lista de array de Strings que irao compor a tabela.
     */
    public MTableProdutos(List<String[]> lista){
        lista.sort(Comparator.comparingInt(A -> Integer.parseInt(A[0])));
        produtoDados = lista;
    }

    @Override
    public int getRowCount() {
        return produtoDados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna){
            case 0 -> {
                return produtoDados.get(linha)[0];
            }
            case 1 -> {
                return produtoDados.get(linha)[1];
            }
            case 2 -> {
                return produtoDados.get(linha)[2];
            }
            case 3 -> {
                return produtoDados.get(linha)[3];
            }
            case 4 -> {
                return produtoDados.get(linha)[4];
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

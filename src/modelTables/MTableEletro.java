package modelTables;

import javax.swing.table.AbstractTableModel;
import java.util.List;
/**
 * Classe MTableModel Eletro
 * @author Davi e Karla
 * @version 1.0 (Oct/21)
 */
@SuppressWarnings("serial")
public class MTableEletro extends AbstractTableModel {

    private final String[] colunas = {"ID", "Nome", "Preco R$", "Quantidade", "Cor"};
    private static List<String[]> eletroDados;
    
    /**
     * Contrutor da MTableEletro
     * 
     * @param listaEletro List<String[]> representa a lista de array de Strings que irao compor a tabela.
     */
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
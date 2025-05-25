package Model.Film;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModelTable extends AbstractTableModel {
    List<ModelFilm> daftarFilm;

    String kolom[] = {"ID", "Judul", "Alur", "Penokohan", "Akting", "Rating"};
    public ModelTable(List<ModelFilm> daftarFilm) {
        this.daftarFilm = daftarFilm;
    }

    @Override
    public int getRowCount() {
        return daftarFilm.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarFilm.get(rowIndex).getId();
            case 1:
                return daftarFilm.get(rowIndex).getJudul();
            case 2:
                return daftarFilm.get(rowIndex).getAlur();
            case 3:
                return daftarFilm.get(rowIndex).getPenokohan();
            case 4:
                return daftarFilm.get(rowIndex).getAkting();
            case 5:
                return daftarFilm.get(rowIndex).getRating();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolom[column];
    }
}
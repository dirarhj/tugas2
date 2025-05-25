package Controller;

import Model.Film.DAOFilm;
import Model.Film.InterfaceDAOFilm;
import Model.Film.ModelFilm;
import Model.Film.ModelTable;
import View.*;

import javax.swing.*;
import java.util.List;

public class ControllerFilm {
    ViewFilm halamanTable;
    UpdateView halamanEdit;

    InterfaceDAOFilm daoFilm;
    List<ModelFilm> daftarFilm;

    public ControllerFilm(ViewFilm halamanTable) {
        this.halamanTable = halamanTable;
        this.daoFilm = new DAOFilm();
    }

    public ControllerFilm(UpdateView halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoFilm = new DAOFilm();
    }

    public void showAllFilm() {
        daftarFilm = daoFilm.getAll();
        ModelTable table = new ModelTable(daftarFilm);
        halamanTable.getTableFilm().setModel(table);
    }

    public void insertFilm() {
        try {
            ModelFilm filmBaru = new ModelFilm();

            String judul = halamanTable.getInputJudul();
            float alur = halamanTable.getInputAlur();
            float penokohan = halamanTable.getInputPenokohan();
            float akting = halamanTable.getInputAkting();
            float rating = (alur + penokohan + akting)/3;

            if ("".equals(judul) || "".equals(alur)|| "".equals(penokohan)|| "".equals(akting)) {
                throw new Exception("Harus isi semua yaaa");
            }

            filmBaru.setJudul(judul);
            filmBaru.setAlur(alur);
            filmBaru.setPenokohan(penokohan);
            filmBaru.setAkting(akting);
            filmBaru.setRating(rating);

            daoFilm.insert(filmBaru);

            JOptionPane.showMessageDialog(null, "data berhasil ditambahkan.");

            new ViewFilm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void editFilm(int id) {
        try {
            ModelFilm filmYangMauDiedit = new ModelFilm();

            String judul = halamanEdit.getInputJudul();
            float alur = halamanEdit.getInputAlur();
            float penokohan = halamanEdit.getInputPenokohan();
            float akting = halamanEdit.getInputAkting();
            float rating = (alur + penokohan + akting)/3;

            if ("".equals(judul) || "".equals(alur)|| "".equals(penokohan)|| "".equals(akting)) {
                throw new Exception("Harus isi semua yaaa");
            }

            filmYangMauDiedit.setId(id);
            filmYangMauDiedit.setJudul(judul);
            filmYangMauDiedit.setAlur(alur);
            filmYangMauDiedit.setPenokohan(penokohan);
            filmYangMauDiedit.setAkting(akting);
            filmYangMauDiedit.setRating(rating);

            daoFilm.update(filmYangMauDiedit);

            JOptionPane.showMessageDialog(null, "Data berhasil diubah.");

            halamanEdit.dispose();
            new ViewFilm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteFilm(Integer baris) {
        Integer id = (int) halamanTable.getTableFilm().getValueAt(baris, 0);
        String judul = halamanTable.getTableFilm().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + judul + "?",
                "Hapus Film",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
            daoFilm.delete(id);

            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllFilm();
        }
    }
    
    public void deleteAllFilm() {

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus semua film?",
                "Hapus Film",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
            daoFilm.deleteAll();

            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllFilm();
        }
    }
}
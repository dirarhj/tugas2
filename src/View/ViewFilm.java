package View;

import Controller.ControllerFilm;
import Model.Film.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewFilm extends JFrame {
    Integer baris;
    ControllerFilm controller;
    public JTable tabel;
    public DefaultTableModel tableModel;
    public JTextField tfJudul, tfAlur, tfPenokohan, tfAkting;
    public JButton btnTambah, btnUpdate, btnDelete, btnClear;

    public ViewFilm() {
        setTitle("Data Movie");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        String[] kolom = {"id","Judul", "Alur", "Penokohan", "Akting", "Nilai"};
        tableModel = new DefaultTableModel(kolom, 0);
        tabel = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabel);
        scrollPane.setBounds(30, 30, 700, 600);
        add(scrollPane);

        JLabel lblJudul = new JLabel("Judul");
        lblJudul.setBounds(760, 50, 100, 25);
        add(lblJudul);
        tfJudul = new JTextField();
        tfJudul.setBounds(880, 50, 300, 25);
        add(tfJudul);

        JLabel lblAlur = new JLabel("Alur");
        lblAlur.setBounds(760, 100, 100, 25);
        add(lblAlur);
        tfAlur = new JTextField();
        tfAlur.setBounds(880, 100, 300, 25);
        add(tfAlur);

        JLabel lblPenokohan = new JLabel("Penokohan");
        lblPenokohan.setBounds(760, 150, 100, 25);
        add(lblPenokohan);
        tfPenokohan = new JTextField();
        tfPenokohan.setBounds(880, 150, 300, 25);
        add(tfPenokohan);

        JLabel lblAkting = new JLabel("Akting");
        lblAkting.setBounds(760, 200, 100, 25);
        add(lblAkting);
        tfAkting = new JTextField();
        tfAkting.setBounds(880, 200, 300, 25);
        add(tfAkting);

        btnTambah = new JButton("Tambah");
        btnTambah.setBounds(880, 260, 120, 30);
        add(btnTambah);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(1060, 260, 120, 30);
        add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(880, 310, 120, 30);
        add(btnDelete);

        btnClear = new JButton("Clear");
        btnClear.setBounds(1060, 310, 120, 30);
        add(btnClear);

        setVisible(true);
        
        controller = new ControllerFilm(this);
        controller.showAllFilm();
        
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                baris = tabel.getSelectedRow();
            }
        });

        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.insertFilm();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    ModelFilm filmTerpilih = new ModelFilm();

                    Integer id = (int) tabel.getValueAt(baris, 0);
                    String judul = tabel.getValueAt(baris, 1).toString();
                    String temp = tabel.getValueAt(baris, 2).toString();
                    float alur = Float.parseFloat(temp);
                    temp = tabel.getValueAt(baris, 3).toString();
                    float penokohan = Float.parseFloat(temp);
                    temp = tabel.getValueAt(baris, 4).toString();
                    float akting = Float.parseFloat(temp);

                    filmTerpilih.setId(id);
                    filmTerpilih.setJudul(judul);
                    filmTerpilih.setAlur(alur);
                    filmTerpilih.setPenokohan(penokohan);
                    filmTerpilih.setAkting(akting);

                    dispose();
                    new UpdateView(filmTerpilih);
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    controller.deleteFilm(baris);

                    baris = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });
        
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.deleteAllFilm();
            }
        });
    }

    public JTable getTableFilm() {
        return tabel;
    }
    
    public String getInputJudul(){
        return tfJudul.getText();
    }
    
    public float getInputAlur(){
        return Float.parseFloat(tfAlur.getText());
    }

    
    public float getInputPenokohan(){
        return Float.parseFloat(tfPenokohan.getText());
    }
    
    public float getInputAkting(){
        return Float.parseFloat(tfAkting.getText());
    }
    }


package View;

import Model.Film.ModelFilm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controller.ControllerFilm;

public class UpdateView extends JFrame {
    public JTextField tfJudul, tfAlur, tfPenokohan, tfAkting;
    public JButton btnUpdate, btnBatal;
    ControllerFilm controller;

    public UpdateView(ModelFilm film) {
        setTitle("Update Data Film");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblJudul = new JLabel("Judul:");
        lblJudul.setBounds(30, 30, 100, 25);
        add(lblJudul);
        tfJudul = new JTextField();
        tfJudul.setBounds(140, 30, 200, 25);
        add(tfJudul);

        JLabel lblAlur = new JLabel("Alur:");
        lblAlur.setBounds(30, 70, 100, 25);
        add(lblAlur);
        tfAlur = new JTextField();
        tfAlur.setBounds(140, 70, 200, 25);
        add(tfAlur);

        JLabel lblPenokohan = new JLabel("Penokohan:");
        lblPenokohan.setBounds(30, 110, 100, 25);
        add(lblPenokohan);
        tfPenokohan = new JTextField();
        tfPenokohan.setBounds(140, 110, 200, 25);
        add(tfPenokohan);

        JLabel lblAkting = new JLabel("Akting:");
        lblAkting.setBounds(30, 150, 100, 25);
        add(lblAkting);
        tfAkting = new JTextField();
        tfAkting.setBounds(140, 150, 200, 25);
        add(tfAkting);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(140, 200, 90, 30);
        add(btnUpdate);

        btnBatal = new JButton("Batal");
        btnBatal.setBounds(250, 200, 90, 30);
        add(btnBatal);

        setVisible(true);
        tfJudul.setText(film.getJudul());
        tfAlur.setText(String.format("%.2f", film.getAlur()));
        tfPenokohan.setText(String.format("%.2f", film.getPenokohan()));
        tfAkting.setText(String.format("%.2f", film.getAkting()));
        
        controller = new ControllerFilm(this);
        
        btnBatal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            dispose();
            new ViewFilm();
        }
        });
        
        btnUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            controller.editFilm(film.getId());
        }
        });
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

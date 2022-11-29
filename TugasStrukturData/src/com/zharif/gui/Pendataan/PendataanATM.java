package com.zharif.gui.Pendataan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PendataanATM {
    private JTextField textNomer;
    private JComboBox comboBoxJenis;
    private JComboBox comboBank;
    private JTextField textPemilik;
    private JButton saveButton;
    private JTextArea textArea1;
    private JButton FileButton;
    private JPanel RootPanel;
    private JLabel Pict;

    public String Picture;


    public void insertingDataToFile(String inputtedData) throws IOException {
        try {
            FileWriter myFile = new FileWriter("Data Bank.txt", true);
            myFile.write(inputtedData);
            myFile.close();
            System.out.println("Succesfully wrote to the file");
        } catch (IOException ex) {
            System.out.println("An error occured");
            ex.printStackTrace();
        }
    }

    public PendataanATM() {
        FileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser searchPict = new JFileChooser();

                int showOpenDialogue = searchPict.showOpenDialog(null);

                if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
                    Picture = searchPict.getSelectedFile().getName();

                    File selectPict = searchPict.getSelectedFile();
                    String selectPictPath = selectPict.getAbsolutePath();

                    ImageIcon pi = new ImageIcon(selectPictPath);
                    Image image = pi.getImage().getScaledInstance(Pict.getWidth(), Pict.getHeight(), Image.SCALE_SMOOTH);

                    Pict.setIcon(new ImageIcon(image));
                }

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomer = textNomer.getText();
                String jenis = (String) comboBoxJenis.getSelectedItem();
                String atm= (String) comboBank.getSelectedItem();
                String name = textPemilik.getText();

                user bank = new user();
                bank.setNomer(nomer);
                bank.setJenis(jenis);
                bank.setATM(atm);
                bank.setName(name);

                String hasil = "\nNo Kartu = " + nomer + "\nJenis ATM = " + jenis + "\nBank = " + atm +
                        "\nNama Pemilik = " + name + "\nNama File Gambar = " + Picture;

                textArea1.append(hasil);

                try {
                    insertingDataToFile(hasil + "\n\n");
                    Picture = null;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public JPanel getRootPanel() {
        return RootPanel;
    }
}

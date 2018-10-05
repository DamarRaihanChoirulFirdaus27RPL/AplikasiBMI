/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label judul;
    @FXML
    private Label nama;
    @FXML
    private Label tb;
    @FXML
    private Label umur;
    @FXML
    private TextField masukannama;
    @FXML
    private TextField masukantb;
    @FXML
    private TextField masukanumr;
    @FXML
    private TextArea hasil;
    @FXML
    private Label jenis;
    @FXML
    private RadioButton rdL;
    @FXML
    private RadioButton rdP;
    @FXML
    private Button selesai;
    @FXML
    private Button hapus;

    @FXML
    void selesai(ActionEvent event) {
        double bb = 0;
        String jk;

        if (masukannama.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Harap inputkan Nama");
        } else if (masukantb.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Harap inputkan Tinggi Badan");
        } else if (masukanumr.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Harap inputkan Umur");
        }

        if (rdL.isSelected()) 
            jk = "Laki-Laki";
        else if (rdP.isSelected()) 
            jk = "Perempuan";
        else 
            jk = " ";
        

        if (!(rdL.isSelected() || rdP.isSelected())) {
            JOptionPane.showMessageDialog(null, "Harap pilih Jenis Kelamin!");
        } else {
            String nama = masukannama.getText();
            String umur = masukanumr.getText() + " tahun";
            String tb = masukantb.getText() + " cm";

            int hitung = Integer.parseInt(masukantb.getText());

            if (rdL.isSelected()) 
                bb = hitung-107.5;
            if (rdP.isSelected()) 
                bb = hitung-113;
            

            hasil.setText("========BODY MAKS INDEX========"+
                          "\nNama\t\t: " + nama + 
                          "\nUmur\t\t: " + umur + 
                          "\nTinggi Badan\t: " + tb + 
                          "\nJenis Kelamin\t: " + jk + 
                          "\nBBI\t\t\t: " + bb + " kg"+
                          "\n\n*BBI adalah Berat Badan Ideal");
        }
    }

    @FXML
    private void hapus(ActionEvent event) {

        masukannama.setText("");
        masukanumr.setText("");
        masukantb.setText("");
        rdL.setSelected(false);
        rdP.setSelected(false);

        hasil.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

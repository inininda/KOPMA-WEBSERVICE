/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.BarangHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author basisa25
 */
public class TestTambahBarang {

    public static void main(String[] args) {
        try {          
            String ID_Barang= "002";
            String nama = "Komix";
            int stok = 50;
            double harga = 1000;
            
            BarangHelper helper = new BarangHelper();
            helper.addNewBarang(ID_Barang,nama, stok, harga);
        } catch (Exception ex) {
            Logger.getLogger(TestTambahBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

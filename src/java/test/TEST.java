/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.BarangHelper;
import helper.PegawaiHelper;
import helper.PembelianHelper;
import helper.SupplierHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Barang;
import pojos.Pegawai;
import pojos.Pembelian;
import pojos.Supplier;

/**
 *
 * @author admin
 */
public class TEST {

    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            BarangHelper bh = new BarangHelper();
            PegawaiHelper ph = new PegawaiHelper();
            PembelianHelper blh = new PembelianHelper();
            SupplierHelper sh = new SupplierHelper();

            bh.addNewBarang("002", "Mizone", 20, 4000);
            //ph.addNewPegawai("PG01", "Galih", "0812345", "Jogja", "pegawai01", "mypassword");
            blh.addNewPembelian("002", "TRX03934", 8000, "Lunas");
            sh.addNewSupplier("TK01", "PT. Miz0ne", "0854321", "Jakarta", "supplier01", "mypassword");

            List<Barang> lb = bh.getAllBarang();
            //List<Pegawai> lp = ph.getAllPegawai();
            List<Pembelian> lbl = blh.getAllPembelian();
            List<Supplier> ls = sh.getAllSupplier();
            
            String br = gson.toJson(lb);
            //String pg = gson.toJson(lp);
            String pb = gson.toJson(lbl);
            String sp = gson.toJson(ls);
            
            System.out.println(lb);
            System.out.println("");
            //System.out.println(lp);
            System.out.println("");
            System.out.println(lbl);
            System.out.println("");
            System.out.println(ls);
        } catch (Exception ex) {
            Logger.getLogger(TestTambahBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

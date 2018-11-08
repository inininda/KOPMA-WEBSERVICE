/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Pembelian;
import util.KopmaHibernateUtil;

/**
 *
 * @author basisd10
 */
public class PembelianHelper {
    public List<Pembelian> getAllPembelian() {
        List<Pembelian> result = null;
        Session session = KopmaHibernateUtil.getSessionFactory().openSession();
        String query = "from Pembelian p";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
    public void addNewPembelian(String ID_Barang, String kodeUnik, double jumlah, String statusPembayaran) {
        Session session = KopmaHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Pembelian beli = new Pembelian(ID_Barang,  kodeUnik, jumlah, statusPembayaran);
        session.saveOrUpdate(beli);
        transaction.commit();
        session.close();
    }
}

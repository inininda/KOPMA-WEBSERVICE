/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Transaksi;
import util.kopmaHibernateUtil;

/**
 *
 * @author basisd10
 */
public class TransaksiHelper {
    public List<Transaksi> getAllTransaksi() {
        List<Transaksi> result = null;
        Session session = kopmaHibernateUtil.getSessionFactory().openSession();
        String query = "from Transaksi t";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
    public void addNewTransaksi(String idBarang, String kodeUnik, double jumlahPembayaran, String statusPembayaran, Date tanggalTransaksi) {
        Session session = kopmaHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Transaksi beli = new Transaksi(idBarang, kodeUnik, jumlahPembayaran, statusPembayaran, tanggalTransaksi);
        session.saveOrUpdate(beli);
        transaction.commit();
        session.close();
    }
}

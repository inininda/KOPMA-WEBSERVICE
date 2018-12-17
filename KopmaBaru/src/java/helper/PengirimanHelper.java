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
import pojos.Pengiriman;
import util.kopmaHibernateUtil;

/**
 *
 * @author xanadila
 */
public class PengirimanHelper {
    public List<Pengiriman> getAllPengiriman() {
        List<Pengiriman> result = null;
        Session session = kopmaHibernateUtil.getSessionFactory().openSession();
        String query = "from Pengiriman p";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }

    public void addNewPengiriman(String idKirim, String idBarang, String namaBarang, int jumlahKirim, String statusTerima, Date tanggalKirim){
        Session session = kopmaHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Pengiriman kirim = new Pengiriman(idKirim, idBarang, namaBarang, jumlahKirim, statusTerima, tanggalKirim);
        session.saveOrUpdate(kirim);
        transaction.commit();
        session.close();
    }
}
